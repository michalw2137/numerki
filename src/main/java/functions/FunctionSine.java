package functions;

import static java.lang.Math.*;

public class FunctionSine extends Function {
    public FunctionSine() {
        super("3x + sin(x) - e^x = 0", -2, 2.5);
    }

    @Override
    public double fun(double x) {
        return (3*x) + sin(x) - pow(E, x);
    }
}
