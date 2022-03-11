package functions;

import java.util.ArrayList;

public abstract class Function {
    private final String formula;

    protected Function(String formula) {
        this.formula = formula;
    }

    public abstract double fun(double x);

    public String getFormula() {
        return formula;
    }

    public ArrayList<Double> calculateValuesIntoList(double left, double right) {
        ArrayList<Double> values = new ArrayList<>();
        double x = left;
        while (x < right) {
            values.add(fun(x));
            x += 0.1;
        }
        return values;
    }

    public ArrayList<Double> calculateArgumentsIntoList(double left, double right) {
        ArrayList<Double> arguments = new ArrayList<>();
        double x = left;
        while (x < right) {
            arguments.add(x);
            x += 0.1;
        }
        return arguments;
    }
}
