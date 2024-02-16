import javax.swing.*;
import java.awt.*;

public class MyJButton extends JButton {
    private String text;

    public MyJButton(String text, Dimension size) {
        this.setFocusable(false);
        this.setBackground(Colors.YELLOW.color);
        this.setForeground(Colors.BLUE.color);

        this.setSize(size);
        this.setText(text);
    }
}
