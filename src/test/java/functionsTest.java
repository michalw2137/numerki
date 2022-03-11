import functions.*;
import org.junit.Test;
import view.XYSeriesDemo;

import java.sql.SQLOutput;

import static org.junit.Assert.assertEquals;

public class functionsTest {

    @Test
    public void testFormulas() {
        Function polynomial = new FunctionPolynomial();
        assertEquals("x^3 - x^2 -2x + 1 = 0", polynomial.getFormula());

        Function exponential = new FunctionExponential();
        assertEquals("2^x -3x = 0", exponential.getFormula());

        Function cosine = new FunctionCosine();
        assertEquals("2 + cos(2x) = 0", cosine.getFormula());

        Function tangent = new FunctionTangent();
        assertEquals("tg(x) - 1 = 0", tangent.getFormula());

        Function sine = new FunctionSine();
        assertEquals("3x + sin(x) - e^x = 0", sine.getFormula());

    }

    @Test
    public void test2() {
        Function polynomial = new FunctionPolynomial();
        Function exponential = new FunctionExponential();
        Function sine = new FunctionSine();
        Function cosine = new FunctionCosine();
        Function tangent = new FunctionTangent();

        var arguments = polynomial.calculateArgumentsIntoList(-10, 10);
        var values = polynomial.calculateValuesIntoList(-10, 10);

        System.out.println(arguments);
        System.out.println();

//        System.out.println(polynomial.calculateValuesIntoList(-10, 10));
//        System.out.println(exponential.calculateValuesIntoList(-10, 10));
//        System.out.println(sine.calculateValuesIntoList(-10, 10));
//        System.out.println(cosine.calculateValuesIntoList(-10, 10));
//        System.out.println(tangent.calculateValuesIntoList(-10, 10));

        XYSeriesDemo view = new XYSeriesDemo("Polynomial graph", arguments, values, 0);
        view.pack();
        view.setVisible(true);
    }
}