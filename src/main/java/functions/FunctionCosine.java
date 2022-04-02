package functions;

import static java.lang.Math.cos;

public class FunctionCosine extends Function {

    public FunctionCosine() {
        super("2 * cos(2x) = 0", -6, 6);
    }

    @Override
    public double fun(double x) {
        return 2 * cos(2*x);
    }
}
