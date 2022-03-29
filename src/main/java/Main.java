import application.ControllerZad1;
import application.ControllerZad2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
//         while (true) {
//            try
//            {
//                ControllerZad1.startApp();
//            }
//            catch (RuntimeException e)
//            {
//                System.out.println("Program ended by user");
//                return;
//            }
//        }
        System.out.println("Type 'q' to exit \n");
        while (true) {
            try {
                ControllerZad2.startApp();
            } catch (RuntimeException | IOException e) {
                return;
            }
        }

    }


}
