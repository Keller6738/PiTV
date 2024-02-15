import javax.swing.*;
import java.awt.*;


public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(Dimension size, MyButton... buttons) {
        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            this.add(button);
        }
        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setSize(size);
    }

    public Menu() {
        for (MyButton button : this.buttons) {
            this.add(button);
        }
        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
    }
}