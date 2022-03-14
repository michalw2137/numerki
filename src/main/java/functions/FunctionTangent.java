package functions;

import static java.lang.Math.tan;

public class FunctionTangent extends Function {
    public FunctionTangent() {
        super("tg(x) - 1 = 0", -1.5, 1.5);
        super.setIncrement(0.01); // TODO: find optimal value - nice graph, but minimal calculations
    }

    @Override
    public double fun(double x) {
        return tan(x) - 1;
    }
}
