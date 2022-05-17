package functions;

import static java.lang.Math.pow;

public class differenceSquared extends Function{

    private Function f1;
    private Function f2;

    public differenceSquared (Function f1, Function f2) {
        super("("+f1.getFormula()+"-"+f2.getFormula()+")^2", -5, 5);
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public double fun (double x) {
        return  pow(f1.fun(x) - f2.fun(x), 2);
    }
}
