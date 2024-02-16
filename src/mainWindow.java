import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class mainWindow extends JFrame {
//    private final JPanel panel;
    private final Menu stuffMenu;
    private final Menu mechanicsMenu;
    private final Menu electronicsMenu;
    private final Menu programmingMenu;
    private final Menu communityMenu;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 100;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 140;

    public mainWindow() {
//        this.panel = new JPanel(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1000, 1000);
//        this.panel.setSize(this.getSize());
//        this.setForeground(Colors.BLUE.color);
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(new BorderLayout());

        this.mechanicsMenu = new Menu(new Dimension(100, 700),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT))
        );

        this.electronicsMenu = new Menu(new Dimension(100, 700),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT))
        );

        this.programmingMenu = new Menu(new Dimension(100, 700),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT))
        );

        this.communityMenu = new Menu(new Dimension(100, 700),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT)),
                new MyButton(() -> {}, "", new Dimension(DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT))
        );

        this.stuffMenu = new Menu(new Dimension(1000, 100),
                new MyButton(() -> mechanicsMenu.setVisible(true), "Mechanics", new Dimension(250, 200)),
                new MyButton(() -> electronicsMenu.setVisible(true), "Electronics", new Dimension(250, 200)),
                new MyButton(() -> programmingMenu.setVisible(true), "Programming", new Dimension(250, 200)),
                new MyButton(() -> communityMenu.setVisible(true), "Community", new Dimension(250, 200))
        );

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

//        this.add(panel);
        this.add(stuffMenu, SOUTH);

        this.setVisible(true);
//        this.panel.setVisible(true);
    }
}
