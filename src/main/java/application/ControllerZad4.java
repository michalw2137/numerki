package application;

import functions.*;
import integration.GaussChebyshev;
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
    private static Function f;
    private static Function F;
    private static int nodesNumber;

    private static ArrayList<Double> nodesX;
    private static ArrayList<Double> nodesY;

    private static double integral = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException {
        chooseFunction();

        F.showGraph();

        System.out.println("Enter epsilon: ");
        double epsilon = scanner.nextDouble();

        System.out.println("Integral calculated using limits (complex Simpson): " + NewtonCotess.calculateIntegral(epsilon, F));

        for (nodesNumber = 2; nodesNumber <= 5; nodesNumber++) {
//            System.out.println(f.getFormula());
            System.out.println("Integral [" + nodesNumber + " nodes] = " + GaussChebyshev.calculateIntegral(nodesNumber, f));
        }

        System.out.println("\n======== CALCULATIONS PERFORMED SUCCESFULLY ========\n");
    }

    static void chooseFunction() throws RuntimeException{
        var modulo = new FunctionModulo();
        var linear = new FunctionLinear();
        var quadratic = new FunctionQuadratic();
        var polynomial = new FunctionPolynomial();

        System.out.println("CHOOSE FUNCTION:");
        System.out.println(
                "1) " + modulo.getFormula()  + ", I = 2\n" +
                "2) " + linear.getFormula()  + ", I = pi ~ 3,1416\n" +
                "3) " + quadratic.getFormula()  + ", I = -6pi ~ -18,85\n" +
                "4) " + polynomial.getFormula() + ", I = pi/2 ~ 1,57\n" +

                "0) exit \n\n" +
                "Your choice (1-4): ");
        while(true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    f = modulo;
                    F = new WeightModulo();
                    return;
                }
                case 2 -> {
                    f = linear;
                    F = new WeightLinear();
                    return;
                }
                case 3 -> {
                    f = quadratic;
                    F = new WeightQuadratic();
                    return;
                }
                case 4 -> {
                    f = polynomial;
                    F = new WeightPolynomial();
                    return;
                }

                case 0 -> throw new RuntimeException("Program ended by user");
                default -> System.out.println( "CHOOSE CORRECT ONE!" + '\n' +
                        "Your choice (1-4): ");
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
        nodesY = LaGrange.calculateValuesInNodes(nodesNumber, left, right, f);

        LaGrange laGrange = new LaGrange(nodesX, nodesY);
        integral = 0;
        for (int i=0; i<nodesNumber; i++) {
            integral += (PI / (nodesNumber+1)) * laGrange.fun(nodesX.get(i));
//            System.out.println("A" + i + " = " + (PI / (nodesNumber+1)));
//            System.out.println("x" + i + " = " + nodesX.get(i));
//            System.out.println("A*x = " + (PI / (nodesNumber+1)) * nodesX.get(i));

//            System.out.println();
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

        XYSeriesDemo view = new XYSeriesDemo("Interpolated function p(x)*f(x) " + nodesNumber + " nodes", xs, ys, 0);
        view.pack();
        view.setVisible(true);
    }

    public static void setF(Function f) {
        ControllerZad4.f = f;
    }

    public static void setNodesNumber(int nodesNumber) {
        ControllerZad4.nodesNumber = nodesNumber;
    }
}
