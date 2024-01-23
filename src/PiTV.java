import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PiTV extends JFrame implements ActionListener, KeyListener {

    private JLabel gifLabel;
    private ImageIcon[] gifs;
    private int currentGifIndex = 0;

    public PiTV() {
        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        gifs = new ImageIcon[2];
        gifs[0] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\robot.gif");
        gifs[1] = new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\swerve.gif");

        // Create and add the JLabel
        gifLabel = new JLabel(gifs[currentGifIndex]);
        gifLabel.setSize(getSize());
        add(gifLabel, BorderLayout.CENTER);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Change the GIF when the spacebar is pressed
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            currentGifIndex = (currentGifIndex + 1) % gifs.length;
            gifLabel.setIcon(gifs[currentGifIndex]);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
