package application;

import functions.*;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.round;

public class Controller {

    private static final Scanner scanner = new Scanner(System.in);

    public static boolean endByApproximation () {
        System.out.print("End by iterations(1) or epsilon(2)?: ");
        while (true) {
            try {
                int answer = scanner.nextInt();
                return answer == 2;
            } catch (InputMismatchException e) {
                System.out.println("invalid choice!");
            }
        }
    }

    static Function chooseFunction() throws RuntimeException{
        var polynomial = new FunctionPolynomial();
        var exponential = new FunctionExponential();
        var sine = new FunctionSine();
        var cosine = new FunctionCosine();
        var cosine2 = new FunctionCosine2();
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
                        "7) " + cosine2.getFormula()  + "\n" +

                        "8) " + exponential.getFormula() + "\n" +
                        "9) custom polynomial" + "\n" +

                        "0) exit \n\n" +
                        "Your choice (0-9): ");
        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    return modulo;
                }
                case 2 -> {
                    return linear;
                }
                case 3 -> {
                    return quadratic;
                }
                case 4 -> {
                    return polynomial;
                }
                case 5 -> {
                    return sine;
                }
                case 6 -> {
                    return cosine;
                }
                case 7 -> {
                    return cosine2;
                }
                case 8 -> {
                    return exponential;
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

                    return new FunctionPolynomial(n, coefficients, makeFormula(n, coefficients));
                    
                }
                case 0 -> {
                    throw new RuntimeException("Program ended by user");
                }
                default -> {
                    System.out.println( "CHOOSE CORRECT ONE!" + '\n' +
                            "Your choice (1-5): ");
                }
            }
        }
    }


    public static String makeFormula(int[] coefficients, int n) {
        StringBuilder formula = new StringBuilder();
        int i = 0;
        while (i <= n) {
            if (coefficients[i] > 0) {
                formula.append("+");
            }
            formula.append(round(coefficients[i]))
                    .append('x')
                    .append("^")
                    .append(n-i)
                    .append(" ");
            i++;
        }
        return formula.toString();
    }

    public static String makeFormula(int n, double[] coefficients) {
        StringBuilder formula = new StringBuilder();
        int i = 0;
        while (i <= n) {
            if (coefficients[i] > 0) {
                formula.append("+");
            }
            formula.append(round(coefficients[i]))
                    .append('x')
                    .append("^")
                    .append(n-i)
                    .append(" ");
            i++;
        }
        return formula.toString();
    }

    public static double[] readEdges() {
        while (true) {
            try {
                return tryToReadEdges();
            } catch (IOException | RuntimeException e) {
                System.out.println(e.getMessage() + '\n');
            }
        }
    }

    private static double[] tryToReadEdges () throws IOException, RuntimeException {
        System.out.print("Enter left edge: ");
        double left = scanner.nextDouble();

        System.out.print("Enter right edge: ");
        double right = scanner.nextDouble();

        if (left >= right) {
            throw new IOException("Invalid range!");
        }

        System.out.println("\nselected range: <" + left + ", " + right + ">");
        System.out.println();

        return new double[]{left, right};
    }

    public static int readInt (String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                scanner.next();
            }
        }
    }

    public static double readDouble (String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
                scanner.next();
            }
        }
    }

    public static void graph2Functions(Function f1, Function f2, double a, double b) {
        ArrayList<Double> x1 = f1.calculateArgumentsIntoList(a, b);
        ArrayList<Double> y1 = f1.calculateValuesIntoList(a, b);

        ArrayList<Double>  x2 = f2.calculateArgumentsIntoList(a, b);
        ArrayList<Double>  y2 = f2.calculateValuesIntoList(a, b);

        ArrayList<Double> nodesX = new ArrayList<>(){{add(0.);}};
        ArrayList<Double> nodesY = new ArrayList<>(){{add(0.);}};

        XYSeriesDemo view = new XYSeriesDemo(x1, y1, x2, y2, nodesX, nodesY);
        view.pack();
        view.setVisible(true);
    }

    public static int factorial(int n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

}
