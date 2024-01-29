import Utils.Constants.RobotGIFs.Gifs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.BorderLayout.CENTER;
import static java.awt.Color.WHITE;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PiTV extends JFrame implements KeyListener {

    private final JLabel gifLabel;
    private ImageIcon currentIcon = Gifs.ROBOT_GIF.getCurrentIcon();

    public PiTV() {
        // Set up the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);  // Remove window decorations
        this.setExtendedState(MAXIMIZED_BOTH);  // Set to full-screen
        this.setBackground(WHITE);
        this.setLayout(new BorderLayout());

        // Create and add the JLabel
        this.gifLabel = new JLabel(this.currentIcon);
        this.gifLabel.setSize(new Dimension(this.currentIcon.getIconWidth(), this.currentIcon.getIconHeight())); // Set the size of the JLabel to the size of the GIF
        this.gifLabel.setOpaque(true);
        this.setForeground(WHITE);
        this.add(this.gifLabel, CENTER);

        // Add KeyListener to the JFrame
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        // Show the JFrame
        this.setVisible(true);
    }

    private void changeToFirstGif() {
        // Change to the robot GIF when the 'I' key is pressed
        this.currentIcon = Gifs.ROBOT_GIF.getCurrentIcon();
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToSecondGif() {
        // Change to the second GIF when the 'U' key is pressed
        this.currentIcon = Gifs.SWERVE_GIF.getCurrentIcon();
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToThirdGif() {
        // Change to the third GIF when the 'Y' key is pressed
        this.currentIcon = Gifs.SHOT_GIF.getCurrentIcon();
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToForthGif() {
        // Change to the third GIF when the 'T' key is pressed
        this.currentIcon = Gifs.ARM_GIF.getCurrentIcon();
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToFifthGif() {
        // Change to the third GIF when the 'R' key is pressed
        this.currentIcon = Gifs.SENSORS_GIF.getCurrentIcon();
        this.gifLabel.setIcon(currentIcon);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Call the corresponding method based on the pressed key
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I -> this.changeToFirstGif();
            case KeyEvent.VK_U -> this.changeToSecondGif();
            case KeyEvent.VK_Y -> this.changeToThirdGif();
            case KeyEvent.VK_T -> this.changeToFifthGif();
            case KeyEvent.VK_R -> this.changeToForthGif();
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
