import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PiTV extends JFrame implements KeyListener {

    private JLabel gifLabel;
    private ImageIcon[] gifs;

    public PiTV() {
        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);  // Remove window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Set to full-screen
        setLayout(new BorderLayout());

        gifs = new ImageIcon[5];
        gifs[0] = new ImageIcon(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));
        gifs[1] = new ImageIcon(String.valueOf(Constants.RobotGIFs.GifsConstants.SWERVE_GIF));
        gifs[2] = new ImageIcon(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));
        gifs[3] = new ImageIcon(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));
        gifs[4] = new ImageIcon(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));

        // Create and add the JLabel
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));
        gifLabel.setSize(getSize()); // Set the size of the JLabel to the size of the screen
        add(gifLabel, BorderLayout.CENTER);

        // Add KeyListener to the JFrame
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Show the JFrame
        setVisible(true);
    }

    private void changeToFirstGif() {
        // Change to the robot GIF when the 'I' key is pressed
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.ROBOT_GIF));
    }

    private void changeToSecondGif() {
        // Change to the second GIF when the 'U' key is pressed
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.SWERVE_GIF));
    }

    private void changeToThirdGif() {
        // Change to the third GIF when the 'Y' key is pressed
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.SHOT_GIF));
    }

    private void changeToForthGif() {
        // Change to the third GIF when the 'T' key is pressed
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.ARM_GIF));
    }

    private void changeToFifthGif() {
        // Change to the third GIF when the 'R' key is pressed
        gifLabel = new JLabel(String.valueOf(Constants.RobotGIFs.GifsConstants.SENSORS_GIF));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Call the corresponding method based on the pressed key
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I:
                changeToFirstGif();
                break;
            case KeyEvent.VK_U:
                changeToSecondGif();
                break;
            case KeyEvent.VK_Y:
                changeToThirdGif();
                break;
            case KeyEvent.VK_T:
                changeToFifthGif();
                break;
            case KeyEvent.VK_R:
                changeToForthGif();
                break;
        }
    }

    // Unused KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
