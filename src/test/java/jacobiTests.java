import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

public class jacobiTests {

    @Test
    public void testJacobi() {
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
            System.out.println();
        }

    }

    @Test
    public void testIterations() {
        double[][] m = {{1, 0.2, 0.3},
                {0.1, 1, -0.3},
                {-0.1, -0.2, 1}};
        Matrix A = new Matrix(m);
        Vector x = new Vector(new double[]{0, 0, 0});
        Vector b = new Vector(new double[]{1.5, 0.8, 0.7});

        for (int i=0; i <= 10; i++) {
            System.out.println("Iterations = " + i);
            Jacobi.iterations(A, x, b, i).print();
            System.out.println();
        }
    }

    @Test
    public void testApproximity() {
        double[][] m = {{1, 0.2, 0.3},
                {0.1, 1, -0.3},
                {-0.1, -0.2, 1}};
        Matrix A = new Matrix(m);
        Vector x = new Vector(new double[]{0, 0, 0});
        Vector b = new Vector(new double[]{1.5, 0.8, 0.7});

        for (int i=1; i < 1000; i*=2) {
            System.out.println("epsilon = " + 1./i);
            Jacobi.approximity(A, x, b, 1./i).print();
            System.out.println();
        }
    }

}