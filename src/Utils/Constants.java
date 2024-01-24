package Utils;

import javax.swing.*;

public final class Constants {
    public static final class RobotGIFsConstants {
        public enum Gifs {
            ROBOT_GIF(new ImageIcon("C:\\Users\\Excalibur1\\IdeaProjects\\PiTV\\src\\GIFs\\robot.gif")),
            SWERVE_GIF(new ImageIcon("C:\\Users\\Excalibur1\\IdeaProjects\\PiTV\\src\\GIFs\\swerve.gif")),
            SHOT_GIF(new ImageIcon("C:\\Users\\Excalibur1\\IdeaProjects\\PiTV\\src\\GIFs\\shot.gif")),
            ARM_GIF(new ImageIcon("C:\\Users\\Excalibur1\\IdeaProjects\\PiTV\\src\\GIFs\\arm.gif")),
            SENSORS_GIF(new ImageIcon("C:\\Users\\Excalibur1\\IdeaProjects\\PiTV\\src\\GIFs\\sensors.gif"));

            private final ImageIcon currentIcon;

            Gifs(ImageIcon imageIcon) {
                this.currentIcon = imageIcon;
            }

            public ImageIcon getCurrentIcon() {
                return currentIcon;
            }
        }
    }

    public static final class ScreenConstants {
        public static final int R_VALUE = 255;
        public static final int G_VALUE = 255;
        public static final int B_VALUE = 255;
    }
}
