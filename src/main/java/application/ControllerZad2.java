package application;

import files.Reader;
import iterative_methods.Jacobi;
import structures.Matrix;
import structures.Vector;

import java.io.IOException;
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

    public static void startApp() throws RuntimeException, IOException {
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

    private static void readBfromFile () throws IOException {
        Reader read = new Reader();
        A = new Matrix(read.readMatrix("src/main/java/files/A.txt"));
    }

    private static void readXfromFile () throws IOException {  
        Reader read = new Reader();
        x = new Vector(read.readVector("src/main/java/files/x.txt"));
    }

    private static void readAfromFile () throws IOException {
        Reader read = new Reader();
        b = new Vector(read.readVector("src/main/java/files/b.txt"));
    }

    private static void readExpectedFromFile () throws IOException {
        Reader read = new Reader();
        expected = new Vector(read.readVector("src/main/java/files/expected.txt"));
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
