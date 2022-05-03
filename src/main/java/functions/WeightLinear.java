package functions;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class WeightLinear extends Function{
    public WeightLinear() {
        super("1/sqrt(1-x^2) * (2x^2 + 3x - 7)", -1 + 0.001, 1 - 0.001);
        super.setIncrement(0.01);
    }

    @Override
    public double fun(double x) {
        return (2*x + 1) / sqrt(1-x*x);
    }
}
