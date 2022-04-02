
import files.Reader;

import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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
//        double [][] test = read.readMatrix("src/main/java/files/A.txt");
//        System.out.println(Arrays.deepToString(test));
    }

    @Test
    public void testReadArguments() throws FileNotFoundException {
        assertEquals(new ArrayList<Double>(Arrays.asList(1., 2., 3., 4., 5.)),
                Reader.readArguments("src/files_interpolation/test.txt"));
        assertEquals(new ArrayList<Double>(Arrays.asList(10., -11., 12., -13., 14.)),
                Reader.readValues("src/files_interpolation/test.txt"));
    }
}
