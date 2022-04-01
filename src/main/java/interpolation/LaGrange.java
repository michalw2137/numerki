package interpolation;

import java.util.ArrayList;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class LaGrange {

    public static ArrayList<Double> getNChebyshevNodes(int n) {
        ArrayList<Double> nodes = new ArrayList<>();
        int k = 1;
        while(k <= n) {
            double node = cos(PI * (2*k - 1) / (2*n));
            nodes.add(node);
//            System.out.println("PI = " + PI);
//            System.out.println("k = " + k);
//            System.out.println("n = " + n);
//            System.out.println("(2*k - 1) = " + (2*k - 1));
//            System.out.println("PI * (2*k - 1) = " + PI * (2*k - 1));
//            System.out.println("2*n = " + 2*n);
//            System.out.println("PI * (2*k - 1) / (2*n) = " + PI * (2*k - 1) / (2*n));
//            System.out.println("cos(PI * (2*k - 1) / (2*n)) = " + cos(PI * (2*k - 1) / (2*n)));
//            System.out.println(cos(PI * (2*k - 1) / 2*n));
            k++;
        }

        return nodes;
    }


}
