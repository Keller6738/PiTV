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
    private boolean timingMode = false;
    private long lastSwitchTime = 0;
    private static final int AUTO_SWITCH_INTERVAL = 10000; // 10 seconds in milliseconds

    // Array to store GIF file names
    private static final String[] GIF_FILE_NAMES = {
            "robot.gif",
            "swerve.gif",
            "shot.gif",
            "arm.gif",
            "sensors.gif"
    };

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

        this.changeToGif(0); // Initially, set to the first GIF

        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);

        // Start auto-switching mode
        startAutoSwitchTimer();
    }

    private void changeToGif(int index) {
        long currentTime = System.currentTimeMillis();
        if (timingMode && lastSwitchTime != 0) {
            System.out.println("Time between last switch: " + (currentTime - lastSwitchTime) + " milliseconds");
        }
        lastSwitchTime = currentTime;

        this.currentIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("GIFs/" + GIF_FILE_NAMES[index])));
        this.gifLabel.setIcon(currentIcon);
        logGifChange();
    }

    private void logGifChange() {
        if (devMode) {
            String filename = GIF_FILE_NAMES[getCurrentIndex()];
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

    private void toggleTimingMode() {
        timingMode = !timingMode;
        if (timingMode) {
            System.out.println("Timing mode is ON.");
        } else {
            System.out.println("Timing mode is OFF.");
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
    }

    private void switchRandomGif() {
        Random random = new Random();
        int randomIndex = random.nextInt(GIF_FILE_NAMES.length);
        changeToGif(randomIndex);
    }

    private int getCurrentIndex() {
        for (int i = 0; i < GIF_FILE_NAMES.length; i++) {
            if (currentIcon.getDescription().endsWith(GIF_FILE_NAMES[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I:
                this.changeToGif(0);
                break;
            case KeyEvent.VK_U:
                this.changeToGif(1);
                break;
            case KeyEvent.VK_Y:
                this.changeToGif(2);
                break;
            case KeyEvent.VK_T:
                this.changeToGif(3);
                break;
            case KeyEvent.VK_R:
                this.changeToGif(4);
                break;
            case KeyEvent.VK_D:
                toggleDevMode();
                break;
            case KeyEvent.VK_A:
                toggleAutoSwitch();
                break;
            case KeyEvent.VK_S:
                toggleTimingMode();
                break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    }

