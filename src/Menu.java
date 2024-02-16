import javax.swing.*;
import java.awt.*;


public class Menu extends JPanel implements Runnable {
    private MyButton[] buttons;

    public Menu(Dimension size, MyButton... buttons) {
        this.buttons = buttons;
        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        for (MyButton button : this.buttons) {
            this.add(button);
        }

        this.setSize(size);
    }

    @Override
    public void run() {
        this.setVisible(true);
    }
}
