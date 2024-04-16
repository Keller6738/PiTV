import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class MainMenu extends JPanel {
//    private final Menu[] menus;
    private final MyButton[] buttons;

    public MainMenu(int width, int height, int x, int y, int hGap, int vGap, MyButton... buttons) {
        this.setLayout(new FlowLayout(CENTER, hGap, vGap));

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.buttons = new MyButton[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            this.buttons[i] = buttons[i];
            this.buttons[i].setPreferredSize(new Dimension(this.buttons[i].getWidth(), this.buttons[i].getHeight()));
            this.add(this.buttons[i]);
        }

        this.setBounds(x, y, width, height);
    }

    public int getNumButtons() {
        return this.buttons.length;
    }

    public MyButton getButton(int place) {
        return this.buttons[place];
    }

    public void runButton(int place) {
        this.buttons[place].toRun();
    }
}

