import application.Controller;
import functions.*;
import view.XYSeriesDemo;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
         while (true) {
            try
            {
                Controller.startApp();
            }
            catch (RuntimeException e)
            {
                System.out.println("Program ended by user");
                return;
            }
        }
    }


}
