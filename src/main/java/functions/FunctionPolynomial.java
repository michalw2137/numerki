package functions;

import java.util.ArrayList;

public class FunctionPolynomial extends Function {
    private final int n;
    private final double[] coefficients;

    public FunctionPolynomial() {
        super("x^3 - x^2 - 2x + 1", -20, 20);

        n = 3;
        coefficients = new double[]{1, -1, -2, 1};
    }

    public FunctionPolynomial(int n, double [] coefficients, String formula) {
        super(formula, -20, 20);

        this.n = n;
        this.coefficients = coefficients;
    }

    @Override
    public double fun(double x) {
        return horner(coefficients, x);
    }


}
