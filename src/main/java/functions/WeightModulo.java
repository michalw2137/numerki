package functions;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class WeightModulo extends Function{
    public WeightModulo() {
        super("1/sqrt(1-x^2) * |x|", -1 + 0.001, 1 - 0.001);
        super.setIncrement(0.001);

    }

    @Override
    public double fun(double x) {
        return abs(x) / sqrt(1-x*x);
    }
}
