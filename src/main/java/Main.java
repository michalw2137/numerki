import application.ControllerZad1;

public class Main {

    public static void main(String[] args) {    // działa jeden na raz, odkomentowuj pojedynczo
         while (true) {
            try
            {
                ControllerZad1.startApp();
            }
            catch (RuntimeException e)
            {
                System.out.println("Program ended by user");
                return;
            }
        }
    }


}
