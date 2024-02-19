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

    private static final int DEPUTY_MENU_WIDTH = 115;

    private static final int DEPUTY_MENU_BOUNDS_X = 865;
    private static final int DEPUTY_MENU_BOUNDS_Y = 120;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 100;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 80;

    private static final int DEPUTY_MENU_BUTTONS_BOUNDS_X = 873;
    private static final int DEPUTY_MENU_BUTTONS_BOUNDS_Y = 127;

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

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, 510, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 127, 24),
                new MyButton(() -> {}, "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 210, 17),
                new MyButton(() -> {}, "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 293, 28),
                new MyButton(() -> {}, "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 376, 33),
                new MyButton(() -> {}, "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 459, 28),
                new MyButton(() -> {}, "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 542, 27)
        );
        for (MyButton button : this.mechanicsMenu.getButtons()) {
            this.add(button);
        }

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y,
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {}, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );

        this.stuffMenu = new Menu(430, 100, 550, 10,
                new MyButton(() -> this.add(mechanicsMenu), "Mechanics", 100, 80, 557, 20, 17),
                new MyButton(() -> this.add(electronicsMenu), "Electronics", 100, 80, 662, 20, 15),
                new MyButton(() -> this.add(programmingMenu), "Programming", 100, 80, 767, 20, 6),
                new MyButton(() -> this.add(communityMenu), "Community", 100, 80, 872, 20, 12)
        );
        for (MyButton button : this.stuffMenu.getButtons()) {
            this.add(button);
        }

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

//        this.add(panel);
        this.add(stuffMenu);
        this.add(mechanicsMenu);
//
        this.setVisible(true);
//        this.panel.setVisible(true);
    }

//    https://chat.openai.com/share/36e1b1b9-0c41-4acd-87ad-069a1c7bc119
}
