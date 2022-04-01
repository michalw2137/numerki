package interpolation;

import java.util.ArrayList;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class LaGrange {

    public static ArrayList<Double> getNChebyshevNodes(int n, double a, double b) {
        ArrayList<Double> nodes = new ArrayList<>();
        int k = 1;
        while(k <= n) {
            double cos = cos(PI * (2*k - 1) / (2*n));
            nodes.add((a+b)/2 + cos*(b-a)/2);
            k++;
        }

        return nodes;
    }


}
