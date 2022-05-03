package integration;

import functions.Function;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class NewtonCotess {

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

    public static double simpleSimpson(double a, double b, Function f) {
        double E = 0;
        return (b-a)/6 * (f.fun(a) + 4* f.fun((a+b)/2) + f.fun(b)) + E;
    }

    public static double calculateIntegral(double epsilon, Function F) {
        double sum = 0;
        int n=1;
        sum += NewtonCotess.calculateLimitLeft(n, epsilon, F);
        sum += NewtonCotess.calculateLimitRight(n, epsilon, F);
        return sum;
    }

    public static double calculateLimitRight(int n, double epsilon, Function f) {
        double sum = 0;
        int  i = 2;
        double a = 0;
        double b = 1./i;
        double integral = simpleSimpson(a, b, f);
        while (integral > epsilon) {
            integral = complexSimpson(n, a, b, f);
            sum += integral;
            i *= 2;

            a = b;
            b += 1. / i;
        }
        return sum;
    }

    public static double calculateLimitLeft(int n, double epsilon, Function f) {
        double sum = 0;
        int  i = 2;
        double a = 0;
        double b = -1./i;
        double integral = simpleSimpson(b, a, f);
        while (abs(integral) > epsilon) {
            integral = complexSimpson(n, b, a, f);
            sum += integral;
            i *= 2;

            a = b;
            b -= 1. / i;
        }
        return sum;
    }

    public static double complexSimpson(int n, double a, double b, Function f) {
        var x = getNSubsetsInRange(n, a , b);

//        System.out.println(x);
        double sum = f.fun(x.get(0)) + f.fun(x.get(n+1)); // n=1 - 1 subset, 3 elements: x0, x1, x2
//        System.out.println("SUM = " + sum);
        int i=1;
        double subsum = 0;
//        System.out.println("sumbsum 4(f1 + f3...)");
        while(i < n+1) {
//            System.out.println("f(x" + i + ") = f(" + x.get(i) + ") = "  + f.fun(x.get(i)));
            subsum += f.fun(x.get(i));
            i += 2;
        }
//        System.out.println("SUBSUM = " + subsum);
        sum += subsum*4;
//        System.out.println("NEW SUM = " + sum);

        i=2;
        subsum = 0;
//        System.out.println("sumbsum 2(f2 + f4...)");

        while(i < n+1) {
//            System.out.println("f(x" + i + ") = f(" + x.get(i) + ") = " + f.fun(x.get(i)) );

            subsum += f.fun(x.get(i));
            i += 2;
        }
//        System.out.println("SUBSUM = " + subsum);
        sum += subsum*2;
//        System.out.println("NEW SUM = " + sum);

        double length = b-a;
        double h = length / (n+1);
//        System.out.println("simpson");
//        System.out.println();
        return sum * h / 3;
    }
}
