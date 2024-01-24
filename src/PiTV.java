import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PiTV extends JFrame implements KeyListener {

    private JLabel gifLabel;
    private ImageIcon[] gifs;
    private int currentGifIndex = 0;

    public PiTV() {
        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);  // Remove window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Set to full-screen
        setLayout(new BorderLayout());

        // Load GIFs using file paths
        gifs = new ImageIcon[5];
        gifs[0] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\robot.gif");
        gifs[1] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\swerve.gif");
        gifs[2] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\shot.gif");
        gifs[3] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\arm.gif");
        gifs[4] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\sensors.gif");


        // Create and add the JLabel
        gifLabel = new JLabel(gifs[currentGifIndex]);
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
        // Change to the first GIF when the 'I' key is pressed
        currentGifIndex = 0;
        gifLabel.setIcon(gifs[currentGifIndex]);
    }

    private void changeToSecondGif() {
        // Change to the second GIF when the 'U' key is pressed
        currentGifIndex = 1;
        gifLabel.setIcon(gifs[currentGifIndex]);
    }

    private void changeToThirdGif() {
        // Change to the third GIF when the 'Y' key is pressed
        currentGifIndex = 2;
        gifLabel.setIcon(gifs[currentGifIndex]);
    }
    private void changeToForthGif() {
        // Change to the third GIF when the 'Y' key is pressed
        currentGifIndex = 3;
        gifLabel.setIcon(gifs[currentGifIndex]);
    }
    private void changeToFifthGif() {
        // Change to the third GIF when the 'Y' key is pressed
        currentGifIndex = 4;
        gifLabel.setIcon(gifs[currentGifIndex]);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PiTV());
    }
}
