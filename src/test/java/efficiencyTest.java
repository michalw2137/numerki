import application.Controller;
import functions.*;
import org.junit.Test;
import  java.lang.StringBuilder;

import static org.junit.Assert.assertEquals;

public class efficiencyTest {

    public void calculateEpsilon(Function function, double left, double right, double epsilon) {
        String str = "\n\nTEST   " + function.getClass().getSimpleName() + " <" + left + ", " + right + ">, ε = " + epsilon + "\n|";
        System.out.println(str);

        function.showGraph();

        Controller.setFunction(function);

        Controller.setRange(left, right);
        Controller.setEpsilon(epsilon);
        Controller.calculateSolutions();
    }

    public void calculateIterations(Function function, double left, double right, int iterations) {
        String str = "\n\nTEST   " + function.getClass().getSimpleName() + " <" + left + ", " + right + ">, N = " + iterations + "\n|";
        System.out.println(str);

        function.showGraph();

        Controller.setFunction(function);

        Controller.setRange(left, right);
        Controller.setIterations(iterations);
        Controller.calculateSolutions();
    }

    @Test
    public void testFormulas() {
        Function polynomial = new FunctionPolynomial();
        polynomial.showGraph(); // window blinks briefly,

        calculateEpsilon(polynomial, 0, 1, 0.001);
        calculateIterations(polynomial, 0, 1, 5);

    }
}