package application;

import functions.*;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerZad3 {

    private static double left, right;
    private static Function function;
    private static int nodesNumber;

    private static ArrayList<Double> nodesX;
    private static ArrayList<Double> nodesY;

    private static ArrayList<Double> interpolatedX;
    private static ArrayList<Double> interpolatedY;

    private static ArrayList<Double> interpolatingX;
    private static ArrayList<Double> interpolatingY;

    private static final Scanner scanner = new Scanner(System.in);

    public static void startApp() throws RuntimeException{
        function = Controller.chooseFunction();
        function.showGraph();

        double[] edges = Controller.readEdges();
        left = edges[0];
        right = edges[1];

        nodesNumber = Controller.readInt("Enter nodes number: ");

        doCalculations();

        showResults();

        System.out.println("\n======== CALCULATIONS PERFORMED SUCCESFULLY ========\n");
    }

    public static void doCalculations() {
        nodesX = LaGrange.getNChebyshevNodes(nodesNumber, left, right);
        nodesY = LaGrange.calculateValuesInNodes(nodesNumber, left, right, function);
        LaGrange laGrange = new LaGrange(nodesX, nodesY);

        interpolatedX = function.calculateArgumentsIntoList(left, right);
        interpolatedY = function.calculateValuesIntoList(left, right);

        interpolatingX = laGrange.calculateArgumentsIntoList(left, right);
        interpolatingY = laGrange.calculateValuesIntoList(left, right);
    }

    public static void showResults() {
        XYSeriesDemo view = new XYSeriesDemo(interpolatedX, interpolatedY, interpolatingX, interpolatingY, nodesX, nodesY);
        view.pack();
        view.setVisible(true);
    }






        public static void setFunction (Function function) {
        ControllerZad3.function = function;
    }

    public static void setRange(double left, double right) {
        ControllerZad3.left = left;
        ControllerZad3.right = right;
    }

    public static void setNodesNumber(int nodesNumber) {
        ControllerZad3.nodesNumber = nodesNumber;
    }
}
