import functions.*;
import interpolation.LaGrange;
import iterative_methods.Jacobi;
import org.junit.Test;
import structures.Matrix;
import structures.Vector;

import java.util.ArrayList;
import java.util.Arrays;

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
        var valCos = LaGrange.calculateValuesInNodes(LaGrange.getNChebyshevNodes(10, -1, 1), new FunctionCosine());
        var valSin = LaGrange.calculateValuesInNodes(LaGrange.getNChebyshevNodes(10, -1, 1), new FunctionSine());
        var valTan = LaGrange.calculateValuesInNodes(LaGrange.getNChebyshevNodes(10, -1, 1), new FunctionTangent());
        var valExp = LaGrange.calculateValuesInNodes(LaGrange.getNChebyshevNodes(10, -1, 1), new FunctionExponential());
        var valPol = LaGrange.calculateValuesInNodes(LaGrange.getNChebyshevNodes(10, -1, 1), new FunctionPolynomial());
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
        var f0 = LaGrange.interpolation(0, args, vals);
        var f1 = LaGrange.interpolation(1, args, vals);
        var f2 = LaGrange.interpolation(2, args, vals);
        var f3 = LaGrange.interpolation(3, args, vals);
        var f4 = LaGrange.interpolation(4, args, vals);
        assertEquals(f0, new Double(1));
        assertEquals(f1, new Double(0));
        assertEquals(f2, new Double(1));
        assertEquals(f3, new Double(4));
        assertEquals(f4, new Double(9));


    }



}