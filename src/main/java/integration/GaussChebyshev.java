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
        for (int i=0; i<n; i++) {
            sum += (A(i) * f.fun(x(i)));
//            System.out.println("n = " + n);
//            System.out.println("A(" + i + ") = " + A(i));
//            System.out.println("x(" + i + ") = " + x(i));
//            System.out.println("f(x(" + i + ")) = " + f.fun(x(i)));
//            System.out.println("A*f = " + (A(i) * f.fun(x(i))));
//            System.out.println();
        }
        return sum;
    }

    private static double A(int i) {
        return PI/(n+1);
    }

    private static double x(double i) {
        //return cos((((2*i)-1) / (2*n)) * PI);
        return cos(((2*i + 1) / (2*n + 2)) * PI);
        //return cos(PI * (2*i + 1) / (2*n + 2));
    }
}
