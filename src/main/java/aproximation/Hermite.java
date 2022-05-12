package aproximation;

import functions.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Hermite {
    private static final int[] H0 = new int[] {1};
    private static final int[] H1 = new int[] {2, 0};
    static ArrayList<int[]> polynomials = new ArrayList<>(){{
        add(H0);
        add(H1);
    }};

    private static int currentPolynomial=1;
    private static double length = 2;

    public static int[] getNthPolynomial (int n) {
        if (n < 2) {
            return polynomials.get(n);
        }
        int[] poly = new int[n+1];
        int[] Hn = Hn(n);
        int i=0;
        int j=0;
        while (i<n) {
            poly[i] = Hn[j];
            i++;
            j++;
            if (i<n) {
                poly[i] = 0;
                i++;
            }
        }
        return poly;
    }

    public static int[] Hn (int n) {
        if (n < polynomials.size()) {
            return polynomials.get(n);
        }
        generateNPolynomials(n);
        return polynomials.get(n);
    }

    public static void generateNPolynomials(int highestDegree) {
        for (int k = currentPolynomial; k < highestDegree; k++) {
            int[] Hn = new int[(int) length];
            length += 0.5;
            currentPolynomial ++;

            for (int ii = 0; ii<Hn.length; ii++) {
                Hn[ii] = 2 * Hn1(ii) -  2 * k * Hn2(ii-1);
            }
            polynomials.add(Hn);
//            for (int p: Hn) {
//                System.out.print(p + "\t");
//            }
//            System.out.println();
        }
    }

    private static int Hn1(int i) {
        if (i < 0) {
            return 0;
        }
        if (i >= polynomials.get(currentPolynomial-1).length) {
            return 0;
        }
        return polynomials.get(currentPolynomial-1)[i];
    }

    private static int Hn2(int i) {
        if (i < 0) {
            return 0;
        }
        if (i >= polynomials.get(currentPolynomial-2).length) {
            return 0;
        }
        return polynomials.get(currentPolynomial-2)[i];
    }

}
