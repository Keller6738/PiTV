import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PiTV extends JFrame implements KeyListener {
    private final JLabel gifLabel;
    private ImageIcon currentIcon;
    private boolean devMode = false;
    private boolean autoSwitchEnabled = false;
    private static final int AUTO_SWITCH_INTERVAL = 10000; // 10 seconds in milliseconds

    public PiTV() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);
        this.add(panel, BorderLayout.CENTER);

        this.gifLabel = new JLabel();
        panel.add(gifLabel);

        this.changeToFirstGif();

        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);
    }

    private void changeToFirstGif() {
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/robot.gif")));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void changeToSecondGif() {
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/swerve.gif")));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void changeToThirdGif() {
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/shot.gif")));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void changeToForthGif() {
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/arm.gif")));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void changeToFifthGif() {
        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/sensors.gif")));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void logGifChange() {
        if (devMode) {
            String filename = currentIcon.getDescription();
            filename = filename.substring(filename.lastIndexOf('/') + 1); // Extract filename from URL
            System.out.println("GIF changed: " + filename);
        }
    }

    private void toggleDevMode() {
        devMode = !devMode;
        if (devMode) {
            System.out.println("Developer mode is ON.");
        } else {
            System.out.println("Developer mode is OFF.");
        }
    }

    private void toggleAutoSwitch() {
        autoSwitchEnabled = !autoSwitchEnabled;
        if (autoSwitchEnabled) {
            startAutoSwitchTimer();
            System.out.println("Auto-switching mode is ON.");
        } else {
            stopAutoSwitchTimer();
            System.out.println("Auto-switching mode is OFF.");
        }
    }

    private void startAutoSwitchTimer() {
        Timer autoSwitchTimer = new Timer();
        autoSwitchTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (autoSwitchEnabled) {
                    switchRandomGif();
                }
            }
        }, 0, AUTO_SWITCH_INTERVAL);
    }

    private void stopAutoSwitchTimer() {
        // Implement if needed
    }

    private void switchRandomGif() {
        Random random = new Random();
        int randomIndex = random.nextInt(5); // Generate a random index between 0 and 4
        switch (randomIndex) {
            case 0:
                changeToFirstGif();
                break;
            case 1:
                changeToSecondGif();
                break;
            case 2:
                changeToThirdGif();
                break;
            case 3:
                changeToForthGif();
                break;
            case 4:
                changeToFifthGif();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
            case KeyEvent.VK_D:
                toggleDevMode();
                break;
            case KeyEvent.VK_A:
                toggleAutoSwitch();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}