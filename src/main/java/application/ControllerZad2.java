package application;

import iterative_methods.Jacobi;
import structures.Matrix;
import structures.Vector;

import java.util.Scanner;

public class ControllerZad2 {

    private static Matrix A;
    private static Vector b;
    private static Vector x;
    private static Vector solution;
    private static Vector expected;

    private static boolean endByApproximation = false;
    private static int iterations = 10;
    private static double epsilon = 0.001;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        readAfromFile();
        readXfromFile();
        readBfromFile();
        readExpectedFromFile();

        printInfo();

        readEndingCondition();

        readEndingValue();

        calculateSolutions();

        showResults();

        System.out.println();
    }

    private static void readBfromFile () {  // TODO: implement reading from file
        double[][] j = {{1, 0.2, 0.3},
                        {0.1, 1, -0.3},
                        {-0.1, -0.2, 1}};
        double[][] d = {{0.5,       -0.0625,    0.1875, 0.0625},
                        {-0.0625,   0.5,        0,      0},
                        {0.1875,    0 ,         0.375,  0.125},
                        {0.0625,    0,          0.125,  0.25}};
        A = new Matrix(d);
    }

    private static void readXfromFile () {  // TODO: implement reading from file
        double[] j = {0, 0, 0};
        double[] d = {0, 0, 0, 0};

        x = new Vector(d);
    }

    private static void readAfromFile () {  // TODO: implement reading from file
        double[] j = {1.5, 0.8, 0.7};
        double[] d = {1.5, -1.625, 1, 0.4375};
        b = new Vector(d);
    }

    private static void readExpectedFromFile () {  // TODO: implement reading from file
        double[] j = {1, 1, 1};
        double[] d = {2, -3, 1.5, 0.5};
        expected = new Vector(d);
    }

    private static void printInfo() {
        System.out.println("Matrix A:");
        A.print();
        System.out.println("Vector x:");
        x.print();
        System.out.println();
        System.out.println("Vector b:");
        b.print();
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
            solution = Jacobi.approximity(A, x, b, epsilon);

        } else {
            solution = Jacobi.iterations(A, x, b, iterations);
        }
    }

    public static void showResults() {
        System.out.println();
        System.out.println("CALCULATED RESULT:");
        solution.print();
        try {
            System.out.println("\nEXPECTED RESULT:");
            expected.print();
        } catch (NullPointerException ignored){
            System.out.println("expected result not specified");
        }

        System.out.println("\n========================================\n");
    }

    public static void setIterations (int iterations) {
        ControllerZad2.endByApproximation = false;
        ControllerZad2.iterations = iterations;
    }

    public static void setEpsilon (double epsilon) {
        ControllerZad2.endByApproximation = true;
        ControllerZad2.epsilon = epsilon;
    }

    public static Vector getSolution () {
        return solution;
    }

}
