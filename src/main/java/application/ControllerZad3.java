package application;

import functions.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerZad3 {

    private static double left, right;
    private static Function function;
    private static int nodesNumber;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        chooseFunction();

        readEdges();

        readNodesNumber();

        

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

    public static void setFunction (Function function) {
        ControllerZad3.function = function;
    }

    public static void setRange(double left, double right) {
        if( function.fun(left) * function.fun(right) > 0) {
            throw new RuntimeException("Same sign edges!");
        }
        ControllerZad3.left = left;
        ControllerZad3.right = right;
    }

}
