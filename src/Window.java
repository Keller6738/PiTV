import javax.swing.*;

public class Window extends JPanel {
    private final JLabel label;
    private ImageIcon imageIcon;

    public Window(String text, String fileName, int width, int height, int x, int y) {
        this.label = new JLabel(text);
        this.imageIcon = new ImageIcon(fileName);

        this.label.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(label);
    }

    public void hideOtherWindows(Window... windows) {
        for (Window window : windows)  window.setVisible(false);
    }
}
