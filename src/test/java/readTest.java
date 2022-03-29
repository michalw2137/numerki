
import files.Reader;

import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

import java.io.IOException;
import java.util.Arrays;

public class readTest {
    @Test
    public void testRead() throws IOException {
        double[][] m = {{1, 0.2, 0.3},
                {0.1, 1, -0.3},
                {-0.1, -0.2, 1}};
        Matrix A = new Matrix(m);
        Vector x = new Vector(new double[]{0, 0, 0});
        Vector b = new Vector(new double[]{1.5, 0.8, 0.7});

        Reader read = new Reader();
        //read.read("src/main/java/files/b.txt");
        //read.readVector("src/main/java/files/b.txt");
        double [][] test = read.readMatrix("src/main/java/files/A.txt");
        System.out.println(Arrays.deepToString(test));
    }
}
