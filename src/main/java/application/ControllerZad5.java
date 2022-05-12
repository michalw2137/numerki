package application;

import functions.Function;

public class ControllerZad5 {
    private static Function function;
    private static double a, b;
    private static int n; // degree of polynomial
    private static double epsilon;

    public static void startApp() {
        function = Controller.chooseFunction();

        double[] edges = Controller.readEdges();
        a = edges[0];
        b = edges[1];

        n = Controller.readInt("Enter degree of polynomial: ");
        epsilon = Controller.readDouble("Enter integration precision: ");


    }
}
