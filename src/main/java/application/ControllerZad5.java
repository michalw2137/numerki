package application;

import aproximation.HermitePolynomials;
import functions.Function;
import functions.FunctionPolynomial;
import functions.FunctionQuadratic;
import functions.differenceSquared;
import integration.Hermite;
import integration.Simpson;

import java.util.ArrayList;
import java.util.Arrays;

import static application.Controller.factorial;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ControllerZad5 {
    private static Function function;
    private static double a, b;
    private static int n; // degree of polynomial
    private static int nodes;

    public static void setVariables() {
        function = Controller.chooseFunction();
        function.showGraph();

        double[] edges = Controller.readEdges();
        a = edges[0];
        b = edges[1];

        n = Controller.readInt("Enter degree of polynomial: ");

        nodes = Controller.readInt("Enter nodes number (2-5):");
    }

    public static void doCalculations () {

        HermitePolynomials.generateNPolynomials(n);

        double[] c = new double[n+1];

        Hermite.setNodesNumber(nodes);
        for(int k = 0; k <= n; k++) {
            var factors = HermitePolynomials.getNthPolynomial(k);
            Function Hk = new FunctionPolynomial(k, factors, "test");
            double ak = Hermite.ak(function, k);
            c[k] = ak;
        }

        for(int i = 0; i <= n; i++) {
            System.out.println(c[i] +"\t"+ Arrays.toString(HermitePolynomials.getNthPolynomial(i)));
        }
        System.out.println();
        System.out.println();


// ==================================================================================================================================
        double[] solution = new double[n+1];
        for (int i=0; i<=n; i++) {
            for (int ii=0; ii<=n; ii++) {
                try {
                    double p = HermitePolynomials.getNthPolynomial(ii)[ii-i];
                    double ci = c[ii];
                    solution[n-i] += p * ci;
                    System.out.print("H"+ii+" ["+(ii-i)+"] = "+p+"\t\t");
                    System.out.print("ci = " + ci+"\t\t");
                    System.out.print("H*ci = " + p * ci);
                    System.out.println();
                } catch (ArrayIndexOutOfBoundsException ignored){}

            }
            System.out.println("c["+i+"] = "+solution[n-i]);
            System.out.println();
        }

        for (int i=0; i<=n; i++) {
            System.out.println("c["+(n-i)+"] = " + solution[i]);
        }

        Function approximation = new FunctionPolynomial(n, solution, Controller.makeFormula(n, solution));

        Controller.graph2Functions(function, approximation, a, b);

        double error = Simpson.integral(new differenceSquared(function, approximation), a, b, 0.001);
        System.out.println("\nerror = " + error + "\n");

    }

    public static void setFunction(Function f) {
        function = f;
    }

    public static void setA(double left) {
        a = left;
    }

    public static void setB(double right) {
        b = right;
    }

    public static void setN(int degree) {
        n = degree;
    }

    public static void setNodes(int n) {
        nodes = n;
    }
}
