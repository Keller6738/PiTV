import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class Screen extends JFrame {
    private final JPanel excaliburPanel;
    private final JLabel excaliburLabel;
    private final ImageIcon excaliburIcon;

    private final JPanel ironSwordPanel;
    private final JLabel ironSwordLabel;
    private final ImageIcon ironSwordIcon;

    private Menu stuffMenu;
    private Menu mechanicsMenu;
    private Menu electronicsMenu;
    private Menu programmingMenu;
    private Menu communityMenu;

    private Menu currentMenu;

    private final Window modelingWindow;
    private final Window productionWindow;
    private final Window swerveWindow;
    private final Window intakeWindow;
    private final Window shooterWindow;
    private final Window climberWindow;

    private Window currentWindow;

    private static final int DEPUTY_MENU_WIDTH = 115;

    private static final int DEPUTY_MENU_BOUNDS_X = 865;
    private static final int DEPUTY_MENU_BOUNDS_Y = 120;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 100;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 80;

    private static final int DEPUTY_MENU_BUTTONS_BOUNDS_X = 873;

    private static final int DEPUTY_MENU_BUTTONS_H_GAP = 5;
    private static final int DEPUTY_MENU_BUTTONS_V_GAP = 5;

    private static final int WINDOWS_WIDTH = 850;
    private static final int WINDOWS_HEIGHT = 830;

    private static final int WINDOWS_X = 7;
    private static final int WINDOWS_Y = 120;

    public Screen() {
        ///////////////////////////////////
        this.excaliburPanel = new JPanel();
        this.excaliburIcon = new ImageIcon("Excalibur.jpg");
        this.excaliburLabel = new JLabel("Excalibur", excaliburIcon, CENTER);

        this.excaliburLabel.setHorizontalTextPosition(RIGHT);
        this.excaliburLabel.setFont(new Font("", BOLD, 45));
        this.excaliburLabel.setForeground(Colors.YELLOW.color);
        this.excaliburLabel.setBounds(10, 10, 450, 80);

        this.excaliburPanel.setLayout(null);
        this.excaliburPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.excaliburPanel.setBackground(Colors.BLUE.color);

        this.excaliburPanel.add(excaliburLabel);
        this.excaliburPanel.setBounds(7, 10, 538, 100);

        this.ironSwordPanel = new JPanel();
        this.ironSwordIcon = new ImageIcon("ironSword.jpg");
        this.ironSwordLabel = new JLabel(ironSwordIcon);

        this.ironSwordLabel.setBounds(870, 650, 105, 300);

        this.ironSwordPanel.setLayout(null);
        this.ironSwordPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.ironSwordPanel.setBackground(Colors.BLUE.color);

        this.ironSwordPanel.add(ironSwordLabel);
        this.ironSwordPanel.setBounds(865, 645, 115, 304);
        ///////////////////////////////////

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1000, 1000);
//        this.panel.setSize(this.getSize());
//        this.setForeground(Colors.BLUE.color);
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        //////////////////////
        modelingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(modelingWindow);
        this.modelingWindow.setVisible(false);

        productionWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(productionWindow);
        this.productionWindow.setVisible(false);

        swerveWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveWindow);
        this.swerveWindow.setVisible(false);

        intakeWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeWindow);
        this.intakeWindow.setVisible(false);

        shooterWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterWindow);
        this.shooterWindow.setVisible(false);

        climberWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberWindow);
        this.climberWindow.setVisible(false);

        /////////////////////
        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, 522, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                    this.modelingWindow.setVisible(true);
                    this.modelingWindow.hideOtherWindows();
                }, "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 127, 19),
                new MyButton(() -> {
                    this.productionWindow.setVisible(true);
                    this.productionWindow.hideOtherWindows();
                }, "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 210, 14),
                new MyButton(() -> {
                    this.swerveWindow.setVisible(true);
                    this.  swerveWindow.hideOtherWindows();
                }, "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 293, 25),
                new MyButton(() -> {
                    this.intakeWindow.setVisible(true);
                    this.intakeWindow.hideOtherWindows();
                }, "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 376, 30),
                new MyButton(() -> {
                    this.shooterWindow.setVisible(true);
                    this.shooterWindow.hideOtherWindows();
                }, "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 459, 25),
                new MyButton(() -> {
                    this.climberWindow.setVisible(true);
                    this.climberWindow.hideOtherWindows();
                }, "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 542, 24)
        );
        this.add(mechanicsMenu);

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );
        this.add(electronicsMenu);

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );
        this.add(programmingMenu);

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                }, "", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
        );
        this.add(communityMenu);

        this.stuffMenu = new Menu(430, 100, 550, 10, 5, 7,
                new MyButton(() -> {
                    this.currentMenu.setVisible(false);
                    this.currentMenu = mechanicsMenu;
                    this.mechanicsMenu.setVisible(true);
                }, "Mechanics", 100, 80, 557, 20, 14),
                new MyButton(() -> {
                    this.currentMenu.setVisible(false);
                    this.currentMenu = electronicsMenu;
                    this.electronicsMenu.setVisible(true);
                }, "Electronics", 100, 80, 662, 20, 12),
                new MyButton(() -> {
                    this.currentMenu.setVisible(false);
                    this.currentMenu = programmingMenu;
                    this.programmingMenu.setVisible(true);
                }, "Programming", 100, 80, 767, 20, 3),
                new MyButton(() -> {
                    this.currentMenu.setVisible(false);
                    this.currentMenu = communityMenu;
                    this.communityMenu.setVisible(true);
                }, "Community", 100, 80, 872, 20, 9)
        );

        mechanicsMenu.setVisible(false);
        electronicsMenu.setVisible(false);
        programmingMenu.setVisible(false);
        communityMenu.setVisible(false);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.add(excaliburPanel);
        this.add(ironSwordPanel);
        this.add(stuffMenu);

        this.setVisible(true);
    }

//    private void hideOtherWindowsAndMenus(Menu... menus, Window... windows) {
//        for (Menu menu : menus)  menu.setVisible(false);
//        for (Window window : windows)  window.setVisible(false);
//    }

//    https://chat.openai.com/share/36e1b1b9-0c41-4acd-87ad-069a1c7bc119
}
