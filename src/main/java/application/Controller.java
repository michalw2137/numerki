package application;

import functions.*;
import numeric_methods.Bisection;
import numeric_methods.Secant;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Controller {

    private static double left, right;
    private static Function function;
    private static boolean endByApproximation = false;
    private static int iterations = 10;
    private static double epsilon = 0.001;
    private static double solutionS;
    private static double solutionB;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        chooseFunction();

        showGraph(function.getGraphLeft(), function.getGraphRight(), 0);

        readEdges(function);

        readEndingCondition();

        readEndingValue();

        showResults(left, right, function, solutionB, solutionS);

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

    private static void showGraph (double left, double right, double zero) {
        var arguments = function.calculateArgumentsIntoList(left, right);
        var values = function.calculateValuesIntoList(function.getGraphLeft(), function.getGraphRight());

        XYSeriesDemo view = new XYSeriesDemo(function.getFormula(), arguments, values, zero);
        view.pack();
        view.setVisible(true);
    }

    private static void readEdges(Function function) {
        do {
            System.out.print("Enter left edge: ");
            left = scanner.nextDouble();

            System.out.print("Enter right edge: ");
            right = scanner.nextDouble();
        } while( function.fun(left) * function.fun(right) > 0 &&
                left >= right);
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
            solutionS = Bisection.Approximity(function, left, right, epsilon);
            solutionB = Secant.Approximity(function, left, right, epsilon);


        } else {
            System.out.println("Enter number of iterations: ");
            iterations = scanner.nextInt();
            solutionS = Bisection.Iterations(function, left, right, iterations);
            solutionB = Secant.Iterations(function, left, right, iterations);
        }
    }

    static void showResults(double left, double right, Function function, double solutionB, double solutionS) {
        var arguments = function.calculateArgumentsIntoList(left, right);
        var values = function.calculateValuesIntoList(left, right);

        XYSeriesDemo view = new XYSeriesDemo("bisekcji ", arguments, values, solutionB);
        view.pack();
        view.setVisible(true);

        XYSeriesDemo view2 = new XYSeriesDemo("siecznych ", arguments, values, solutionS);
        view2.pack();
        view2.setVisible(true);
    }


    public static void setFunction (Function function) {
        Controller.function = function;
    }

    public static void setLeft (double left) {
        Controller.left = left;
    }

    public static void setRight (double right) {
        Controller.right = right;
    }

    public static void endByEpsilon () {
        Controller.endByApproximation = true;
    }

    public static void endByIteratios () {
        Controller.endByApproximation = false;
    }

    public static void setIterations (int iterations) {
        Controller.iterations = iterations;
    }

    public static void setEpsilon (double epsilon) {
        Controller.epsilon = epsilon;
    }
}
