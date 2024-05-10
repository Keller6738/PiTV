import Screens.Screen;

public class Main {
    //TODO: Finish the GUI
    public static void main(String[] args) {
        System.out.println("The code has been started!");
        System.out.println("Made by Itay and Noam from Excalibur #6738.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The code has been stopped.");
            System.out.println("Made by Itay Keller and Noam Novoselskey from Excalibur #6738.");
        }));
        new Screen();
    }
}
