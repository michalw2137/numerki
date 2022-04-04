package application;

import functions.*;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerZad3 {

    private static double left, right;
    private static Function function;
    private static int nodesNumber;

    private static ArrayList<Double> nodesX;
    private static ArrayList<Double> nodesY;

    private static ArrayList<Double> interpolatedX;
    private static ArrayList<Double> interpolatedY;

    private static ArrayList<Double> interpolatingX;
    private static ArrayList<Double> interpolatingY;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        chooseFunction();
        function.showGraph();

        readEdges();

        readNodesNumber();

        doCalculations();

        showResults();

        System.out.println("\n======== CALCULATIONS PERFORMED SUCCESFULLY ========\n");
    }

    static void chooseFunction() throws RuntimeException{
        var polynomial = new FunctionPolynomial();
        var exponential = new FunctionExponential();
        var sine = new FunctionSine();
        var cosine = new FunctionCosine();
        var tangent = new FunctionTangent();
        var linear = new FunctionLinear();
        var modulo = new FunctionModulo();
        var quadratic = new FunctionQuadratic();

        System.out.println("CHOOSE FUNCTION:");
        System.out.println(
                "1) " + modulo.getFormula()  + "\n" +
                "2) " + linear.getFormula()  + "\n" +
                "3) " + quadratic.getFormula()  + "\n" +
                "4) " + polynomial.getFormula() + "\n" +

                "5) " + sine.getFormula() + "\n" +
                "6) " + cosine.getFormula() + "\n" +
                "7) " + tangent.getFormula()  + "\n" +

                "8) " + exponential.getFormula() + "\n" +
                "9) custom polynomial" + "\n" +

                "0) exit \n\n" +
                "Your choice (1-5): ");
        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    function = modulo;
                    return;
                }
                case 2 -> {
                    function = linear;
                    return;
                }
                case 3 -> {
                    function = quadratic;
                    return;
                }
                case 4 -> {
                    function = polynomial;
                    return;
                }
                case 5 -> {
                    function = sine;
                    return;
                }
                case 6 -> {
                    function = cosine;
                    return;
                }
                case 7 -> {
                    function = tangent;
                    return;
                }
                case 8 -> {
                    function = exponential;
                    return;
                }
                case 9 -> {
                    System.out.println("Enter degree of polynomial:");
                    int n = scanner.nextInt();
                    int i = 0;
                    double[] coefficients = new double[n+1];
                    while (i <= n) {
                        System.out.println("Enter coefficient #" + (i+1) + ": ");
                        coefficients[i] = scanner.nextDouble();
                        i++;
                    }
                    System.out.println("\nYour function:");
                    System.out.println(makeFormula(n, coefficients));
                    System.out.println();

                    function = new FunctionPolynomial(n, coefficients, makeFormula(n, coefficients));
                    return;
                }
                case 0 -> {
                    throw new RuntimeException("Program ended by user");
                }
                default -> {
                    System.out.println( "CHOOSE CORRECT ONE!" + '\n' +
                            "Your choice (1-5): ");
                }
            }
        }
    }

    private static String makeFormula(int n, double[] coefficients) {
        StringBuilder formula = new StringBuilder();
        int i = 0;
        while (i <= n) {
            if (coefficients[i] > 0) {
                formula.append("+");
            }
            formula.append(coefficients[i])
                    .append('x')
                    .append("^")
                    .append(n-i)
                    .append(" ");
            i++;
        }
        return formula.toString();
    }
    private static void readEdges() {
        while (true) {
            try {
                tryToReadEdges();
                return;
            } catch (IOException | RuntimeException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }
    }

    private static void tryToReadEdges () throws IOException, RuntimeException {
        System.out.print("Enter left edge: ");
        left = scanner.nextDouble();

        System.out.print("Enter right edge: ");
        right = scanner.nextDouble();

        if (left >= right) {
            throw new IOException("Invalid range!");
        }

        System.out.println("\nselected range: <" + left + ", " + right + ">");
        System.out.println();

    }

    private static void readNodesNumber() {
        while (true) {
            try {
                tryToReadNodesNumber();
                return;
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                scanner.next();
            }
        }
    }

    private static void tryToReadNodesNumber() throws InputMismatchException {
        System.out.print("Enter nodes number: ");
        nodesNumber = scanner.nextInt();
    }

    public static void doCalculations() {
        nodesX = LaGrange.getNChebyshevNodes(nodesNumber, left, right);
        nodesY = LaGrange.calculateValuesInNodes(nodesNumber, left, right, function);
        LaGrange laGrange = new LaGrange(nodesX, nodesY);

        interpolatedX = function.calculateArgumentsIntoList(left, right);
        interpolatedY = function.calculateValuesIntoList(left, right);

        interpolatingX = laGrange.calculateArgumentsIntoList(left, right);
        interpolatingY = laGrange.calculateValuesIntoList(left, right);
    }

    public static void showResults() {
        XYSeriesDemo view = new XYSeriesDemo(interpolatedX, interpolatedY, interpolatingX, interpolatingY, nodesX, nodesY);
        view.pack();
        view.setVisible(true);
    }

    public static void setFunction (Function function) {
        ControllerZad3.function = function;
    }

    public static void setRange(double left, double right) {
        ControllerZad3.left = left;
        ControllerZad3.right = right;
    }

    public static void setNodesNumber(int nodesNumber) {
        ControllerZad3.nodesNumber = nodesNumber;
    }
}
