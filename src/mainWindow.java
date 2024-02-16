import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame {
    private final JPanel panel;
    private final Menu stuffMenu;
    private final Menu mechanicsMenu;
    private final Menu electronicsMenu;
    private final Menu programmingMenu;
    private final Menu communityMenu;

    public mainWindow() {
        this.panel = new JPanel(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1000, 1000);
        this.panel.setSize(this.getSize());
        this.panel.setBackground(Colors.BLUE.color);
        this.panel.setLayout(new BorderLayout());

        this.mechanicsMenu = new Menu(new Dimension(50, 1050),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50))
        );

        this.electronicsMenu = new Menu(new Dimension(50, 1050),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50))
        );

        this.programmingMenu = new Menu(new Dimension(50, 1050),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50))
        );

        this.communityMenu = new Menu(new Dimension(50, 1050),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50)),
                new MyButton(() -> {}, "", new Dimension(200, 50))
        );

        this.stuffMenu = new Menu(new Dimension(1680, 50),
                new MyButton(mechanicsMenu, "Mechanics", new Dimension(200, 50)),
                new MyButton(electronicsMenu, "Electronics", new Dimension(200, 50)),
                new MyButton(programmingMenu, "Programming", new Dimension(200, 50)),
                new MyButton(communityMenu, "Community", new Dimension(200, 50))
        );

        this.stuffMenu.setLocation(0, 950);

        this.panel.setFocusable(true);
        this.panel.setFocusTraversalKeysEnabled(false);

        this.add(panel);
        this.panel.add(stuffMenu);

        this.setVisible(true);
//        this.panel.setVisible(true);
    }
}
