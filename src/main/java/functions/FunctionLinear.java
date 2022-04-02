package functions;

public class FunctionLinear extends Function{
    public FunctionLinear() {
        super("2x + 1", -5, 5);
    }

    @Override
    public double fun(double x) {
        return 2*x + 1;
    }
}
