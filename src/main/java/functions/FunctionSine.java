package functions;

import static java.lang.Math.*;

public class FunctionSine extends Function {
    public FunctionSine() {
        super("3x + sin(x) - e^x = 0", 0, 10);
    }

    @Override
    public double fun(double x) {
        return (3*x) + sin(x) - pow(E, x);
    }
}
