package Screens;

import Utils.*;


public class MainMenu {
    private final Menu[] menus;
    private Menu currentMenu = null;

    private static final int MAIN_MENU_X = 1280;
    private static final int MAIN_MENU_Y = 10;
    private static final int MAIN_MENU_WIDTH = 630;
    private static final int MAIN_MENU_HEIGHT = 100;

    private static final int H_GAP = 5;
    private static final int V_GAP = 7;

    public MainMenu(MenuContent... menuContents) {
        super(MAIN_MENU_X, MAIN_MENU_Y, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT, H_GAP, V_GAP);

        WindowContent[] windowContents;
        this.menus = new Menu[menuContents.length];
        for (int i = 0; i < this.menus.length; i++) {
            windowContents = new WindowContent[menuContents[i].getWindowContentsLength()];
            for (int j = 0; j < windowContents.length; j++) {
                windowContents[j] = menuContents[i].getWindowContent(j);
            }
            this.menus[i] = new DeputyMenu(menuContents[i].getButtonText(), menuContents[i].isLonger(), windowContents);

            int finalI = i;
            this.menus[i].setSelfButton(() -> run(finalI), 557 + 115 * i);

            this.add(this.menus[i].getSelfButton());
        }
    }

    private void run(int menuPlace) {
        if (this.currentMenu != null) {
            this.currentMenu.setVisible(false);
            if (this.currentMenu.getCurrentWindow() != null) this.currentMenu.getCurrentWindow().setVisible(false);
        }

        this.menus[menuPlace].setVisible(true);
        this.currentMenu = this.menus[menuPlace];
    }
}
