import javax.swing.*;

public class Menu extends JPanel {
    private MyButton[] buttons;

    public Menu(MyButton... buttons) {
        this.buttons = buttons;
        for (MyButton button : this.buttons) {
            this.add(button);
        }
        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
    }
}
