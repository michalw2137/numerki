import functions.*;
import interpolation.LaGrange;
import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Double.valueOf;
import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;

public class interpolationTests {

    @Test
    public void testNodes() {
        for(int i=1; i<20; i++){
            var nodes = LaGrange.getNChebyshevNodes(i, 0, 2);
            System.out.print("n = " + i + ": ");
            for(Double node: nodes) {
                System.out.format("%.5f, ", node);
            }
            System.out.println();
        }
    }

    @Test
    public void testValuesInNodes() {
        var valCos = LaGrange.calculateValuesInNodes(10, -1, 1, new FunctionCosine());
        var valSin = LaGrange.calculateValuesInNodes(10, -1, 1, new FunctionSine());
        var valTan = LaGrange.calculateValuesInNodes(10, -1, 1, new FunctionTangent());
        var valExp = LaGrange.calculateValuesInNodes(10, -1, 1, new FunctionExponential());
        var valPol = LaGrange.calculateValuesInNodes(10, -1, 1, new FunctionPolynomial());
        System.out.println(valCos);
        System.out.println(valSin);
        System.out.println(valTan);
        System.out.println(valExp);
        System.out.println(valPol);
    }

    @Test
    public void testInterpolation() {
        var args = new ArrayList<Double>(Arrays.asList(1., 2., 3.));
        var vals = new ArrayList<Double>(Arrays.asList(0., 1., 4.));
        LaGrange lg = new LaGrange(args, vals);

        var f0 = lg.interpolation(0);
        var f1 = lg.interpolation(1);
        var f2 = lg.interpolation(2);
        var f3 = lg.interpolation(3);
        var f4 = lg.interpolation(4);
        assertEquals(f0, valueOf(1));
        assertEquals(f1, valueOf(0));
        assertEquals(f2, valueOf(1));
        assertEquals(f3, valueOf(4));
        assertEquals(f4, valueOf(9));


    }



}