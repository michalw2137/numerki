package interpolation;

import functions.Function;

import java.util.ArrayList;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class LaGrange extends Function{

    private ArrayList<Double> args;
    private ArrayList<Double> vals;

    public LaGrange(ArrayList<Double> args, ArrayList<Double> vals) {
        super("interpolating polynomial", -5, 5);
        this.args = args;
        this.vals = vals;
    }

    public void setArgs(ArrayList<Double> args) {
        this.args = args;
    }

    public void setVals(ArrayList<Double> vals) {
        this.vals = vals;
    }

    public static ArrayList<Double> getNChebyshevNodes(int n, double a, double b) {
        ArrayList<Double> nodes = new ArrayList<>();
        int k = 1;
        while(k <= n) {
            double cos = cos(PI * (2*k - 1) / (2*n));
            nodes.add((a+b)/2 + cos*(b-a)/2);
            k++;
        }
        return nodes;
    }

    public static ArrayList<Double> calculateValuesInNodes(int n, double a, double b, Function function) {
        var nodes = getNChebyshevNodes(n, a, b);
        ArrayList<Double> values = new ArrayList<>();
        for (double node: nodes) {
            values.add(function.fun(node));
        }
        return values;
    }

    public Double interpolation(double x) {
        double solution = 0;
        for (int i=0; i< args.size(); i++) {
            solution += vals.get(i) * multiply(x, i) / multiply(args.get(i), i);
        }
        return solution;
    }

    private Double multiply(double xToSubstractFrom, int indexToSkip) {
        double solution = 1;
        for (int i=0; i< args.size(); i++) {
            if (i != indexToSkip) {
                solution *= xToSubstractFrom - args.get(i);
            }
        }
        return solution;
    }

    @Override
    public double fun(double x) {
        return interpolation(x);
    }
}
