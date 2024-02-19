import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(int width, int height, int x, int y, MyButton... buttons) {
        this.setLayout(null);

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;

        this.setBounds(x, y, width, height);
    }

    public MyButton[] getButtons() {
        return buttons;
    }
}
