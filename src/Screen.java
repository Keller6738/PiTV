import javax.swing.*;
import java.awt.*;

import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_SMOOTH;
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
    private final Window swerveMechanicsWindow;
    private final Window intakeMechanicsWindow;
    private final Window shooterMechanicsWindow;
    private final Window climberMechanicsWindow;

    private final Window swerveElectronicsWindow;
    private final Window intakeElectronicsWindow;
    private final Window shooterElectronicsWindow;
    private final Window climberElectronicsWindow;
    private final Window wiringElectronicsWindow;
    private final Window monitoringElectronicsWindow;

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
        //design panels
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
        this.add(excaliburPanel);

        this.ironSwordPanel = new JPanel();
        this.ironSwordIcon = new ImageIcon("ironSword.jpg");
        this.ironSwordLabel = new JLabel(ironSwordIcon);

        this.ironSwordLabel.setBounds(870, 650, 105, 300);

        this.ironSwordPanel.setLayout(null);
        this.ironSwordPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.ironSwordPanel.setBackground(Colors.BLUE.color);

        this.ironSwordPanel.add(ironSwordLabel);
        this.ironSwordPanel.setBounds(865, 645, 115, 304);
        this.add(ironSwordPanel);

        //set frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        //windows
        this.currentWindow = new Window("", "", 0, 0, 0, 0);

        //mechanics
        modelingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(modelingWindow);
        this.modelingWindow.setVisible(false);

        productionWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(productionWindow);
        this.productionWindow.setVisible(false);

        swerveMechanicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveMechanicsWindow);
        this.swerveMechanicsWindow.setVisible(false);

        intakeMechanicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeMechanicsWindow);
        this.intakeMechanicsWindow.setVisible(false);

        shooterMechanicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterMechanicsWindow);
        this.shooterMechanicsWindow.setVisible(false);

        climberMechanicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberMechanicsWindow);
        this.climberMechanicsWindow.setVisible(false);

        //electronics
        swerveElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveElectronicsWindow);
        this.swerveElectronicsWindow.setVisible(false);

        intakeElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeElectronicsWindow);
        this.intakeElectronicsWindow.setVisible(false);

        shooterElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterElectronicsWindow);
        this.shooterElectronicsWindow.setVisible(false);

        climberElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberElectronicsWindow);
        this.climberElectronicsWindow.setVisible(false);

        wiringElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(wiringElectronicsWindow);
        this.wiringElectronicsWindow.setVisible(false);

        monitoringElectronicsWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(monitoringElectronicsWindow);
        this.monitoringElectronicsWindow.setVisible(false);

        //menus
        this.currentMenu = new Menu(0, 0, 0, 0, 0, 0);

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, 522, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(modelingWindow);
                }, "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 127, 19),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(productionWindow);
                }, "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 210, 14),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(swerveMechanicsWindow);
                }, "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 293, 25),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(intakeMechanicsWindow);
                }, "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 376, 30),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(shooterMechanicsWindow);
                }, "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 459, 25),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(climberMechanicsWindow);
                }, "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_BOUNDS_X, 542, 24)
        );
        this.add(mechanicsMenu);

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, 600, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(swerveElectronicsWindow);
                }, "swerve", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(intakeElectronicsWindow);
                }, "intake", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(shooterElectronicsWindow);
                }, "shooter", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(climberElectronicsWindow);
                }, "climber", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(wiringElectronicsWindow);
                }, "wiring", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0),
                new MyButton(() -> {
                    this.hidePrevAndShowNextWindow(monitoringElectronicsWindow);
                }, "monitoring", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BOUNDS_X, DEPUTY_MENU_BOUNDS_Y, 0)
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
                    this.hideMenu(this.mechanicsMenu);
                }, "Mechanics", 100, 80, 557, 20, 14),
                new MyButton(() -> {
                    this.hideMenu(this.electronicsMenu);
                }, "Electronics", 100, 80, 662, 20, 12),
                new MyButton(() -> {
                    this.hideMenu(this.programmingMenu);
                }, "Programming", "programming.png", 100, 80, 767, 20, 3),
                new MyButton(() -> {
                    this.hideMenu(this.communityMenu);
                }, "Community", 100, 80, 872, 20, 9)
        );
        this.add(stuffMenu);

        ///////////////////
        mechanicsMenu.setVisible(false);
        electronicsMenu.setVisible(false);
        programmingMenu.setVisible(false);
        communityMenu.setVisible(false);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);
    }

    private void hideMenu(Menu menu) {
        this.currentMenu.setVisible(false);
        this.currentWindow.setVisible(false);
        this.currentMenu = menu;
        this.currentMenu.setVisible(true);
    }

    private void hidePrevAndShowNextWindow(Window window) {
        this.currentWindow.setVisible(false);
        this.currentWindow = window;
        this.currentWindow.setVisible(true);
    }

    private ImageIcon scaleImageIcon(ImageIcon originalIcon, double scaleFactor) {
        Image originalImage = originalIcon.getImage();

        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }


//    private void hideOtherWindowsAndMenus(Menu... menus, Window... windows) {
//        for (Menu menu : menus)  menu.setVisible(false);
//        for (Window window : windows)  window.setVisible(false);
//    }

//    https://chat.openai.com/share/36e1b1b9-0c41-4acd-87ad-069a1c7bc119
}
