package integration;

import functions.Function;

import java.util.ArrayList;

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

    public static double complexSimpson(int n, double a, double b, Function f) {
        var x = getNSubsetsInRange(n, a , b);
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
//        System.out.println("simpson");
        return sum * h / 3;
    }
}
