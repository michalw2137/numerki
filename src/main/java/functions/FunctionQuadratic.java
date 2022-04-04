package functions;

public class FunctionQuadratic extends Function{

    public FunctionQuadratic() {
        super("2x^2 + 3x - 7", -15, 15);
    }

    @Override
    public double fun(double x) {
        double[] tab = {2, 3, -7};
        return horner(tab, x);
    }
}
