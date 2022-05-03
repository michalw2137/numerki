package functions;

import static java.lang.Math.sqrt;

public class WeightPolynomial extends Function{
    double[] coefficients = new double[]{1, -1, -2, 1};

    public WeightPolynomial() {
        super("1/sqrt(1-x^2) * (x^3 - x^2 - 2x + 1)", -1 + 0.001, 1 - 0.001);
        super.setIncrement(0.001);

    }

    @Override
    public double fun(double x) {
        return (horner(coefficients, x)) / sqrt(1-x*x);
    }
}
