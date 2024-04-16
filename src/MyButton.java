import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.BOLD;

public class MyButton extends JPanel implements MouseListener {
    private final JLabel[] textLabels;
    private final Runnable run;

    public MyButton(Runnable run, String text, int width, int height, int x, int y, int textX, boolean mainMenu) {
        this.setLayout(null);

        this.textLabels = new JLabel[1];
        this.textLabels[0] = new JLabel(text);

        this.run = run;

        this.textLabels[0].setBackground(Colors.BLUE.color);
        this.textLabels[0].setFont(new Font("", BOLD, 15));
        this.textLabels[0].setForeground(Colors.BLUE.color);

        this.setBackground(Colors.YELLOW.color);


        this.add(textLabels[0]);

        this.setOpaque(true);
        this.setBounds(x, y, width, height);

        this.addMouseListener(this);
    }

    public MyButton(Runnable run, int width, int height, int x, int y, boolean mainMenu, String... texts) {
        this.setLayout(new BorderLayout(0, 0));

        this.run = run;

        Font font;
        font = mainMenu ? new Font("", BOLD, 20) : new Font("", BOLD, 15);

        this.textLabels = new JLabel[texts.length];
        for (int i = 0; i < texts.length; i++) {
            this.textLabels[i] = new JLabel(texts[i]);

            this.textLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.textLabels[i].setVerticalTextPosition(i < this.textLabels.length/2? this.getHeight()/2 - this.textLabels[i].getHeight()*(this.textLabels.length/2 - i) : this.getHeight()/2 + this.textLabels[i].getHeight()*(i - this.textLabels.length/2));

            this.textLabels[i].setBackground(Colors.BLUE.color);
            this.textLabels[i].setFont(font);
            this.textLabels[i].setForeground(Colors.BLUE.color);

            this.setBackground(Colors.YELLOW.color);


            this.add(textLabels[i], BorderLayout.CENTER);
        }

        this.setOpaque(true);

        this.setBounds(x, y, width, height);

        this.addMouseListener(this);
    }

    public Runnable getRun() {
        return run;
    }

    public void toRun() {
        this.run.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.run.run();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(Colors.BLUE.color);
//        this.textLabels.setForeground(Colors.YELLOW.color);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(Colors.YELLOW.color);
//        this.textLabels.setForeground(Colors.BLUE.color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
