import iterative_methods.Jacobi;
import structures.Matrix;
import structures.Vector;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double[][] m = {{1, 0.2, 0.3},
                        {0.1, 1, -0.3},
                        {-0.1, -0.2, 1}};
        Matrix A = new Matrix(m);
        Vector x = new Vector(new double[]{0, 0, 0});
        Vector b = new Vector(new double[]{1.5, 0.8, 0.7});

        System.out.println(Jacobi.isCorrect(A));

        var tempx = x;
        for (int i = 0; i < 20; i++) {
            tempx.print();
            tempx = Jacobi.doCalculations(A, tempx, b);
        }

    }
}
