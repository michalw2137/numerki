package iterative_methods;

import structures.Matrix;
import structures.Vector;

import static java.lang.Math.abs;

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

    public static Vector iterations(Matrix A, Vector x, Vector b, int iterations) {
        if (!isCorrect(A)) {
            throw new RuntimeException("Matrix doesnt meet sufficient conditions!");
        }
        var tempx = x;
        for (int i = 0; i < iterations; i++) {
            tempx = Jacobi.doCalculations(A, tempx, b);
        }
        return tempx;
    }

    public static Vector approximity(Matrix A, Vector x, Vector b, double epsilon) {
        if (!isCorrect(A)) {
            throw new RuntimeException("Matrix doesnt meet sufficient conditions!");
        }
        int iterations = 1;
        var tempx = Jacobi.doCalculations(A, x, b);

        while (!reachedEpsilon(x, tempx, epsilon)) {
            x = tempx;
            tempx = Jacobi.doCalculations(A, tempx, b);

            iterations ++;
        }
        System.out.println("Iterations = " + iterations);
        return tempx;
    }

    private static boolean reachedEpsilon(Vector oldX, Vector newX, double epsilon) {
        for (int i=0; i<oldX.getSize(); i++) {
            if (abs(oldX.getAt(i) - newX.getAt(i)) > epsilon) {
                return false;
            }
        }
        return true;
    }

}
