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
        function = Controller.chooseFunction();

        function.showGraph("", function.getLeft(), function.getRight(), 0 );

        double[] edges = Controller.readEdges();
        left = edges[0];
        right = edges[1];

        endByApproximation = Controller.endByApproximation();

        if (endByApproximation) {
            epsilon = Controller.readDouble("Enter epsilon: ");
        } else {
            iterations = Controller.readInt("Enter iterations number: ");
        }

        calculateSolutions();

        showResults();

        System.out.println();
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
