import interpolation.LaGrange;
import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

public class interpolationTests {

    @Test
    public void testNodes() {
        for(int i=1; i<20; i++){
            var nodes = LaGrange.getNChebyshevNodes(i);
            System.out.printf("n = " + i + ": ");
            for(Double node: nodes) {
                System.out.format("%.5f, ", node);
            }
            System.out.println();
        }
    }




}