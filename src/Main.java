import Screens.Screen;

public class Main {
    public static void main(String[] args) {
        /*TODO:
        1.Finish the Gui
        2.Fix images(make them again/re-do them again)
        3.Change Images names
        */
        System.out.println("The code has been started!");
        System.out.println("Made by Itay and Noam from Excalibur #6738.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The code has been stopped.");
            System.out.println("Made by Itay Keller and Noam Novoselsky from Excalibur #6738.");
        }));
        new Screen();
    }
}
