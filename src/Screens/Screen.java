package Screens;

import Utils.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.Font.BOLD;
import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.event.KeyEvent.*;
import static javax.swing.SwingConstants.*;

public class Screen extends JFrame implements KeyListener {

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

    private Timer switchTimer = new Timer();
    private TimerTask autoSwitchTask;
    private boolean isAutoSwitch = false;

    //data
    private final MainMenu mainMenu;

    private final DeputyMenu mechanicsMenu;
    private final DeputyMenu electronicsMenu;
    private final DeputyMenu programmingMenu;
    private final DeputyMenu communityMenu;

    public Screen() {
        //design panels

        //excalibur panel
        this.excaliburPanel = new JPanel();
        this.excaliburIcon = new ImageIcon("src/Images/general/excalibur6738.png");
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

//        this.mainWindow = new Screens.Window("goodLuck.png");
//        this.add(mainWindow);

        //right side panel
        this.rightSidePanel = new JPanel();
        this.rightSideIcon = this.scaleImageIcon(new ImageIcon("src/Images/general/right1.png"), 0.5);
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

        Timer hourTimer = new Timer();
        TimerTask hourTask = new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        };
        hourTimer.schedule(hourTask, 0, 1000);

        this.hourPanel.add(hourLabel);

        this.hourPanel.setBounds(820, 10, 450, 100);
        this.add(hourPanel);

        //left side panel
        this.leftSidePanel = new JPanel();
        this.leftSideIcon = this.scaleImageIcon(new ImageIcon("src/Images/general/left.png"), 1.1);
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
        this.getContentPane().setBackground(Colors.BLUE.color);
        this.setLayout(null);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(this);

        this.setVisible(true);

        this.mechanicsMenu = new DeputyMenu("Mechanics", false,
                new WindowContent("src/Images/mechanics/modeling.png", 1.2, "Modeling")
        );

        this.electronicsMenu = new DeputyMenu("Electronics", false,
                new WindowContent("src/Images/electronics/mainElectronics.png", 1.15, "Main", "Electronics")
        );

        this.programmingMenu = new DeputyMenu("Programming", false,
                new WindowContent("src/Images/programming/swerveProgramming.png", 1.5, "swerve")
        );

        this.communityMenu = new DeputyMenu("Community", false,
                new WindowContent("src/Images/community/javaCourse.png", "Java", "Course")
        );

        this.mainMenu = new MainMenu(
                new DeputyMenuContent("Mechanics", false,
                        new WindowContent("src/Images/mechanics/modeling.png", 1.2, "Modeling")),
                new DeputyMenuContent("Electronics", false,
                        new WindowContent("src/Images/electronics/mainElectronics.png", 1.15, "Main", "Electronics")),
                new DeputyMenuContent("Programming", false,
                        new WindowContent("src/Images/programming/swerveProgramming.png", 1.5, "swerve")),
                new DeputyMenuContent("Community", false,
                        new WindowContent("src/Images/community/javaCourse.png", "Java", "Course"))
        );

        this.add(mainMenu);
    }

    private ImageIcon scaleImageIcon(ImageIcon originalIcon, double scaleFactor) {
        Image originalImage = originalIcon.getImage();

        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private static ImageIcon scaleGifIcon(ImageIcon originalIcon, int newWidth, int newHeight) {
        try {
            Image image = originalIcon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();

            BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = scaledImage.createGraphics();
            g.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null);
            g.dispose();

            // Save scaled image frames to a new GIF
            File outputfile = new File("src/Images/general/scaled.gif"); // Change the file name as needed
            ImageIO.write(scaledImage, "gif", outputfile);

            return new ImageIcon(outputfile.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String indent(int numberOfSpaces) {
        return "&nbsp;".repeat(numberOfSpaces);
    }

    private void updateTime() {
        String hour = new SimpleDateFormat("HH:mm:ss").format(new Date());
        this.hourLabel.setText(hour);
        this.hourLabel.setForeground(Colors.YELLOW.color);
    }

    private void autoSwitchMode() {
        autoSwitchTask = new TimerTask() {
            @Override
            public void run() {
                /*int rand = new Random().nextInt(4);
                System.out.println(rand);
                switch (rand) {
                    case 0: {
                        hidePrevAndShowNextMenu(mechanicsMenu);
                        rand = new Random().nextInt(6);
                        System.out.println(rand);
                        switch (rand) {
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
                        rand = new Random().nextInt(6);
                        System.out.println(rand);
                        switch (rand) {
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
                        rand = new Random().nextInt(6);
                        System.out.println(rand);
                        switch (rand) {
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
                        rand = new Random().nextInt(11);
                        System.out.println(rand);
                        switch (rand) {
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
                }*/
//                int rand = new Random().nextInt(stuffMenu.getNumButtons());

//                rand = new Random().nextInt(currentMenu.getNumButtons());
            }
        };
        switchTimer.schedule(autoSwitchTask, 0, 5000);
        isAutoSwitch = true;
    }

    private void stopAutoSwitch() {
        autoSwitchTask.cancel();
        isAutoSwitch = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_F4 -> System.exit(0);
            case VK_A -> autoSwitchMode();
            case VK_S -> stopAutoSwitch();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
