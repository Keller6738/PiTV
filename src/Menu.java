import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;

public class Menu extends JPanel {
    private MyButton selfButton;
    private final String selfButtonText;
    private final int selfButtonX;

    private final Window[] windows;
    private Window currentWindow = null;

    private static final int SELF_BUTTON_Y = 20;
    private static final int SELF_BUTTON_WIDTH = 150;
    private static final int SELF_BUTTON_HEIGHT = 80;

    private static final int MENU_WIDTH = 165;
    private static final int MENU_HEIGHT = 522;
    private static final int MENU_X = 1745;
    private static final int MENU_Y = 120;

    private static final int H_GAP = 5;
    private static final int V_GAP = 7;

    private static final int WINDOW_BUTTON_HEIGHT = 80;

    public Menu(String selfButtonText, int selfButtonX, boolean isLonger, WindowContent... windowsContent) {
        this.setLayout(new FlowLayout(CENTER, H_GAP, V_GAP));

        this.setBackground(Colors.BLUE.color);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBounds(MENU_X, MENU_Y, MENU_WIDTH, isLonger ? MENU_HEIGHT + 400 : MENU_HEIGHT);

        this.windows = new Window[windowsContent.length];
        for (int i = 0; i < this.windows.length; i++) {
            this.windows[i] = new Window(this.getY() + WINDOW_BUTTON_HEIGHT * i, windowsContent[i].getFileName(), windowsContent[i].getScaleFactor(), windowsContent[i].getButtonText());

            int finalI = i;
            this.windows[i].setSelfButton(() -> run(finalI));

            this.add(this.windows[i].getSelfButton());
        }

        this.selfButtonText = selfButtonText;
        this.selfButtonX = selfButtonX;
    }

    public Window getCurrentWindow() {
        return currentWindow;
    }

    public MyButton getSelfButton() {
        return selfButton;
    }

    public void setSelfButton(Runnable run) {
        this.selfButton = new MyButton(run, SELF_BUTTON_WIDTH, SELF_BUTTON_HEIGHT, this.selfButtonX, SELF_BUTTON_Y, true, this.selfButtonText);
    }

    private void run(int menuPlace) {
        if (this.currentWindow != null) this.currentWindow.setVisible(false);

        this.windows[menuPlace].setVisible(true);
        this.currentWindow = this.windows[menuPlace];
    }
}
