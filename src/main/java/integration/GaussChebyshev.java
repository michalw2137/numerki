package integration;

import functions.Function;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class GaussChebyshev {
    private static int n;

    public static double calculateIntegral(int n_, Function f) {
        n = n_;
        double sum = 0;
        System.out.println();
        for (int i=1; i<=n; i++) {
            sum += (A(i) * f.fun(x(i)));
        }
        return sum;
    }

    private static double A(int i) {
        return PI/(n);
    }

    private static double x(double i) {
        return -cos(((2 * i - 1) * PI) / (2 * n));
    }
}
