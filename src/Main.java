import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Code has been started!");
        // Creating an instance without assigning to a variable
        SwingUtilities.invokeLater(PiTV::new);
        System.out.println("Made by Noam,Ori and Itay from Excaliber #6738");
    }
}
