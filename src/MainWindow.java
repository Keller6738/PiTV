import javax.swing.*;

public class MainWindow extends JPanel {
    private final JLabel label;
    private ImageIcon imageIcon;

    public MainWindow(JLabel label, ImageIcon imageIcon, int width, int height, int x, int y) {
        this.label = label;
        this.imageIcon = imageIcon;

        this.label.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
    }
}
