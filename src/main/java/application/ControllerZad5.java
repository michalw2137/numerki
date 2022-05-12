package application;

import aproximation.Hermite;
import functions.Function;
import functions.FunctionModulo;
import functions.FunctionPolynomial;
import functions.FunctionQuadratic;
import functions.FxF;
import integration.Simpson;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public class ControllerZad5 {
    private static Function function;
    private static double a, b;
    private static int n; // degree of polynomial
    private static double epsilon;

    public static void startApp(int n) {
//        function = Controller.chooseFunction();
//        function.showGraph();
//
//        double[] edges = Controller.readEdges();
//        a = edges[0];
//        b = edges[1];
//
//        n = Controller.readInt("Enter degree of polynomial: ");
//        Hermite.generateNPolynomials(n);
//        double[] c = new double[n+1];
//
//        epsilon = Controller.readDouble("Enter integration precision: ");
        function = new FunctionQuadratic();
        a = -4;
        b = 4;
        //n = 2;
        epsilon = 0.1;
        //function.showGraph(function.getFormula(), a, b, 0);
        Hermite.generateNPolynomials(n);
        double[] c = new double[n+1];

        for(int i = 0; i <= n; i++) {
            int[] factors = Hermite.getNthPolynomial(i);
            Function Hn = new FunctionPolynomial(factors.length, factors, "H" + i);
            System.out.println("H" + i + " = " + Controller.makeFormula(factors, i));

            double fI = Simpson.integral(new FxF(function, Hn), a, b, epsilon);
            System.out.println("integral f*g= " + fI);

            double HnI = Simpson.integral(new FxF(Hn, Hn), a, b, epsilon);
            System.out.println("integral g*g= " + HnI);

            c[n-i] = fI / HnI;
            System.out.println("c" + (n-i) + " = " + c[n-i]);
            System.out.println();
        }
        System.out.print("C ====================== ");
        for (double ci : c) {
            System.out.print(ci + "\t");
        }
        System.out.println();
        System.out.println();
        Function F = new FunctionPolynomial(c.length, c, Controller.makeFormula(n, c));
        //F.showGraph(F.getFormula(), a, b, 0);

        //Controller.graph2Functions(function, F, a, b);

    }
}
