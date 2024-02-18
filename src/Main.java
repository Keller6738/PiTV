import javax.swing.*;
/**
 * press 1 to change gif
 * press 2 to change gif
 * press 3 to change gif
 * press 4 to change gif
 * press 5 to change gif
 * PRESS S TO TURN ON THE TIMING MODE
 * PRESS D TO TURN ON THE DEV MODE
 * PRESS A TO TURN ON THE AUTO SWITCH MODE
 * PRESS F4 TO STOP THE PROGRAM
 */
public class Main {
    public static void main(String[] args) {
        /*System.out.println("The code has been started!");
        System.out.println("Made by Noam, Ori, and Itay from Excalibur #6738.");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The code has been stopped.");
            System.out.println("Made by Noam, Ori, and Itay from Excalibur #6738.");
        }));
        SwingUtilities.invokeLater(mainWindow::new);*/
        mainWindow mainWindow = new mainWindow();
        mainWindow.setVisible(true);
    }
}
