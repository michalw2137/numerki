package application;

import functions.Function;
import functions.FunctionLinear;
import functions.FunctionModulo;
import functions.FunctionPolynomial;
import functions.FunctionQuadratic;
import functions.WeightLinear;
import functions.WeightModulo;
import functions.WeightPolynomial;
import functions.WeightQuadratic;
import integration.GaussChebyshev;
import integration.Simpson;

import java.util.Scanner;

public class ControllerZad4 {

    private static Function f;
    private static Function F;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException {
        chooseFunction();

        F.showGraph();

        System.out.println("Enter epsilon: ");
        double epsilon = scanner.nextDouble();

        System.out.println("Integral calculated using limits (complex Simpson): " + Simpson.limit(F, epsilon));

        for (int n = 2; n <= 5; n++) {
            System.out.println("Integral [" + n + " nodes] = " + GaussChebyshev.calculateIntegral(n, f));
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

}
