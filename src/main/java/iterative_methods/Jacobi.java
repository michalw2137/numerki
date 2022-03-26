package iterative_methods;

import structures.Matrix;
import structures.Vector;

import java.util.ArrayList;

public class Jacobi {

    public static boolean isCorrect(Matrix matrix) {
        for (int i=0; i<matrix.getSize(); i++) {
            for (int ii=0; ii<matrix.getSize(); ii++) {
                if (matrix.getAt(i, ii) >= matrix.getAt(i, i))
                if (i != ii)
                    return false;
            }
        }
        return true;
    }

    public static Vector doCalculations(Matrix A, Vector x, Vector b) {
        double [] x2 = new double[A.getSize()];
        for (int i=0; i<A.getSize(); i++) {
            x2[i] = (-1 * sumAX(A, x, i) + b.getAt(i)) / A.getAt(i, i);
        }
        return new Vector(x2);
    }

    private static double sumAX (Matrix A,Vector x, int i) {
        double sum = 0;
        for (int j=0; j<A.getSize(); j++) {
            if (j != i)
                sum += A.getAt(i, j) * x.getAt(j);
        }
        return sum;
    }
}
