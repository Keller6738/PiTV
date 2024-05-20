package Screens;

import Utils.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Font.BOLD;
import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;

public class MyButton extends JPanel implements MouseListener {
    private final JLabel[] textLabels;
    private final Runnable run;
    private boolean isRunning;

    public MyButton(Runnable run, int width, int height, int x, int y, boolean mainMenu, String... texts) {
        this.setLayout(new GridBagLayout());

        this.run = run;

        Font font;
        font = mainMenu ? new Font("", BOLD, 20) : new Font("", BOLD, 15);

        this.textLabels = new JLabel[texts.length];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.ipady = 1;
        gbc.anchor = CENTER;

        for (int i = 0; i < texts.length; i++) {
            this.textLabels[i] = new JLabel(texts[i]);

            this.textLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.textLabels[i].setVerticalAlignment(SwingConstants.CENTER);


            this.textLabels[i].setFont(font);
            this.textLabels[i].setForeground(Colors.BLUE.color);

            this.setBackground(Colors.YELLOW.color);

            gbc.gridy = i;
            this.add(textLabels[i], gbc);
        }

        this.setOpaque(true);

        this.setBounds(x, y, width, height);

        this.addMouseListener(this);
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.run.run();
        this.isRunning = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(Colors.BLUE.color);
        for (JLabel label : this.textLabels) {
            label.setForeground(Colors.YELLOW.color);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(Colors.YELLOW.color);
        for (JLabel label : this.textLabels) {
            label.setForeground(Colors.BLUE.color);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
