package functions;

import static java.lang.Math.pow;

public class FunctionExponential extends Function {
    public FunctionExponential() {
        super("2^x -3x = 0", -6, 6);
    }

    @Override
    public double fun(double x) {
        return pow(2, x) - (3*x);
    }
}
