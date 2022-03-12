package numeric_methods;

import functions.Function;

import java.util.ArrayList;

public class Bisection {

    public static double Iterations(Function f, double left, double right, int iterations) {
        int i = 0;
        double x0 = (left + right) / 2;
        while (i < iterations) {
            x0 = (left + right) / 2;
            if (f.fun(x0) == 0) {
                System.out.println("Solution found in just " + i + " iterations");
                return x0;
            }
            if (f.fun(left) * f.fun(x0) < 0) {
                right = x0;
            } else {
                left = x0;
            }
            i++;
        }
        return x0;
    }

    public static double Approximity(Function f, double left, double right, double Epsilon) {
        ArrayList<Double> x = new ArrayList<Double>();
        x.add(1000.0);
        x.add(500.0);

        int i = 0;
        double x0 = (left + right) / 2;
        while (x.get(x.size()-2) - x.get(x.size()-1) > Epsilon) { // TODO: consider possible rewrite, x.size()-1 is inelegant
            x0 = (left + right) / 2;
            x.add(x0);

            if (f.fun(x0) == 0) {
                System.out.println("Solution found quickly in just " + i + " iterations");
                return x0;
            }
            if (f.fun(left) * f.fun(x0) < 0) {
                right = x0;
            } else {
                left = x0;
            }
            i++;
        }
        System.out.println("Epsilon reached in " + i + " iterations");

        return x0;
    }
}
