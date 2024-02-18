import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(int width, int height, int x, int y, MyButton... buttons) {
        this.setLayout(new FlowLayout(CENTER, 3, 3));

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            this.add(button);
        }

        this.setBounds(x, y, width, height);
    }
}
