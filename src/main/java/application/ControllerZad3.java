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

        System.out.println("CHOOSE FUNCTION:");
        System.out.println( "1) " + polynomial.getFormula() + "\n" +
                "2) " + exponential.getFormula() + "\n" +
                "3) " + sine.getFormula() + "\n" +
                "4) " + cosine.getFormula() + "\n" +
                "5) " + tangent.getFormula()  + "\n" +
                "6) " + linear.getFormula()  + "\n" +
                "7) " + modulo.getFormula()  + "\n" +

                "9) exit \n\n" +
                "Your choice (1-5): ");
        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    function = polynomial;
                    return;
                }
                case 2 -> {
                    function = exponential;
                    return;
                }
                case 3 -> {
                    function = sine;
                    return;
                }
                case 4 -> {
                    function = cosine;
                    return;
                }
                case 5 -> {
                    function = tangent;
                    return;
                }
                case 6 -> {
                    function = linear;
                    return;
                }
                case 7 -> {
                    function = modulo;
                    return;
                }
                case 9 -> {
                    throw new RuntimeException("Program ended by user");
                }
                default -> {
                    System.out.println( "CHOOSE CORRECT ONE!" + '\n' +
                            "Your choice (1-5): ");
                }
            }
        }
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
