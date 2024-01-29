package Utils;

import javax.swing.*;

public final class Constants {
    public static final class RobotGIFs {
        public enum Gifs {
            ROBOT_GIF(new ImageIcon("C:\\Users\\PC -23\\IdeaProjects\\PiTV\\src\\GIFs\\robot.gif")),
            SWERVE_GIF(new ImageIcon("C:\\Users\\PC -23\\IdeaProjects\\PiTV\\src\\GIFs\\swerve.gif")),
            SHOT_GIF(new ImageIcon("C:\\Users\\PC -23\\IdeaProjects\\PiTV\\src\\GIFs\\shot.gif")),
            ARM_GIF(new ImageIcon("C:\\Users\\PC -23\\IdeaProjects\\PiTV\\src\\GIFs\\arm.gif")),
            SENSORS_GIF(new ImageIcon("C:\\Users\\PC -23\\IdeaProjects\\PiTV\\src\\GIFs\\sensors.gif"));

            private final ImageIcon currentIcon;

            Gifs(ImageIcon imageIcon) {
                this.currentIcon = imageIcon;
            }

            public ImageIcon getCurrentIcon() {
                return currentIcon;
            }
        }
    }
}
