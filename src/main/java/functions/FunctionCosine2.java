package functions;

import static java.lang.Math.cos;

public class FunctionCosine2 extends Function{
    public FunctionCosine2() {
        super("cos(2x^2 + 1)", -2, 2);
    }

    @Override
    public double fun(double x) {
        return cos(2*x*x+1);
    }
}
