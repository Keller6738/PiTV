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

    private static final int DEPUTY_MENU_WIDTH = 100;
    private static final int DEPUTY_MENU_BOUNDS_X = 870;
    private static final int DEPUTY_MENU_BOUNDS_Y = 100;
    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 100;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 140;
    private static final int DEPUTY_MENU_BUTTONS_BOUNDS_X = 870;
    private static final int DEPUTY_MENU_BUTTONS_BOUNDS_Y = 100;

    public mainWindow() {
//        this.panel = new JPanel(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1000, 1000);
//        this.panel.setSize(this.getSize());
//        this.setForeground(Colors.BLUE.color);
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y)
        );

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y)
        );

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {},


                        "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y)
        );

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y)
        );

        this.stuffMenu = new Menu(420, 70, 550, 10,
                new MyButton(() -> this.add(mechanicsMenu), "Mechanics", 100, 50, 555, 10),  
                new MyButton(() -> this.add(electronicsMenu), "Electronics", 100, 50, 660, 10),
                new MyButton(() -> this.add(programmingMenu), "Programming", 100, 50, 765, 10),
                new MyButton(() -> this.add(communityMenu), "Community", 100, 50, 870, 10)
        );

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

//        this.add(panel);
        this.add(stuffMenu, SOUTH);
//
        this.setVisible(true);
//        this.panel.setVisible(true);
    }
}
