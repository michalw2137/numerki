package functions;

public class FunctionPolynomial extends Function {


    public FunctionPolynomial() {
        super("x^3 - x^2 -2x + 1 = 0", -1.5, 2);
    }

    @Override
    public double fun(double x) {
        return (x*x*x) - (x*x) - (2*x) + 1; // TODO: zapisać to schematem Hornera
                                        // 1 + x(-2 + x(x -1)) coś takiego? double check
    }
}
