import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Code has been started!");
        SwingUtilities.invokeLater(() -> {
            PiTV piTV = new PiTV();
        });
        System.out.println("Made by Noam,Ori and Itay from Excaliber #6738");
    }
}
