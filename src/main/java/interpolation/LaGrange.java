package interpolation;

import functions.Function;

import java.util.ArrayList;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class LaGrange {

    private static ArrayList<Double> args;
    private static ArrayList<Double> vals;

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

    public static ArrayList<Double> calculateValuesInNodes(ArrayList<Double> nodes, Function function) {
        ArrayList<Double> values = new ArrayList<>();
        for (double node: nodes) {
            values.add(function.fun(node));
        }
        return values;
    }

    public static Double interpolation(double x, ArrayList<Double> args, ArrayList<Double> vals) {
        LaGrange.args = args;
        LaGrange.vals = vals;

        double solution = 0;
        for (int i=0; i< args.size(); i++) {
            solution += vals.get(i) * multiply(x, i) / multiply(args.get(i), i);
        }
        return solution;
    }

    private static Double multiply(double xToSubstractFrom, int indexToSkip) {
        double solution = 1;
        for (int i=0; i< args.size(); i++) {
            if (i != indexToSkip) {
                solution *= xToSubstractFrom - args.get(i);
            }
        }
        return solution;
    }
}
