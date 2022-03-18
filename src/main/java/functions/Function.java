package functions;

import java.util.ArrayList;

public abstract class Function {
    public abstract double fun(double x);

    private final String formula;       // plain text, used as a label
    private final double graphLeft;     // left most graph edge
    private final double graphRight;    // right most graph edge

    protected Function(String formula, double graphLeft, double graphRight) {
        this.formula = formula;
        this.graphLeft = graphLeft;
        this.graphRight = graphRight;
    }

    public String getFormula() {
        return formula;
    }

    public double getGraphLeft() {
        return graphLeft;
    }

    public double getGraphRight() {
        return graphRight;
    }

    private double increment = 0.1;

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public ArrayList<Double> calculateValuesIntoList(double left, double right) {
        ArrayList<Double> values = new ArrayList<>();
        double x = left;
        while (x < right) {
            values.add(fun(x));
            x += increment;
        }
        return values;
    }

    public ArrayList<Double> calculateArgumentsIntoList(double left, double right) {
        ArrayList<Double> arguments = new ArrayList<>();
        double x = left;
        while (x < right) {
            arguments.add(x);
            x += increment;
        }
        return arguments;
    }

    static double horner(int[] poly, int n, double x)
    {
        // Initialize result
        double result = poly[0];

        // Evaluate value of polynomial using Horner's method
        for (int i=1; i<n; i++)
            result = result*x + poly[i];

        return result;
    }
}
