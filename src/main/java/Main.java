import application.Controller;
import functions.*;
import view.XYSeriesDemo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
//        showGraph(new FunctionPolynomial());
//        showGraph(new FunctionExponential());
//        showGraph(new FunctionSine());
//        showGraph(new FunctionCosine());    // TODO: cosine is supposed to do dumb things
//        showGraph(new FunctionTangent());
//
        try {
            Controller.startApp();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void showGraph(Function function) {
        var arguments = function.calculateArgumentsIntoList(function.getGraphLeft(), function.getGraphRight());
        var values = function.calculateValuesIntoList(function.getGraphLeft(), function.getGraphRight());

        XYSeriesDemo view = new XYSeriesDemo(function.getFormula(), arguments, values, 0); // TODO: ogarnac jak to dziala, zrobic wlasne customowe
        view.pack();
        view.setVisible(true);
    }
}
