package integration;

import functions.Function;

import static java.lang.Math.abs;

public class Simpson {

    public static double integral (Function f, double a, double b, double epsilon) {
        double sum = 0;
        double oldSum = 0;
        double h = 0;
        int n = 1;
        int j = 0;
        do {
            n = n * 2;
            h = (b-a) / n;
            oldSum = sum;
            sum = 0;
            sum += f.fun(a);
            sum += f.fun(b);
            for (int i = 1; i < n; i += 2) {
                sum += 4 * f.fun(a + (i) * h);
                sum += 2 * f.fun(a + (i + 1) * h);
            }
            sum *= h / 3;
            j ++;
        } while (abs(oldSum - sum) > epsilon);
        System.out.println(j);
        return sum;
    }

    public static double limit (Function f, double epsilon) {
        double integral = 0;
        double sum = 0;

        double a = 0;
        double b = 0.5;
        int i = 4;
        do {
            integral = integral(f, a, b, epsilon);
            sum += integral;
            a = b;
            b += 1./i;
            i *= 2;
        } while (abs(integral) > epsilon);

        a = -0.5;
        b = 0;
        i = 4;
        do {
            integral = integral(f, a, b, epsilon);
            sum += integral;
            b = a;
            a -= 1./i;
            i *= 2;
        } while (abs(integral) > epsilon);

        return sum;
    }
}
