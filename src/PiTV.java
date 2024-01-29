import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class PiTV extends JFrame implements KeyListener {
    private final JLabel gifLabel;
    private ImageIcon currentIcon;

    public PiTV() {
        // Set up the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);  // Remove window decorations
        this.setExtendedState(MAXIMIZED_BOTH);  // Set to full-screen
        this.getContentPane().setBackground(Color.WHITE); // Set background color of the JFrame
        this.setLayout(new BorderLayout());

        // Create a JPanel with FlowLayout to center the JLabel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false); // Make the JPanel transparent
        this.add(panel, BorderLayout.CENTER);

        // Create and add the JLabel
        this.gifLabel = new JLabel();
        panel.add(gifLabel);

        // Load the initial GIF
        this.changeToFirstGif();

        // Add KeyListener to the JFrame
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        // Show the JFrame
        this.setVisible(true);
    }

    private void changeToFirstGif() {
        // Change to the robot GIF when the 'I' key is pressed
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/robot.gif")));
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToSecondGif() {
        // Change to the second GIF when the 'U' key is pressed
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/swerve.gif")));
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToThirdGif() {
        // Change to the third GIF when the 'Y' key is pressed
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/shot.gif")));
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToForthGif() {
        // Change to the third GIF when the 'T' key is pressed
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/arm.gif")));
        this.gifLabel.setIcon(currentIcon);
    }

    private void changeToFifthGif() {
        // Change to the third GIF when the 'R' key is pressed
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/sensors.gif")));
        this.gifLabel.setIcon(currentIcon);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Call the corresponding method based on the pressed key
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I:
                this.changeToFirstGif();
                break;
            case KeyEvent.VK_U:
                this.changeToSecondGif();
                break;
            case KeyEvent.VK_Y:
                this.changeToThirdGif();
                break;
            case KeyEvent.VK_T:
                this.changeToFifthGif();
                break;
            case KeyEvent.VK_R:
                this.changeToForthGif();
                break;
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PiTV::new);
    }
}
