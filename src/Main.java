import javax.swing.*;
/**
 * press I to change gif
 * press U to change gif
 * press Y to change gif
 * press T to change gif
 * press R to change gif
 * PRESS D TO BE ON THE DEV MODE
 * PRESS A TO BE ON THE AUTO SWITCH MODE
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("The code has been started!");
        System.out.println("Made by Noam, Ori, and Itay from Excaliber #6738.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The code has been stopped.");
            System.out.println("Made by Noam, Ori, and Itay from Excaliber #6738.");
        }));
        SwingUtilities.invokeLater(PiTV::new);
    }
}
