import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(int width, int height, int x, int y, MyButton... buttons) {
        /*this.setLayout(null);

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            this.add(button);
            System.out.println(button.getText());
        }

        this.setBounds(x, y, width, height);*/

        // Set layout manager to null for manual positioning
        this.setLayout(null);

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = buttons;

        for (MyButton button : this.buttons) {
            // Make sure buttons have a valid size and position
            button.setBounds(button.getX(), button.getY(), button.getWidth(), button.getHeight());
            this.add(button);
            System.out.println(button.getText());
        }

        // Set the bounds of the Menu itself
        this.setBounds(x, y, width, height);
    }
}
