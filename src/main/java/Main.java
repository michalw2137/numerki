import application.Controller;
import application.ControllerZad3;
import application.ControllerZad5;
import functions.*;

import java.security.cert.CertificateParsingException;

public class Main {

    private static void test(Function function, double a, double b, int n) {
        ControllerZad3.setFunction(function);
        ControllerZad3.setRange(a, b);
        ControllerZad3.setNodesNumber(n);
        ControllerZad3.doCalculations();
        ControllerZad3.showResults();
    }

    public static void main(String[] args) {
        while (true) {
            int choice = Controller.readInt("Select mode: \n -normal (1)\n -find polynomial (2): \n");
            if (choice == 1) {
                ControllerZad5.setVariables();
                ControllerZad5.doCalculations();
                ControllerZad5.showResults();
            } else if (choice == 2) {
                ControllerZad5.findPolynomial();
            } else {
                System.out.println("\nincorrect choice!\n");
            }

        }


//        ControllerZad5.setFunction(new FunctionLinear());
//        ControllerZad5.setA(-5);
//        ControllerZad5.setB(5);
//
//        ControllerZad5.setN(0);
//        ControllerZad5.setNodes(5);
//        ControllerZad5.doCalculations();
//
//        ControllerZad5.setN(1);
//        ControllerZad5.setNodes(5);
//        ControllerZad5.doCalculations();
//
//        ControllerZad5.setN(2);
//        ControllerZad5.setNodes(2);
//        ControllerZad5.doCalculations();
//
//        ControllerZad5.setN(2);
//        ControllerZad5.setNodes(3);
//        ControllerZad5.doCalculations();

    }


}
