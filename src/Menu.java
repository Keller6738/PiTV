import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(int width, int height, int x, int y,int hGap, int vGap, MyButton... buttons) {
        this.setLayout(new FlowLayout(CENTER, hGap, vGap));

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            button.setPreferredSize(new Dimension(button.getWidth(), button.getHeight()));
            this.add(button);
        }

        this.setBounds(x, y, width, height);
    }

    public Menu(int width, int height, int x, int y,int hGap, int vGap, int rows, int cols, MyButton... buttons) {
        this.setLayout(new GridLayout(rows, cols, hGap, vGap));

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            button.setPreferredSize(new Dimension(button.getWidth(), button.getHeight()));
            this.add(button);
        }

        this.setBounds(x, y, width, height);
    }
}
