import javax.swing.*;
import java.awt.*;

import static java.awt.Image.SCALE_SMOOTH;

public class Window extends JPanel {

    private final JLabel imageLabel;
    private final ImageIcon imageIcon;

    public Window(String fileName, int width, int height, int x, int y) {

        this.imageLabel = new JLabel();
        this.imageIcon = new ImageIcon(fileName);
        this.imageLabel.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(imageLabel);
    }

    public Window(String fileName, int width, int height, int x, int y, double scaleFactor) {

        this.imageLabel = new JLabel();
        this.imageIcon = new ImageIcon(fileName);
        this.imageLabel.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(imageLabel);

        Image originalImage = this.imageIcon.getImage();

        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        this.imageIcon.setImage(originalImage.getScaledInstance(newWidth, newHeight, SCALE_SMOOTH));
    }

    public Window(String fileName, int width, int height, int x, int y, int size, String... texts) {
        this.imageLabel = new JLabel();
        this.imageIcon = new ImageIcon(fileName);
        this.imageLabel.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(imageLabel);
    }
}
