import functions.*;
import view.XYSeriesDemo;

public class Main {
    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
//        showGraph(new FunctionPolynomial());
//        showGraph(new FunctionExponential());
//        showGraph(new FunctionSine());
//        showGraph(new FunctionCosine());
//        showGraph(new FunctionTangent());
    }

    private static void showGraph(Function function) {
        var arguments = function.calculateArgumentsIntoList(-10, 10);
        var values = function.calculateValuesIntoList(-10, 10);

        XYSeriesDemo view = new XYSeriesDemo(function.getFormula(), arguments, values, 0); // TODO: ogarnac jak to dziala, zrobic wlasne customowe
        view.pack();
        view.setVisible(true);
    }
}
