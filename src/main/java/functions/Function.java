package functions;

import view.XYSeriesDemo;

import java.util.ArrayList;

public abstract class Function {
    public abstract double fun(double x);

    private final String formula;       // plain text, used as a label
    private final double left, right;     // left, right most graph edge
    private double increment = 0.1;

    protected Function(String formula, double left, double right) {
        this.formula = formula;
        this.left = left;
        this.right = right;
    }

    public String getFormula() {
        return formula;
    }

    public double getLeft () {
        return left;
    }

    public double getRight () {
        return right;
    }

    public void setIncrement(double increment) {
        this.increment = increment;
    }

    public ArrayList<Double> calculateValuesIntoList(double left, double right) {
        ArrayList<Double> values = new ArrayList<>();
        double x = left;
        while (x <= right) {
            values.add(fun(x));
            x += increment;
        }
        return values;
    }

    public ArrayList<Double> calculateValuesIntoList() {
        ArrayList<Double> values = new ArrayList<>();
        double x = left;
        while (x <= right) {
            values.add(fun(x));
            x += increment;
        }
        return values;
    }

    public ArrayList<Double> calculateArgumentsIntoList(double left, double right) {
        ArrayList<Double> arguments = new ArrayList<>();
        double x = left;
        while (x <= right) {
            arguments.add(x);
            x += increment;
        }
        return arguments;
    }

    public ArrayList<Double> calculateArgumentsIntoList() {
        ArrayList<Double> arguments = new ArrayList<>();
        double x = left;
        while (x <= right) {
            arguments.add(x);
            x += increment;
        }
        return arguments;
    }

    public void showGraph() {
        var arguments = calculateArgumentsIntoList();
        var values = calculateValuesIntoList();

        XYSeriesDemo view = new XYSeriesDemo(getFormula(), arguments, values, 0);
        view.pack();
        view.setVisible(true);
    }

    public void showGraph(String name, double left, double right, double zero) {
        var arguments = calculateArgumentsIntoList(left, right);
        var values = calculateValuesIntoList(left, right);

        XYSeriesDemo view = new XYSeriesDemo(name, arguments, values, zero);
        view.pack();
        view.setVisible(true);
    }

    static double horner(double[] poly, double x) {
        double result = poly[0];

        for (int i = 1; i < poly.length; i++)
            result = result * x + poly[i];

        return result;
    }


}
