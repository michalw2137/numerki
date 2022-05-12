package functions;

public class FxF extends Function{
    private final Function f1;
    private final Function f2;

    public FxF (Function f1, Function f2) {
        super("f(x)*g(x)", -10, 10);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double fun (double x) {
        return f1.fun(x) * f2.fun(x);
    }
}
