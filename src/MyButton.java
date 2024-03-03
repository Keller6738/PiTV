import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.BOLD;

public class MyButton extends JPanel implements MouseListener {
    private final JLabel textLabel;
    private final Runnable run;

    public MyButton(Runnable run, String text, int width, int height, int x, int y, int textX) {
        this.setLayout(null);

        this.textLabel = new JLabel(text);

        this.run = run;

        this.textLabel.setBackground(Colors.BLUE.color);
        this.textLabel.setFont(new Font("", BOLD, 15));
        this.textLabel.setForeground(Colors.BLUE.color);

        this.setBackground(Colors.YELLOW.color);

        this.textLabel.setBounds(textX, 0, width, height);

        this.add(textLabel);

        this.setOpaque(true);
        this.setBounds(x, y, width, height);

        this.addMouseListener(this);
    }

    public MyButton(Runnable run, String text, int width, int height, int x, int y, int textX, int textSize) {
        this.setLayout(null);

        this.textLabel = new JLabel(text);

        this.run = run;

        this.textLabel.setBackground(Colors.BLUE.color);
        this.textLabel.setFont(new Font("", BOLD, textSize));
        this.textLabel.setForeground(Colors.BLUE.color);

        this.setBackground(Colors.YELLOW.color);

        this.textLabel.setBounds(textX, 0, width, height);

        this.add(textLabel);

        this.setOpaque(true);
        this.setBounds(x, y, width, height);

        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        run.run();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(Colors.BLUE.color);
        this.textLabel.setForeground(Colors.YELLOW.color);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(Colors.YELLOW.color);
        this.textLabel.setForeground(Colors.BLUE.color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
