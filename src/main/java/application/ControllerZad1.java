package application;

import functions.*;
import numeric_methods.Bisection;
import numeric_methods.Secant;

import java.io.IOException;
import java.util.Scanner;

public class ControllerZad1 {

    private static double left, right;
    private static Function function;
    private static boolean endByApproximation = false;
    private static int iterations = 10;
    private static double epsilon = 0.001;
    private static double solutionS, solutionB;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        chooseFunction();

        function.showGraph("", function.getLeft(), function.getRight(), 0 );

        readEdges();

        readEndingCondition();

        readEndingValue();

        calculateSolutions();

        showResults();

        System.out.println();
    }

    static void chooseFunction() throws RuntimeException{
        System.out.println("CHOOSE FUNCTION:");
        System.out.println( "1) " + new FunctionPolynomial().getFormula() + "\n" +
                            "2) " + new FunctionExponential().getFormula() + "\n" +
                            "3) " + new FunctionSine().getFormula() + "\n" +
                            "4) " + new FunctionCosine().getFormula() + "\n" +
                            "5) " + new FunctionTangent().getFormula()  + "\n" +
                            "9) exit \n\n" +
                            "Your choice (1-5): ");
        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    function = new FunctionPolynomial();
                    return;
                }
                case 2 -> {
                    function = new FunctionExponential();
                    return;
                }
                case 3 -> {
                    function = new FunctionSine();
                    return;
                }
                case 4 -> {
                    function = new FunctionCosine();
                    return;
                }
                case 5 -> {
                    function = new FunctionTangent();
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
         if( function.fun(left) * function.fun(right) > 0) {
             throw new RuntimeException("Same sign edges!");
         }

        System.out.println("\nselected range: <" + left + ", " + right + ">");
        System.out.println();

    }

    private static void readEndingCondition () {
        System.out.print("End by iterations(1) or epsilon(2)?: ");
        int answer = scanner.nextInt();
        endByApproximation = answer == 2;
    }

    private static void readEndingValue () {
        if (endByApproximation) {
            System.out.println("Enter epsilon: ");
            epsilon = scanner.nextDouble();

        } else {
            System.out.println("Enter number of iterations: ");
            iterations = scanner.nextInt();
        }
    }

    public static void calculateSolutions () {
        if (endByApproximation) {
            solutionB = Bisection.approximity(function, left, right, epsilon);
            solutionS = Secant.approximity(function, left, right, epsilon);

        } else {
            solutionB = Bisection.iterations(function, left, right, iterations);
            solutionS = Secant.iterations(function, left, right, iterations);
        }
    }

    public static void showResults() {
        var arguments = function.calculateArgumentsIntoList(left, right);
        var values = function.calculateValuesIntoList(left, right);

        function.showGraph(" bisection", left, right, solutionB);
        function.showGraph(" secant", left, right, solutionS);
    }


    public static void setFunction (Function function) {
        ControllerZad1.function = function;
    }

    public static void setRange(double left, double right) {
        if( function.fun(left) * function.fun(right) > 0) {
            throw new RuntimeException("Same sign edges!");
        }
        ControllerZad1.left = left;
        ControllerZad1.right = right;
    }

    public static void setIterations (int iterations) {
        ControllerZad1.endByApproximation = false;
        ControllerZad1.iterations = iterations;
    }

    public static void setEpsilon (double epsilon) {
        ControllerZad1.endByApproximation = true;
        ControllerZad1.epsilon = epsilon;
    }

    public static double getSolutionS () {
        return solutionS;
    }

    public static double getSolutionB () {
        return solutionB;
    }
}
