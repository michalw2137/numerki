package application;

import functions.*;
import numeric_methods.Bisection;
import numeric_methods.Secant;

import java.io.IOException;
import java.util.Scanner;

public class ControllerZad2 {

    private static double left, right;
    private static Function function;
    private static boolean endByApproximation = false;
    private static int iterations = 10;
    private static double epsilon = 0.001;
    private static double solutionS, solutionB;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
//        readAfromFile();
//        readXfromFile();
//        readBfromFile();

        readEndingCondition();

        readEndingValue();

        calculateSolutions();

        showResults();

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
        ControllerZad2.function = function;
    }

    public static void setRange(double left, double right) {
        if( function.fun(left) * function.fun(right) > 0) {
            throw new RuntimeException("Same sign edges!");
        }
        ControllerZad2.left = left;
        ControllerZad2.right = right;
    }

    public static void setIterations (int iterations) {
        ControllerZad2.endByApproximation = false;
        ControllerZad2.iterations = iterations;
    }

    public static void setEpsilon (double epsilon) {
        ControllerZad2.endByApproximation = true;
        ControllerZad2.epsilon = epsilon;
    }

    public static double getSolutionS () {
        return solutionS;
    }

    public static double getSolutionB () {
        return solutionB;
    }
}
