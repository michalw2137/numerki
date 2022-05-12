package functions;

public class FunctionQuadratic extends Function{

    public FunctionQuadratic() {
        super("2x^2 + x - 2", -15, 15);
    }

    @Override
    public double fun(double x) {
        double[] tab = {2, 1, -2};
        return horner(tab, x);
    }
}
