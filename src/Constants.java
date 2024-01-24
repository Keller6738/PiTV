import javax.swing.*;
import java.awt.*;

public final class Constants {
    public static final class RobotGIFs {
        public enum GifsConstants {
            ROBOT_GIF(new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\robot.gif")),
            SWERVE_GIF(new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\swerve.gif")),
            SHOT_GIF(new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\shot.gif")),
            ARM_GIF(new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\arm.gif")),
            SENSORS_GIF(new ImageIcon("C:\\Users\\Excalibur\\IdeaProjects\\PiTV\\src\\GIFs\\sensors.gif"));

            private final ImageIcon currentIcon;

            GifsConstants(ImageIcon imageIcon) {
                this.currentIcon = imageIcon;
            }
        }
    }
}
