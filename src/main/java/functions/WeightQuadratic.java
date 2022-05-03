package functions;

import static java.lang.Math.sqrt;

public class WeightQuadratic extends Function{
    public WeightQuadratic() {
        super("1/sqrt(1-x^2) * (2*x + 1)", -1 + 0.001, 1 - 0.001);
        super.setIncrement(0.001);
    }

    @Override
    public double fun(double x) {
        double[] tab = {2, 3, -7};
        return (horner(tab, x)) / sqrt(1-x*x);
    }
}
