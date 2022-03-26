import application.ControllerZad1;
import functions.*;
import org.junit.Test;

public class efficiencyTest {

    public void calculateEpsilon(Function function, double left, double right, double epsilon) {
        String str = "\n\nTEST   " + function.getClass().getSimpleName() + " <" + left + ", " + right + ">, ε = " + epsilon + "\n|";
        System.out.println(str);

        function.showGraph();

        ControllerZad1.setFunction(function);

        ControllerZad1.setRange(left, right);
        ControllerZad1.setEpsilon(epsilon);
        ControllerZad1.calculateSolutions();
    }

    public void calculateIterations(Function function, double left, double right, int iterations) {
        String str = "\n\nTEST   " + function.getClass().getSimpleName() + " <" + left + ", " + right + ">, N = " + iterations + "\n|";
        System.out.println(str);

        function.showGraph();

        ControllerZad1.setFunction(function);

        ControllerZad1.setRange(left, right);
        ControllerZad1.setIterations(iterations);
        ControllerZad1.calculateSolutions();
    }

    @Test
    public void testFormulas() {
        Function polynomial = new FunctionPolynomial();
        polynomial.showGraph(); // window blinks briefly,

        calculateEpsilon(polynomial, 0, 1, 0.001);
        calculateIterations(polynomial, 0, 1, 5);

    }
}