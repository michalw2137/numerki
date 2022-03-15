package numeric_methods;

import functions.Function;

import java.util.ArrayList;

public class Secant {

    public static double Iterations(Function f, double a, double b, int iterations) {
        int i = 0;
        double x;
        while ((i<iterations) && (a!=b))
        {
            x =b- f.fun(b) *(b-a)/(f.fun(b)-f.fun(a));
            a=b;
            b=x;
            i++;
        }
        return b;
    }

    public static double Approximity(Function f, double a, double b, double Epsilon) {
        ArrayList<Double> x = new ArrayList<Double>();
        x.add(1000.0);
        x.add(500.0);

        int i = 0;
        double x0 = -1;
        while ((Math.abs(b-a)>Epsilon) && (a!=b))
        {
            x0 =b- f.fun(b) *(b-a)/(f.fun(b)-f.fun(a));
            a=b;
            b=x0;
            i++;
        }
        System.out.println("Epsilon reached in " + i + " iterations");

        return x0;
    }
}
