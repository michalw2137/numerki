package functions;

import static java.lang.Math.tan;

public class FunctionTangent extends Function {
    public FunctionTangent() {
        super("tg(x) - 1 = 0", -5, 5);
        super.setIncrement(0.02);
    }

    @Override
    public double fun(double x) {
        return tan(x) - 1;
    }
}
