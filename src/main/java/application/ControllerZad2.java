package application;

import files.Reader;
import iterative_methods.Jacobi;
import structures.Matrix;
import structures.Vector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ControllerZad2 {

    private static Matrix A;
    private static Vector b;
    private static Vector x;
    private static Vector solution;
    private static Vector expected;

    private static String expectedInfo;
    private static String directory;

    private static boolean endByApproximation = false;
    private static int iterations = 10;
    private static double epsilon = 0.001;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Reader read = new Reader();


    public static void startApp() throws RuntimeException, IOException, IllegalAccessException {
        readDirectory();

        readAfromFile();

        if (!Jacobi.isCorrect(A)) {
            System.out.println("matrix A:");
            A.print();
            throw new RuntimeException("Matrix isnt diagonally dominant");
        }

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

    private static void readDirectory () throws IllegalAccessException {
        System.out.println("Choose matrix:");
        System.out.println("a/b/c/d/e/f/g/h/i/j/custom");
        do {
            directory = scanner.nextLine();
            if (Objects.equals(directory, "q")) {
                throw new IllegalAccessException("User ended program");
            }
        } while (!Objects.equals(directory, "a")
                && !Objects.equals(directory, "b")
                && !Objects.equals(directory, "c")
                && !Objects.equals(directory, "d")
                && !Objects.equals(directory, "e")
                && !Objects.equals(directory, "f")
                && !Objects.equals(directory, "g")
                && !Objects.equals(directory, "h")
                && !Objects.equals(directory, "i")
                && !Objects.equals(directory, "j")
                && !Objects.equals(directory, "custom"));
    }

    private static void readAfromFile () throws IOException {
        A = new Matrix(read.readMatrix("src/examples/" + directory + "/A.txt"));
    }

    private static void readXfromFile () throws IOException {  
        x = new Vector(read.readVector("src/examples/" + directory + "/x.txt"));
    }

    private static void readBfromFile () throws IOException {
        b = new Vector(read.readVector("src/examples/" + directory + "/b.txt"));
    }

    private static void readExpectedFromFile () throws IOException {
        try {
            expected = new Vector(read.readVector("src/examples/" + directory + "/expected.txt"));
        } catch (NumberFormatException | IOException e) {
            expectedInfo = read.readString("src/examples/" + directory + "/expected.txt");
        }
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
            System.out.println(expectedInfo);
        }

        System.out.println("========================================================================================================================");
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
