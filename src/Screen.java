import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.event.KeyEvent.VK_F4;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class Screen extends JFrame implements KeyListener {
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
    private final Window wiringWindow;
    private final Window monitoringWindow;

    private final Window swerveProgrammingWindow;
    private final Window intakeProgrammingWindow;
    private final Window shooterProgrammingWindow;
    private final Window climberProgrammingWindow;
    private final Window autonomousWindow;
    private final Window imageProcessingWindow;

    private final Window javaCourse;
    private final Window mentorsCourseToFLL;
    private final Window babaDa;
    private final Window mentoringFLLGroups;
    private final Window volunteeringInFIRST;
    private final Window excaliday;
    private final Window exposingRoboticsToChildren;
    private final Window distributionFIRSTandSTEM;
    private final Window donatingBooksToSoldiers;
    private final Window swordOfPeace;
    private final Window volunteeringWithDisplacedFamilies;

    private Window currentWindow;

    private static final int DEPUTY_MENU_WIDTH = 115;
    private static final int DEPUTY_MENU_HEIGHT = 522;

    private static final int DEPUTY_MENU_X = 1795;
    private static final int DEPUTY_MENU_Y = 120;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 100;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 80;

    private static final int DEPUTY_MENU_BUTTONS_X = 873;

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
        this.excaliburLabel.setBounds(13, 10, 450, 80);

        this.excaliburPanel.setLayout(null);
        this.excaliburPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.excaliburPanel.setBackground(Colors.BLUE.color);

        this.excaliburPanel.add(excaliburLabel);
        this.excaliburPanel.setBounds(10, 10, 538, 100);
        this.add(excaliburPanel);

        this.ironSwordPanel = new JPanel();
        this.ironSwordIcon = new ImageIcon("ironSword.jpg");
        this.ironSwordLabel = new JLabel(ironSwordIcon);

        this.ironSwordLabel.setBounds(870, 650, 105, 300);

        this.ironSwordPanel.setLayout(null);
        this.ironSwordPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.ironSwordPanel.setBackground(Colors.BLUE.color);

        this.ironSwordPanel.add(ironSwordLabel);
        this.ironSwordPanel.setBounds(1795, 645, 115, 425);
        this.add(ironSwordPanel);

        //set frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH); // 1920 * 1080
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

        wiringWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(wiringWindow);
        this.wiringWindow.setVisible(false);

        monitoringWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(monitoringWindow);
        this.monitoringWindow.setVisible(false);

        //programming
        swerveProgrammingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swerveProgrammingWindow);
        this.swerveProgrammingWindow.setVisible(false);

        intakeProgrammingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeProgrammingWindow);
        this.intakeProgrammingWindow.setVisible(false);

        shooterProgrammingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(shooterProgrammingWindow);
        this.shooterProgrammingWindow.setVisible(false);

        climberProgrammingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberProgrammingWindow);
        this.climberProgrammingWindow.setVisible(false);

        autonomousWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(autonomousWindow);
        this.autonomousWindow.setVisible(false);

        imageProcessingWindow = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(imageProcessingWindow);
        this.imageProcessingWindow.setVisible(false);

        //community
        javaCourse = new Window("", "javaCourse", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(javaCourse);
        this.javaCourse.setVisible(false);
        mentorsCourseToFLL = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(mentorsCourseToFLL);
        this.mentorsCourseToFLL.setVisible(false);
        babaDa = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(babaDa);
        this.babaDa.setVisible(false);
        mentoringFLLGroups = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(mentoringFLLGroups);
        this.mentoringFLLGroups.setVisible(false);
        volunteeringInFIRST = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(volunteeringInFIRST);
        this.volunteeringInFIRST.setVisible(false);
        excaliday = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(excaliday);
        this.excaliday.setVisible(false);
        exposingRoboticsToChildren = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(exposingRoboticsToChildren);
        this.exposingRoboticsToChildren.setVisible(false);
        distributionFIRSTandSTEM = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(distributionFIRSTandSTEM);
        this.distributionFIRSTandSTEM.setVisible(false);
        donatingBooksToSoldiers = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(donatingBooksToSoldiers);
        this.donatingBooksToSoldiers.setVisible(false);
        swordOfPeace = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(swordOfPeace);
        this.swordOfPeace.setVisible(false);
        volunteeringWithDisplacedFamilies = new Window("", "", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(volunteeringWithDisplacedFamilies);
        this.volunteeringWithDisplacedFamilies.setVisible(false);

        //menus
        this.currentMenu = new Menu(0, 0, 0, 0, 0, 0);

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(modelingWindow), "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 17),
                new MyButton(() -> this.hidePrevAndShowNextWindow(productionWindow), "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 11),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveMechanicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeMechanicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterMechanicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberMechanicsWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 24)
        );
        this.add(mechanicsMenu);

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveElectronicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeElectronicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 293, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterElectronicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberElectronicsWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 459, 24),
                new MyButton(() -> this.hidePrevAndShowNextWindow(wiringWindow), "Wiring", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 542, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(monitoringWindow), "Monitoring", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 659, 10)
        );
        this.add(electronicsMenu);

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveProgrammingWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeProgrammingWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 30),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterProgrammingWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 25),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberProgrammingWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 24),
                new MyButton(() -> this.hidePrevAndShowNextWindow(autonomousWindow), "Autonomous", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 9),
                new MyButton(() -> this.hidePrevAndShowNextWindow(imageProcessingWindow), "<html>image<br>processing</html>", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 10)
        );
        this.add(programmingMenu);

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH * 2, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP, 6, 2,
                new MyButton(() -> this.hidePrevAndShowNextWindow(javaCourse), "קורס ג'אווה", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(mentorsCourseToFLL), "קורס מנטורים ל-FLL", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(babaDa), "בבא-דע", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(mentoringFLLGroups), "מנטור קבוצות FLL", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringInFIRST), "התנדבויות ב-FIRST", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(excaliday), "EXCALIDAY", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(exposingRoboticsToChildren), "חשיפת הרובוטיקה לילדים", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(distributionFIRSTandSTEM), "הפצת FIRST ו-STEM", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(donatingBooksToSoldiers), "תרומת ספרים לחיילים", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swordOfPeace), "SWORD of PEACE", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringWithDisplacedFamilies), "התנדבויות עם המשפחות המפונות", DEPUTY_MENU_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, 0)
        );
        this.add(communityMenu);

        this.stuffMenu = new Menu(430, 100, 1480, 10, 5, 7,
                new MyButton(() -> this.hidePrevAndShowNextMenu(this.mechanicsMenu), "Mechanics", 100, 80, 557, 20, 14),
                new MyButton(() -> this.hidePrevAndShowNextMenu(this.electronicsMenu), "Electronics", 100, 80, 662, 20, 12),
                new MyButton(() -> this.hidePrevAndShowNextMenu(this.programmingMenu), "Programming", 100, 80, 767, 20, 3),
                new MyButton(() -> this.hidePrevAndShowNextMenu(this.communityMenu), "Community", 100, 80, 872, 20, 9)
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

    private void hidePrevAndShowNextMenu(Menu menu) {
        this.currentWindow.setVisible(false);
        this.currentMenu.setVisible(false);
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

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == VK_F4) System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


//    private void hideOtherWindowsAndMenus(Menu... menus, Window... windows) {
//        for (Menu menu : menus)  menu.setVisible(false);
//        for (Window window : windows)  window.setVisible(false);
//    }

//    https://chat.openai.com/share/36e1b1b9-0c41-4acd-87ad-069a1c7bc119
}
