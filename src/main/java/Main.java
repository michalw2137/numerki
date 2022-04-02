import application.ControllerZad1;
import application.ControllerZad2;
import application.ControllerZad3;
import functions.Function;
import functions.FunctionSine;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
        int n = 6;
        int a = -5;
        int b = 5;
        Function sin = new FunctionSine();

        var nodesX = LaGrange.getNChebyshevNodes(n, a, b);
        var nodesY = LaGrange.calculateValuesInNodes(n, a, b, sin);

        LaGrange laGrange = new LaGrange(nodesX, nodesY);

//        lg.showGraph();


        XYSeriesDemo view = new XYSeriesDemo(sin.calculateArgumentsIntoList(a, b), sin.calculateValuesIntoList(a, b),
                                            laGrange.calculateArgumentsIntoList(a, b), laGrange.calculateValuesIntoList(a, b),
                                            nodesX, nodesY);
        view.pack();
        view.setVisible(true);
//         while (true) {
//            try
//            {
//                ControllerZad3.startApp();
//            }
//            catch (RuntimeException e)
//            {
//                System.out.println("Program ended by user");
//                return;
//            }
//        }
//        System.out.println("Type 'q' to exit \n");
//        while (true) {
//            try {
//                ControllerZad2.startApp();
//            } catch (RuntimeException | IOException e) {
//                System.out.println(e.getMessage());
////                e.printStackTrace();
//                System.out.println();
//            } catch (IllegalAccessException e) {
//                System.out.println(e.getMessage());
//                return;
//            }
//        }

    }


}
