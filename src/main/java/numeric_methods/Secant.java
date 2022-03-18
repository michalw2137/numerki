package numeric_methods;

import functions.Function;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Secant {

    public static double Iterations(Function f, double left, double right, int iterations) {
        int i = 0;
        double x0 = 0;
        while ((i < iterations) && (left != right)) {
            x0 = right - f.fun(right) * (right - left) / (f.fun(right) - f.fun(left));
            left = right;
            right = x0;
            i++;
        }
        System.out.println("Secant: x0 = " + x0);

        return right;
    }

    public static double Approximity(Function f, double left, double right, double Epsilon) {
        ArrayList<Double> x = new ArrayList<>();
        x.add(1000.0);
        x.add(500.0);

        int i = 0;
        double x0 = -1;
        while (abs(x.get(x.size()-2) - x.get(x.size()-1)) > Epsilon) {
            x0 = right - f.fun(right) * (right - left) / (f.fun(right) - f.fun(left));
            x.add(x0);

            left = right;
            right = x0;
            i++;
        }
        System.out.println("Secant: Epsilon reached in " + i + " iterations, x0 = " + x0);

        return x0;
    }
}
