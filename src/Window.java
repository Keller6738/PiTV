import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;

public class Window extends JPanel {
    private final JLabel[] labels;
    private ImageIcon imageIcon;

    public Window(String text, String fileName, int width, int height, int x, int y) {
        this.labels = new JLabel[1];
        this.labels[0] = new JLabel(text);
        this.imageIcon = new ImageIcon(fileName);

        this.labels[0].setIcon(imageIcon);

        this.labels[0].setForeground(Colors.YELLOW.color);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(labels[0]);
    }

    public Window(String text, String fileName, int width, int height, int x, int y, int size) {
        this.labels = new JLabel[1];
        this.labels[0] = new JLabel(text);
        this.imageIcon = new ImageIcon(fileName);

        this.labels[0].setIcon(imageIcon);

        this.labels[0].setForeground(Colors.YELLOW.color);
        this.setFont(new Font("", BOLD, size));

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(labels[0]);
    }
}
