import javax.swing.*;
/**
 * press U to change gif
 * press Y to change gif
 * press I to change gif
 * press T to change gif
 * PRESS S TO BE ON THE TIME PASSED MODE
 * press R to change gif
 * PRESS D TO BE ON THE DEV MODE
 * PRESS A TO BE ON THE AUTO SWITCH MODE
 * PRESS F4 TO STOP THE PROGRAM
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("The code has been started!");
        System.out.println("Made by Noam, Ori, and Itay from Excalibur #6738.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The code has been stopped.");
            System.out.println("Made by Noam, Ori, and Itay from Excalibur #6738.");
        }));
        SwingUtilities.invokeLater(PiTV::new);
    }
}
