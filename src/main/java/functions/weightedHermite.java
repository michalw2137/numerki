package functions;

import static java.lang.Math.E;
import static java.lang.Math.pow;

public class weightedHermite extends Function{

    private Function function;
    private int k;

    protected weightedHermite (Function function, int k) {
        super(function.getFormula()+" * Hk * e^(-x^2)", -5, 5);
    }

    @Override
    public double fun (double x) {
        return function.fun(x) * pow(E, -(x*x)) ;
    }
}
