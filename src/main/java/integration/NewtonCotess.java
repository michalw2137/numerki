package integration;

import functions.Function;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class NewtonCotess {

    public static double simpleSimpson(double a, double b, Function f) {
        double E = 0;
        return (b-a)/6 * (f.fun(a) + 4* f.fun((a+b)/2) + f.fun(b)) + E;
    }

    public static double calculateIntegral(double epsilon, Function F) {
        double sum = 0;
        sum += calculateLimitRight(epsilon, F);
        System.out.println("right limit = " + calculateLimitRight(epsilon, F));
        sum += calculateLimitLeft(epsilon, F);
        System.out.println("left limit = " + calculateLimitLeft(epsilon, F));

        return sum;
    }

    public static double calculateLimitRight(double epsilon, Function f) {
        double sum = 0;
        int  i = 2;
        double a = 0;
        double b = 1./2;
        double integral = calculateIntegralInRange(a, b, f, epsilon);

        while (integral > epsilon) {
            System.out.println("range = <" + a + ", " + b + ">");
            integral = calculateIntegralInRange(a, b, f, epsilon);
            sum += integral;
            i *= 2;

            a = b;
            b += 1. / i;
        }
        return sum;
    }

    private static double calculateIntegralInRange(double a, double b, Function f, double epsilon) {
        int n=1;
        double integral =  complexSimpson(n, a, b, f); //simpleSimpson(a, b, f); // complexSimpson(n, a, b, f); //
        double oldIntegral = 1000;
        while(abs(oldIntegral - integral) > epsilon) {
            oldIntegral = integral;
            integral =  complexSimpson(n, a, b, f); //simpleSimpson(a, b, f); //complexSimpson(n, a, b, f);
            n++;
        }
        return integral;
    }

    public static double calculateLimitLeft(double epsilon, Function f) {
        double sum = 0;
        int  i = 2;
        double a = 0;
        double b = -1./2;
        double integral = calculateIntegralInRange(b, a, f, epsilon);

        while (integral > epsilon) {
            integral = calculateIntegralInRange(b, a, f, epsilon);
            sum += integral;
            i *= 2;

            a = b;
            b -= 1. / i;
        }
        return sum;
    }

    public static ArrayList<Double> getNSubsetsInRange(int n, double a, double b) {
        ArrayList<Double> sets = new ArrayList<>();

        double length = b-a;
        double h = length / (n+1);

        for(int i=0; i<n+2; i++) {
            sets.add(a + i*h);
        }
//        System.out.println("\nsubsets " + sets.size());
        return sets;
    }

    public static double complexSimpson(int n, double a, double b, Function f) {
        var x = getNSubsetsInRange(n, a , b);
        // System.out.println(x);
        double sum = f.fun(x.get(0)) + f.fun(x.get(n+1)); // n=1 - 1 subset, 3 elements: x0, x1, x2
        int i=1;
        double subsum = 0;
        while(i < n+1) {
            subsum += f.fun(x.get(i));
            i += 2;
        }
        sum += subsum*4;

        i=2;
        subsum = 0;

        while(i < n+1) {
            subsum += f.fun(x.get(i));
            i += 2;
        }
        sum += subsum*2;

        double length = b-a;
        double h = length / (n+1);

        return (sum * h) / 3;
    }
}
