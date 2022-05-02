package application;

import functions.Function;
import functions.FunctionCosine;
import functions.FunctionExponential;
import functions.FunctionLinear;
import functions.FunctionModulo;
import functions.FunctionPolynomial;
import functions.FunctionQuadratic;
import functions.FunctionSine;
import functions.FunctionTangent;
import integration.NewtonCotess;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.*;

public class ControllerZad4 {

    private static double left = -1;
    private static double right = 1;
    private static Function function;
    private static int nodesNumber;

    private static ArrayList<Double> nodesX;
    private static ArrayList<Double> nodesY;

    private static double integral = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException {
        String choice = "1";
        System.out.println("choose: \n 1) newton-cotess \n 2) gauss-chebyszev");
        choice = scanner.nextLine();

        if (choice.equals("1")) {
            chooseFunction();
            function.showGraph();
            readEdges();
            System.out.println("Integral calculated using simple Newton-Cotess : " + calculateNewton(left, right));

            ArrayList<Double> integrals = new ArrayList<>();
            integrals.add(1000.);
            integrals.add(500.);
            int n=1;
            double epsilon = 0.001;

//            boolean repeat = true;
            while (abs(integrals.get(integrals.size() - 2) - integrals.get(integrals.size() - 1)) > epsilon) {
//                try {
//                    repeat = integrals.get(integrals.size() - 1) - integrals.get(integrals.size() - 2) < epsilon;
//                    System.out.println("delta = " + (integrals.get(integrals.size() - 1) - integrals.get(integrals.size() - 2)) + ", repeat = " + repeat);
//                } catch (IndexOutOfBoundsException e) {
//                    repeat = true;
//                }
                integrals.add(NewtonCotess.complexSimpson(n, left, right, function));
//                System.out.println("loop");
                System.out.println("n=" + n + ", I=" + integrals.get(integrals.size()-1));
                n++;
            }
            function.showGraph("Integrated function", left, right, 0);
        }

        if (choice.equals("2")) {
            chooseFunction();

            ArrayList<Double> xs = new ArrayList<>();
            ArrayList<Double> ys = new ArrayList<>();

            for(double x=left+0.01; x<right; x+=0.01) {
                xs.add(x);
                ys.add(function.fun(x) / sqrt(1 - x*x));
            }

            XYSeriesDemo view = new XYSeriesDemo("Integrated function p(x)*f(x)", xs, ys, 0);
            view.pack();
            view.setVisible(true);

            readNodesNumber();

            doCalculations();
            System.out.println("Integral = " + integral);
            showResults();

            System.out.println("\n======== CALCULATIONS PERFORMED SUCCESFULLY ========\n");

        }
    }

    private static double calculateNewton(double a, double b) {
        double E = 0;
        return (b-a)/6 * (function.fun(a) + 4*function.fun((a+b)/2) + function.fun(b)) + E;
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
                        "Your choice (0-9): ");
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
                case 0 -> throw new RuntimeException("Program ended by user");
                default -> System.out.println( "CHOOSE CORRECT ONE!" + '\n' +
                        "Your choice (1-5): ");
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

    public static void doCalculations() {
        nodesX = LaGrange.getNChebyshevNodes(nodesNumber, left, right);
        nodesY = LaGrange.calculateValuesInNodes(nodesNumber, left, right, function);

        LaGrange laGrange = new LaGrange(nodesX, nodesY);

        for (int i=0; i<nodesNumber; i++) {
            integral += (PI / (nodesNumber+1)) * laGrange.fun(nodesX.get(i));
            System.out.println("A" + i + " = " + (PI / (nodesNumber+1)));
            System.out.println("x" + i + " = " + nodesX.get(i));
            System.out.println("A*x = " + (PI / (nodesNumber+1)) * nodesX.get(i));

            System.out.println();
        }
    }

    public static void showResults() {
        LaGrange laGrange = new LaGrange(nodesX, nodesY);

        ArrayList<Double> xs = new ArrayList<>();
        ArrayList<Double> ys = new ArrayList<>();

        for(double x=left+0.01; x<right; x+=0.01) {
            xs.add(x);
            ys.add(laGrange.fun(x) / sqrt(1 - x*x));
        }

        XYSeriesDemo view = new XYSeriesDemo("Interpolated function p(x)*f(x)", xs, ys, 0);
        view.pack();
        view.setVisible(true);
    }

    public static void setFunction (Function function) {
        ControllerZad4.function = function;
    }

    public static void setNodesNumber(int nodesNumber) {
        ControllerZad4.nodesNumber = nodesNumber;
    }
}
