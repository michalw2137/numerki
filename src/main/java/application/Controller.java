package application;

import functions.*;
import numeric_methods.Bisection;
import numeric_methods.Secant;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void startApp() throws IOException {

        Function function;

        function = chooseFunction();

        var arguments = function.calculateArgumentsIntoList(function.getGraphLeft(), function.getGraphRight());
        var values = function.calculateValuesIntoList(function.getGraphLeft(), function.getGraphRight());

        XYSeriesDemo view = new XYSeriesDemo(function.getFormula(), arguments, values, 0);
        view.pack();
        view.setVisible(true);


        double left, right;
        Scanner scan = new Scanner( System.in );
        do {
            do {
                do {
                    System.out.print("Enter left edge:");
                    left = scan.nextDouble();
                } while (left < function.getGraphLeft());
                do {
                    System.out.print("Enter right edge:");
                    right = scan.nextDouble();
                } while (right > function.getGraphRight());
            } while (left > right);
            System.out.println("left = " + left + ", right = " + right);
            System.out.println();
        }while(function.fun(left) * function.fun(right) > 0);

        int decision = 0;
        do {
            System.out.println("Use number of iterations(1) or epsilon(2) ?");
            decision = scan.nextInt();
        }while((decision != 1) && (decision != 2));

        if (decision == 1) {
            System.out.println("Enter number of iterations:");
            int iterations = scan.nextInt();
                double solutionB = Bisection.Iterations(function, left, right, iterations);
                System.out.println("Solution (bisection) found in 10 iterations = " + solutionB);

                double solutionS = Secant.Iterations(function, left, right, iterations);
                System.out.println("Solution (secant) found in 10 iterations = " + solutionS);


        }
        else {
            System.out.println("Enter Epsilon:");
            double epsilon = scan.nextDouble();
                double solutionB = Bisection.Approximity(function, left, right, epsilon);
                System.out.println("Solution (bisection) found when delta reached 0.001 = " + solutionB);
                double solutionS = Secant.Approximity(function, left, right, epsilon);
                System.out.println("Solution (secant) found when delta reached 0.001 = " + solutionS);
            }

        System.out.println();

        // TODO: possibly loop program for multiple inputs, quit on user input
        // TODO: split into functions?

        // TODO: implement another algorithm
        // TODO: store/process results in a friendly way, check report requirements
    }

    static Function chooseFunction() throws IOException {
        System.out.println("CHOOSE FUNCTION:");
        System.out.println("1) " + new FunctionPolynomial().getFormula());
        System.out.println("2) " + new FunctionExponential().getFormula());
        System.out.println("3) " + new FunctionSine().getFormula());
        System.out.println("4) " + new FunctionCosine().getFormula());
        System.out.println("5) " + new FunctionTangent().getFormula());

        System.out.print("Your choice (1-5): ");
        boolean repeat = false;
        do {
            int choice = System.in.read();
            switch (choice - 48) {
                case 1 -> {
                    return new FunctionPolynomial();
                }
                case 2 -> {
                    return new FunctionExponential();
                }
                case 3 -> {
                    return new FunctionSine();
                }
                case 4 -> {
                    return new FunctionCosine();
                }
                case 5 -> {
                    return new FunctionTangent();
                }
                default -> {
                    System.out.println("CHOOSE CORRECT ONE!");
                    System.out.println("Your choice (1-5): ");
                    repeat = true;
                }
            }
        }while (repeat);
        return new FunctionPolynomial();
    }


}
