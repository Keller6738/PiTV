import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.event.KeyEvent.*;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;

public class Screen extends JFrame implements KeyListener {
    //initialize

    //design panels
    private final JPanel excaliburPanel;
    private final JLabel excaliburLabel;
    private ImageIcon excaliburIcon;

    private final JPanel rightSidePanel;
    private final JLabel rightSideLabel;
    private final ImageIcon rightSideIcon;

    private final JPanel hourPanel;
    private final JLabel hourLabel;

    private final JPanel leftSidePanel;
    private final JLabel leftSideLabel;
    private final ImageIcon leftSideIcon;

    //menus
    private final Menu stuffMenu;
    private final Menu mechanicsMenu;
    private final Menu electronicsMenu;
    private final Menu programmingMenu;
    private final Menu communityMenu;
    private Menu currentMenu;


    //windows
    private final Window mainWindow;

    //mechanics
    private final Window modelingWindow;
    private final Window productionWindow;
    private final Window swerveMechanicsWindow;
    private final Window intakeMechanicsWindow;
    private final Window shooterMechanicsWindow;
    private final Window climberMechanicsWindow;

    //electronics
    private final Window swerveElectronicsWindow;
    private final Window intakeElectronicsWindow;
    private final Window shooterElectronicsWindow;
    private final Window mainElectronicsWindow;
    private final Window wiringWindow;
    private final Window monitoringWindow;

    //programming
    private final Window swerveProgrammingWindow;
    private final Window intakeProgrammingWindow;
    private final Window shooterProgrammingWindow;
    private final Window climberProgrammingWindow;
    private final Window autonomousWindow;
    private final Window imageProcessingWindow;

    //community
    private final Window javaCourse;
    private final Window mentorsCourseToFLL;
    private final Window babaDa;
    private final Window helpingFLLGroups;
    private final Window volunteeringInFIRST;
    private final Window shiba;
    private final Window groupExposure;
    private final Window distributionFIRSTandSTEM;
    private final Window openingFRCgroups;
    private final Window swordOfPeace;
    private final Window volunteeringWithDisplacedFamilies;

    private Window currentWindow;

    //constants
    private static final int DEPUTY_MENU_WIDTH = 165;
    private static final int DEPUTY_MENU_HEIGHT = 522;

    private static final int DEPUTY_MENU_X = 1745;
    private static final int DEPUTY_MENU_Y = 120;

    private static final int DEPUTY_MENU_BUTTONS_WIDTH = 150;
    private static final int DEPUTY_MENU_BUTTONS_HEIGHT = 80;

    private static final int DEPUTY_MENU_BUTTONS_X = 823;

    private static final int DEPUTY_MENU_BUTTONS_H_GAP = 5;
    private static final int DEPUTY_MENU_BUTTONS_V_GAP = 5;

    private static final int WINDOWS_WIDTH = 1400;
    private static final int WINDOWS_HEIGHT = 950;

    private static final int WINDOWS_X = 340;
    private static final int WINDOWS_Y = 120;

    private static Random rnd = new Random();
    private Timer switchTimer = new Timer(10000, e -> autoChangeMode());

