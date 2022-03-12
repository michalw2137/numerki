package application;

import functions.*;
import numeric_methods.Bisection;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void startApp() throws IOException {
        System.out.println("CHOOSE FUNCTION:");
        System.out.println("1) " + new FunctionPolynomial().getFormula());
        System.out.println("2) " + new FunctionExponential().getFormula());
        System.out.println("3) " + new FunctionSine().getFormula());
        System.out.println("4) " + new FunctionCosine().getFormula());
        System.out.println("5) " + new FunctionTangent().getFormula());

        System.out.print("Your choice (1-5): ");

        Function function;
        int choice  = System.in.read();
        switch (choice - 48) {
            case 1 -> {
                function = new FunctionPolynomial();
            }
            case 2 -> {
                function = new FunctionExponential();
            }
            case 3 -> {
                function = new FunctionSine();
            }
            case 4 -> {
                function = new FunctionCosine();
            }
            case 5 -> {
                function = new FunctionTangent();
            }
            default -> {
                throw new RuntimeException("Choice out of scope!"); // TODO: keep asking to enter a number until correct
            }
        }

        var arguments = function.calculateArgumentsIntoList(function.getGraphLeft(), function.getGraphRight());
        var values = function.calculateValuesIntoList(function.getGraphLeft(), function.getGraphRight());

        XYSeriesDemo view = new XYSeriesDemo(function.getFormula(), arguments, values, 0);
        view.pack();
        view.setVisible(true);


        double left, right;
        Scanner scan = new Scanner( System.in );
        System.out.print("Enter left edge:"); // TODO: check, if edges are in graph scope?
        left = scan.nextDouble();
        System.out.print("Enter left edge:"); // TODO: check, if right > left?
        right = scan.nextDouble();
        System.out.println("left = " + left + ", right = " + right);
        System.out.println();

        if (function.fun(left) * function.fun(right) > 0) {
            throw new RuntimeException("Edges are the same sign!"); // TODO: keep asking for edges until signs differ
        }

        double solution = Bisection.Iterations(function, left, right, 10);  // TODO: ask for iterations number
        System.out.println("Solution found in 10 iterations = " + solution);
        solution = Bisection.Approximity(function, left, right, 0.001);      // TODO: ask for Epsilon
        System.out.println("Solution found when delta reached 0.001 = " + solution);
        System.out.println();

        System.out.println("Wolfram alpha: x0 = -1,247");

        // TODO: possibly loop program for multiple inputs, quit on user input
        // TODO: split into functions?
        // TODO: implement makeshift javafx GUI instead of console?

        // TODO: implement another algorithm
        // TODO: store/process results in a friendly way, check report requirements
    }

}
