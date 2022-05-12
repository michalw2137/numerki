import application.ControllerZad1;
import application.ControllerZad2;
import application.ControllerZad3;
import application.ControllerZad4;
import functions.*;
import interpolation.LaGrange;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static void test(Function function, double a, double b, int n) {
        ControllerZad3.setFunction(function);
        ControllerZad3.setRange(a, b);
        ControllerZad3.setNodesNumber(n);
        ControllerZad3.doCalculations();
        ControllerZad3.showResults();
    }

    public static void main(String[] args) {

//        for (int i = 2; i <= 5; i+=2) {
//            test(new FunctionCosine(), -10, 10, i);
//        }
//        test(new FunctionCosine(), -10, 10, 100);

        while (true) {
            try {
                ControllerZad1.startApp();
            }
            catch (RuntimeException e) {
                System.out.println("Program ended by user");

                System.out.println(e.getMessage());
                System.out.println(e);
                System.out.println(Arrays.toString(e.getStackTrace()));
                return;
            }
        }

//        while (true) {
//            try {
//                ControllerZad3.startApp();
//            }
//        catch (RuntimeException e) {
//                System.out.println("Program ended by user");
//                return;
//            }
//        }

//        while (true) {
//            try {
//                ControllerZad1.startApp();
//            }
//            catch (RuntimeException e) {
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
