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
        }while(function.fun(left) * function.fun(right) > 0);
        System.out.println("left = " + left + ", right = " + right);
        System.out.println();

        int decision = 0;
        do {
            System.out.println("Use number of iterations(1) or epsilon(2) ?");
            decision = scan.nextInt();
        }while((decision != 1) && (decision != 2));

        if (decision == 1) {
            System.out.println("Enter number of iterations:");
            int iterations = scan.nextInt();

            showResultsIt(left, right, function, iterations);

        }
        else {
            System.out.println("Enter Epsilon:");
            double epsilon = scan.nextDouble();

            showResultsAp(left, right, function, epsilon);
        }

        System.out.println();

        // TODO: possibly loop program for multiple inputs, quit on user input
        // TODO: split into functions?

        // TODO: implement another algorithm
        // TODO: store/process results in a friendly way, check report requirements
    }


    static void showResultsIt(double left, double right, Function function, int iterations) {
        var arguments = function.calculateArgumentsIntoList(left, right);
        var values = function.calculateValuesIntoList(left, right);

        double solutionS = Bisection.Iterations(function, left, right, iterations);
        XYSeriesDemo view = new XYSeriesDemo("bisekcji " + function.getFormula(), arguments, values, solutionS);
        view.pack();
        view.setVisible(true);

        double solutionB = Secant.Iterations(function, left, right, iterations);
        XYSeriesDemo view2 = new XYSeriesDemo("siecznych " + function.getFormula(), arguments, values, solutionB);
        view2.pack();
        view2.setVisible(true);
    }

    static void showResultsAp(double left, double right, Function function, double epsilon) {
        var arguments = function.calculateArgumentsIntoList(left, right);
        var values = function.calculateValuesIntoList(left, right);

        double solutionS = Bisection.Approximity(function, left, right, epsilon);
        XYSeriesDemo view = new XYSeriesDemo("bisekcji " + function.getFormula(), arguments, values, solutionS);
        view.pack();
        view.setVisible(true);

        double solutionB = Secant.Approximity(function, left, right, epsilon);
        XYSeriesDemo view2 = new XYSeriesDemo("siecznych " + function.getFormula(), arguments, values, solutionB);
        view2.pack();
        view2.setVisible(true);
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
