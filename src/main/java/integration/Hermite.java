package integration;

import application.Controller;
import aproximation.HermitePolynomials;
import functions.Function;
import functions.FunctionPolynomial;

import static java.lang.Math.E;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Hermite {

    private static int nodes;

    private static double[][] A = {
            {
                    0.886227,
                    0.886227
            },
            {
                    0.295409,
                    1.181636,
                    0.295409
            },
            {
                    0.081313,
                    0.804914,
                    0.804914,
                    0.081313
            },
            {
                    0.019953,
                    0.393619,
                    0.945309,
                    0.393619,
                    0.019953
            }
    };

    private static double[][] x = {
            {
                    -0.707107,
                    0.707107,
            },
            {
                    -1.224745,
                    0.000000,
                    1.224745,
            },
            {
                    -1.650680,
                    -0.534648,
                    0.534648,
                    1.650680,
            },
            {
                    -2.020183,
                    -0.958572,
                    0.000000,
                    0.958572,
                    2.020183,
            }
    };

    public static double integral (Function function, int k)
    {
        double sum = 0;
        for (int i = 0; i < nodes; i ++)
        {
            var factors = HermitePolynomials.getNthPolynomial(k);
            Function Hn = new FunctionPolynomial(k, factors, "test");
            sum += getA(i) * function.fun(getX(i)) * Hn.fun(getX(i));
        }
        return sum;
    }

    public static double coefficient(int k) {
        return  1 / (sqrt(PI) * pow(2,k) * Controller.factorial(k));
    }

    public static double ak(Function function, int k) {
        return coefficient(k) * integral(function, k);
    }

    public static void setNodesNumber(int n) {
        nodes = n;
    }

    public static double getA(int n) {
        return A[nodes-2][n];
    }

    public static double getX(int n) {
        return x[nodes-2][n];
    }
}