    public Screen() {
        this.currentWindow = new Window("goodLuck.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.2);
        this.add(currentWindow);
        //design panels
        //excalibur panel
        this.excaliburPanel = new JPanel();
        this.excaliburIcon = new ImageIcon("excalibur6738.png");
        this.excaliburIcon = this.scaleImageIcon(excaliburIcon, 0.65);
        this.excaliburLabel = new JLabel(excaliburIcon, CENTER);

        this.excaliburLabel.setHorizontalTextPosition(RIGHT);
        this.excaliburLabel.setFont(new Font("", BOLD, 45));
        this.excaliburLabel.setForeground(Colors.YELLOW.color);
        this.excaliburLabel.setBounds(13, 2, 790, 80);

        this.excaliburPanel.setLayout(null);
        this.excaliburPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.excaliburPanel.setBackground(Colors.BLUE.color);

        this.excaliburPanel.add(excaliburLabel);
        this.excaliburPanel.setBounds(10, 10, 800, 100);
        this.add(excaliburPanel);

        this.mainWindow = new Window("goodLuck.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.2);
        this.add(mainWindow);

        //right side panel
        this.rightSidePanel = new JPanel();
        this.rightSideIcon = this.scaleImageIcon(new ImageIcon("right1.png"), 0.5);
        this.rightSideLabel = new JLabel(rightSideIcon);

        this.rightSideLabel.setBounds(0, 0, 155, 400);

        this.rightSidePanel.setLayout(null);
        this.rightSidePanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.rightSidePanel.setBackground(Colors.BLUE.color);

        this.rightSidePanel.add(rightSideLabel);
        this.rightSidePanel.setBounds(1745, 645, 165, 425);
        this.add(rightSidePanel);

        //hour panel
        this.hourPanel = new JPanel();
        this.hourPanel.setBackground(Colors.BLUE.color);
        this.hourPanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.hourLabel = new JLabel();
        this.hourLabel.setFont(new Font("", BOLD, 60));

        Timer hourTimer = new Timer(1000, e -> updateTime());
        hourTimer.start();

        this.hourPanel.add(hourLabel);

        this.hourPanel.setBounds(820, 10, 450, 100);
        this.add(hourPanel);

        //left side panel
        this.leftSidePanel = new JPanel();
        this.leftSideIcon = this.scaleImageIcon(new ImageIcon("left.png"), 1.1);
        this.leftSideLabel = new JLabel(leftSideIcon);

        this.leftSideLabel.setBounds(0, 80, 315, 800);

        this.leftSidePanel.setLayout(null);
        this.leftSidePanel.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
        this.leftSidePanel.setBackground(Colors.BLUE.color);

        this.leftSidePanel.add(leftSideLabel);
        this.leftSidePanel.setBounds(10, 120, 320, 950);
        this.add(leftSidePanel);

        //set frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH); // 1920 * 1080
//        this.setSize(1920, 1080);
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        //windows

        //mechanics
        modelingWindow = new Window("modeling.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(modelingWindow);
        this.modelingWindow.setVisible(false);

        productionWindow = new Window("production.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(productionWindow);
        this.productionWindow.setVisible(false);

        swerveMechanicsWindow = new Window("swerveMechanics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(swerveMechanicsWindow);
        this.swerveMechanicsWindow.setVisible(false);

        intakeMechanicsWindow = new Window("intakeMechanics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(intakeMechanicsWindow);
        this.intakeMechanicsWindow.setVisible(false);

        shooterMechanicsWindow = new Window("shooterMechanics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(shooterMechanicsWindow);
        this.shooterMechanicsWindow.setVisible(false);

        climberMechanicsWindow = new Window("climberMechanics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(climberMechanicsWindow);
        this.climberMechanicsWindow.setVisible(false);

        //electronics
        mainElectronicsWindow = new Window("mainElectronics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.15);
        this.add(mainElectronicsWindow);
        this.mainElectronicsWindow.setVisible(false);

        swerveElectronicsWindow = new Window("swerveElectronics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.15);
        this.add(swerveElectronicsWindow);
        this.swerveElectronicsWindow.setVisible(false);

        intakeElectronicsWindow = new Window("intakeElectronics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.2);
        this.add(intakeElectronicsWindow);
        this.intakeElectronicsWindow.setVisible(false);

        shooterElectronicsWindow = new Window("shooterElectronics.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.2);
        this.add(shooterElectronicsWindow);
        this.shooterElectronicsWindow.setVisible(false);

        wiringWindow = new Window("wiring.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.15);
        this.add(wiringWindow);
        this.wiringWindow.setVisible(false);

        monitoringWindow = new Window("sensors.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(monitoringWindow);
        this.monitoringWindow.setVisible(false);

        //programming
        swerveProgrammingWindow = new Window("swerveProgramming.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.5);
        this.add(swerveProgrammingWindow);
        this.swerveProgrammingWindow.setVisible(false);

        intakeProgrammingWindow = new Window("intakeProgramming.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(intakeProgrammingWindow);
        this.intakeProgrammingWindow.setVisible(false);

        shooterProgrammingWindow = new Window("shooterProgramming.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.1);
        this.add(shooterProgrammingWindow);
        this.shooterProgrammingWindow.setVisible(false);

        climberProgrammingWindow = new Window("climberProgramming.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(climberProgrammingWindow);
        this.climberProgrammingWindow.setVisible(false);

        autonomousWindow = new Window("Auto.gif", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(autonomousWindow);
        this.autonomousWindow.setVisible(false);
        //2024 V
        imageProcessingWindow = new Window("poseEstimation.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y);
        this.add(imageProcessingWindow);
        this.imageProcessingWindow.setVisible(false);

        //community
        javaCourse = new Window("javaCourse.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1);
        this.add(javaCourse);
        this.javaCourse.setVisible(false);
        mentorsCourseToFLL = new Window("mentorsCourse.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(mentorsCourseToFLL);
        this.mentorsCourseToFLL.setVisible(false);
        babaDa = new Window("babaDa.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(babaDa);
        this.babaDa.setVisible(false);
        helpingFLLGroups = new Window("helpingFLLGroups.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(helpingFLLGroups);
        this.helpingFLLGroups.setVisible(false);
        volunteeringInFIRST = new Window("volunteeringInFIRST.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(volunteeringInFIRST);
        this.volunteeringInFIRST.setVisible(false);
        distributionFIRSTandSTEM = new Window("distributionFIRSTandSTEM.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(distributionFIRSTandSTEM);
        this.distributionFIRSTandSTEM.setVisible(false);
        groupExposure = new Window("groupExposure.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(groupExposure);
        this.groupExposure.setVisible(false);
        swordOfPeace = new Window("swordOfPeace.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(swordOfPeace);
        this.swordOfPeace.setVisible(false);
        volunteeringWithDisplacedFamilies = new Window("volunteeringWithDisplacedFamilies.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(volunteeringWithDisplacedFamilies);
        this.volunteeringWithDisplacedFamilies.setVisible(false);
        openingFRCgroups = new Window("OpeningFRCgroups.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(openingFRCgroups);
        this.openingFRCgroups.setVisible(false);
        shiba = new Window("shiba.png", WINDOWS_WIDTH, WINDOWS_HEIGHT, WINDOWS_X, WINDOWS_Y, 1.33);
        this.add(shiba);
        this.shiba.setVisible(false);

        //menus
        this.currentMenu = new Menu(0, 0, 0, 0, 0, 0);

        this.mechanicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(modelingWindow), "Modeling", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 38),
                new MyButton(() -> this.hidePrevAndShowNextWindow(productionWindow), "Production", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 33),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveMechanicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 45),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeMechanicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 51),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterMechanicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 43),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberMechanicsWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 45)
        );
        this.add(mechanicsMenu);

        this.electronicsMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(mainElectronicsWindow), String.format("<html>%smain<br>%selectronics</html>", this.indent(10), this.indent(5)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 459, 15),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveElectronicsWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 45),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeElectronicsWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 293, 51),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterElectronicsWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 376, 43),
                new MyButton(() -> this.hidePrevAndShowNextWindow(wiringWindow), "Wiring", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 542, 50),
                new MyButton(() -> this.hidePrevAndShowNextWindow(monitoringWindow), "Sensors", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_X, 659, 45)
        );
        this.add(electronicsMenu);

        this.programmingMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT, DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(swerveProgrammingWindow), "Swerve", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 45),
                new MyButton(() -> this.hidePrevAndShowNextWindow(intakeProgrammingWindow), "Intake", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 51),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shooterProgrammingWindow), "Shooter", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 43),
                new MyButton(() -> this.hidePrevAndShowNextWindow(climberProgrammingWindow), "Climber", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 45),
                new MyButton(() -> this.hidePrevAndShowNextWindow(autonomousWindow), "Autonomous", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 29),
                new MyButton(() -> this.hidePrevAndShowNextWindow(imageProcessingWindow), "<html>&nbsp;&nbsp;&nbsp;&nbsp;image<br>processing</html>", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 32)
        );
        this.add(programmingMenu);

        this.communityMenu = new Menu(DEPUTY_MENU_WIDTH, DEPUTY_MENU_HEIGHT + this.rightSidePanel.getHeight(), DEPUTY_MENU_X, DEPUTY_MENU_Y, DEPUTY_MENU_BUTTONS_H_GAP, DEPUTY_MENU_BUTTONS_V_GAP,
                new MyButton(() -> this.hidePrevAndShowNextWindow(javaCourse), String.format("<html>%sjava<br>%scourse</html>", this.indent(14), this.indent(12)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 127, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(mentorsCourseToFLL), String.format("<html>%smentors<br>%scourse<br>%sto FLL</html>", this.indent(11), this.indent(12), this.indent(13)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 293, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(babaDa), "בבא-דע", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 376, 52),
                new MyButton(() -> this.hidePrevAndShowNextWindow(helpingFLLGroups), String.format("<html>%shelping to<br>%sFLL groups</html>", this.indent(9), this.indent(8)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 459, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringInFIRST), String.format("<html>%svolunteering<br>%sin FIRST</html>", this.indent(7), this.indent(11)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 542, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(shiba), "SHIBA", DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 659, 52),
                new MyButton(() -> this.hidePrevAndShowNextWindow(groupExposure), String.format("<html>%sgroup<br>%sexposure</html>", this.indent(13), this.indent(10)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(distributionFIRSTandSTEM), String.format("<html>%sdistribution<br>%sFIRST and<br>%sSTEM</html>", this.indent(8), this.indent(9), this.indent(12)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(openingFRCgroups), String.format("<html>%sopening<br>%sFRC<br>%sgroups</html>", this.indent(11), this.indent(15), this.indent(12)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(swordOfPeace), String.format("<html>%sSWORD<br>%sof<br>%sPEACE</html>", this.indent(12), this.indent(17), this.indent(13)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0),
                new MyButton(() -> this.hidePrevAndShowNextWindow(volunteeringWithDisplacedFamilies), String.format("<html>%svolunteering<br>%swith<br>%sdisplaced<br>%sfamilies</html>", this.indent(7), this.indent(15), this.indent(10), this.indent(13)), DEPUTY_MENU_BUTTONS_WIDTH, DEPUTY_MENU_BUTTONS_HEIGHT, DEPUTY_MENU_BUTTONS_X, 0, 0)
        );
        this.add(communityMenu);

        this.stuffMenu = new Menu(630, 100, 1280, 10, 5, 7,
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(rightSidePanel);
                    this.hidePrevAndShowNextMenu(this.mechanicsMenu);
                }, "Mechanics", 150, 80, 557, 20, 24, 20),
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(rightSidePanel);
                    this.hidePrevAndShowNextMenu(this.electronicsMenu);
                }, "Electronics", 150, 80, 662, 20, 21, 20),
                new MyButton(() -> {
                    if (this.currentMenu == this.communityMenu) this.add(rightSidePanel);
                    this.hidePrevAndShowNextMenu(this.programmingMenu);
                }, "Programming", 150, 80, 767, 20, 11, 20),
                new MyButton(() -> {
                    this.hidePrevAndShowNextMenu(this.communityMenu);
                    this.remove(rightSidePanel);
                }, "Community", 150, 80, 872, 20, 20, 20)
        );
        this.add(stuffMenu);

        ///////////////////
        mechanicsMenu.setVisible(false);
        electronicsMenu.setVisible(false);
        programmingMenu.setVisible(false);
        communityMenu.setVisible(false);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(this);

        this.setVisible(true);
    }

    private void hidePrevAndShowNextMenu(Menu menu) {
        this.currentWindow.setVisible(false);
        this.add(mainWindow);
        this.currentMenu.setVisible(false);
        this.currentMenu = menu;
        this.currentMenu.setVisible(true);
    }

    private void hidePrevAndShowNextWindow(Window window) {
        this.currentWindow.setVisible(false);
        this.remove(mainWindow);
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

    public String indent(int numberOfSpaces) {
        return "&nbsp;".repeat(numberOfSpaces);
    }

    private void updateTime() {
        String hour = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.hourLabel.setText(hour);
        this.hourLabel.setForeground(Colors.YELLOW.color);
    }

    private void autoChangeMode() {
        switch (rnd.nextInt(4)) {
            case 0: {
                hidePrevAndShowNextMenu(mechanicsMenu);
                switch (rnd.nextInt(6)) {
                    case 0:
                        hidePrevAndShowNextWindow(modelingWindow);
                    case 1:
                        hidePrevAndShowNextWindow(productionWindow);
                    case 2:
                        hidePrevAndShowNextWindow(swerveMechanicsWindow);
                    case 3:
                        hidePrevAndShowNextWindow(intakeMechanicsWindow);
                    case 4:
                        hidePrevAndShowNextWindow(shooterMechanicsWindow);
                    case 5:
                        hidePrevAndShowNextWindow(intakeMechanicsWindow);
                }
            }
            case 1: {
                hidePrevAndShowNextMenu(electronicsMenu);
                switch (rnd.nextInt(6)) {
                    case 0:
                        hidePrevAndShowNextWindow(mainElectronicsWindow);
                    case 1:
                        hidePrevAndShowNextWindow(swerveElectronicsWindow);
                    case 2:
                        hidePrevAndShowNextWindow(intakeElectronicsWindow);
                    case 3:
                        hidePrevAndShowNextWindow(shooterElectronicsWindow);
                    case 4:
                        hidePrevAndShowNextWindow(wiringWindow);
                    case 5:
                        hidePrevAndShowNextWindow(monitoringWindow);
                }
            }
            case 2: {
                hidePrevAndShowNextMenu(programmingMenu);
                switch (rnd.nextInt(6)) {
                    case 0:
                        hidePrevAndShowNextWindow(swerveProgrammingWindow);
                    case 1:
                        hidePrevAndShowNextWindow(intakeProgrammingWindow);
                    case 2:
                        hidePrevAndShowNextWindow(shooterProgrammingWindow);
                    case 3:
                        hidePrevAndShowNextWindow(climberProgrammingWindow);
                    case 4:
                        hidePrevAndShowNextWindow(autonomousWindow);
                    case 5:
                        hidePrevAndShowNextWindow(imageProcessingWindow);
                }
            }
            case 3: {
                hidePrevAndShowNextMenu(mechanicsMenu);
                switch (rnd.nextInt(11)) {
                    case 0:
                        hidePrevAndShowNextWindow(javaCourse);
                    case 1:
                        hidePrevAndShowNextWindow(mentorsCourseToFLL);
                    case 2:
                        hidePrevAndShowNextWindow(babaDa);
                    case 3:
                        hidePrevAndShowNextWindow(helpingFLLGroups);
                    case 4:
                        hidePrevAndShowNextWindow(volunteeringInFIRST);
                    case 5:
                        hidePrevAndShowNextWindow(shiba);
                    case 6:
                        hidePrevAndShowNextWindow(groupExposure);
                    case 7:
                        hidePrevAndShowNextWindow(distributionFIRSTandSTEM);
                    case 8:
                        hidePrevAndShowNextWindow(openingFRCgroups);
                    case 9:
                        hidePrevAndShowNextWindow(swordOfPeace);
                    case 10:
                        hidePrevAndShowNextWindow(volunteeringWithDisplacedFamilies);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
       switch (e.getKeyCode()) {
           case VK_F4 -> System.exit(0);
           /*case VK_A -> {
               switchTimer.start();
               System.out.println("start");
           }
           case VK_S -> {
               switchTimer.stop();
               System.out.println("stop");
           }*/
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
