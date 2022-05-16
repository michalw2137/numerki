package application;

import aproximation.Hermite;
import functions.Function;
import functions.FunctionModulo;
import functions.FunctionPolynomial;
import functions.FunctionQuadratic;
import functions.FxF;
import integration.Simpson;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import java.util.Arrays;

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
        a = -2;
        b = 2;
        //n = 2;
        epsilon = 0.01;
        //function.showGraph(function.getFormula(), a, b, 0);
        Hermite.generateNPolynomials(n);
        double[] c = new double[n+1];

        for(int i = 0; i <= n; i++) {
            int[] factors = Hermite.getNthPolynomial(i);
            System.out.println(Arrays.toString(factors));
            Function Hn = new FunctionPolynomial(factors.length, factors, Controller.makeFormula(factors, i));
            //System.out.println("H" + i + " = " + Controller.makeFormula(factors, i));

            double fI = Simpson.integral(new FxF(function, Hn), a, b, epsilon);
            //System.out.println("integral f*g= " + fI);

            double HnI = Simpson.integral(new FxF(Hn, Hn), a, b, epsilon);
            //System.out.println("integral g*g= " + HnI);

            c[n-i] = fI / HnI;
            //System.out.println("c" + (n-i) + " = " + c[n-i]);
            //System.out.println();
        }

        for(int i = 0; i <= n; i++) {
            System.out.println(c[i] +"\t"+ Arrays.toString(Hermite.getNthPolynomial(i)));
        }
        System.out.println();
        System.out.println();




        double[] solution = new double[n+1];
        for (int i=0; i<=n; i++) {
            for (int ii=0; ii<=n; ii++) {
                try {
                    double p = Hermite.getNthPolynomial(ii)[ii-i];
                    double ci = c[i];
                    solution[i] += p * ci;
                    //System.out.print(ii+","+(ii-i)+"\t");
                } catch (ArrayIndexOutOfBoundsException ignored){}

            }
            //System.out.println();
        }

        for (double s: solution) {
            System.out.println(s);
        }

        //F.showGraph(F.getFormula(), a, b, 0);

        //Controller.graph2Functions(function, F, a, b);

    }
}
