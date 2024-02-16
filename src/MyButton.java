import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.PLAIN;

public class MyButton extends JPanel implements MouseListener {
    private final JLabel textLabel;
    private final Runnable run;
    private final String text;

    public MyButton(Runnable run, String text, Dimension size) {
        this.textLabel = new JLabel();

        this.run = run;
        this.text = text;
        this.setSize(size);
        this.textLabel.setText(text);
        this.textLabel.setForeground(Colors.BLUE.color);
        this.setFont(new Font("aa", PLAIN, 25));
        this.setBackground(Colors.YELLOW.color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        run.run();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
