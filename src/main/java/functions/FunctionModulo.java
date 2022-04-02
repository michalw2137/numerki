package functions;

import static java.lang.Math.abs;

public class FunctionModulo extends Function{
    public FunctionModulo() {
        super("|x|", -5, 5);
    }

    @Override
    public double fun(double x) {
        return abs(x);
    }
}
