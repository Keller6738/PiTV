import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.PLAIN;

public class MyButton extends JPanel implements MouseListener {
    private final JLabel textLabel;
    private final Runnable run;
    private final String text;

    public MyButton(Runnable run, String text, int width, int height, int x, int y) {
        this.textLabel = new JLabel(text);

        this.run = run;
        this.text = text;

        this.setBounds(x, y, width, height);

        this.textLabel.setForeground(Colors.BLUE.color);

        this.setFont(new Font("my font", PLAIN, 25));
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
