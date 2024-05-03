package Screens;

import Utils.*;

public class DeputyMenu extends BasicMenu {
    private MyButton selfButton;
    private final String selfButtonText;

    private final Window[] windows;
    private Window currentWindow = null;

    private static final int SELF_BUTTON_Y = 20;
    private static final int SELF_BUTTON_WIDTH = 150;
    private static final int SELF_BUTTON_HEIGHT = 80;

    private static final int DEPUTY_MENU_X = 1745;
    private static final int DEPUTY_MENU_Y = 120;
    private static final int DEPUTY_MENU_WIDTH = 165;
    private static final int DEPUTY_MENU_HEIGHT = 522;

    private static final int H_GAP = 5;
    private static final int V_GAP = 7;

    private static final int WINDOW_BUTTON_HEIGHT = 80;

    public DeputyMenu(String selfButtonText, boolean isLonger, WindowContent... windowsContents) {
        super(DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_WIDTH, isLonger ? DEPUTY_MENU_HEIGHT + 400 : DEPUTY_MENU_HEIGHT, H_GAP, V_GAP);

        this.windows = new Window[windowsContents.length];
        for (int i = 0; i < this.windows.length; i++) {
            this.windows[i] = new Window(this.getY() + WINDOW_BUTTON_HEIGHT * i + V_GAP * i, windowsContents[i].getFileName(), windowsContents[i].getScaleFactor(), windowsContents[i].getButtonText());

            int finalI = i;
            this.windows[i].setSelfButton(() -> run(finalI));

            this.add(this.windows[i].getSelfButton());
        }

        this.selfButtonText = selfButtonText;
    }

    public Window getCurrentWindow() {
        return currentWindow;
    }

    public MyButton getSelfButton() {
        return selfButton;
    }

    public void setSelfButton(Runnable run, int buttonX) {
        this.selfButton = new MyButton(run, SELF_BUTTON_WIDTH, SELF_BUTTON_HEIGHT, buttonX, SELF_BUTTON_Y, true, this.selfButtonText);
    }

    private void run(int menuPlace) {
        if (this.currentWindow != null) this.currentWindow.setVisible(false);

        this.windows[menuPlace].setVisible(true);
        this.currentWindow = this.windows[menuPlace];
    }
}
