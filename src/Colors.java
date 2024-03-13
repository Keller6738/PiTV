import java.awt.*;

public enum Colors {
    BLUE(new Color(1, 34, 101)),
    YELLOW(new Color(211, 175, 55)),
    DARK_YELLOW(new Color(211, 100, 0));

    public final Color color;

    Colors(Color color) {
        this.color = color;
    }
}
