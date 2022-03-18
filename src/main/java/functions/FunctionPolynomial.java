package functions;

public class FunctionPolynomial extends Function {


    public FunctionPolynomial() {
        super("x^3 - x^2 -2x + 1 = 0", -3, 3);
    }

    @Override
    public double fun(double x) {
        int[] tab = {1,-1,-2,1};
//        return x*x*x - x*x - 2*x + 1;
        return horner(tab, tab.length, x);
    }
}
