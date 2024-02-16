import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame {
    private final JPanel panel;
    private final Menu stuffMenu;
//    private final mainWindow mainWindow;
    //    private final Menu mechanicsMenu;
//    private final Menu electronicsMenu;
//    private final Menu programmingMenu;
//    private final Menu communityMenu;

    public mainWindow() {
        this.panel = new JPanel(null);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setUndecorated(true);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(1000, 1000);
        this.panel.setSize(this.getSize());
        this.panel.setBackground(Colors.BLUE.color);
        this.panel.setLayout(new BorderLayout());


        this.stuffMenu = new Menu(new Dimension(1680, 50),
                new MyButton(() -> {}, "Mechanics", new Dimension(300, 50)),
                new MyButton(()-> {}, "Electronics", new Dimension(300, 50)),
                new MyButton(()->{}, "Programming", new Dimension(300, 50)),
                new MyButton(()->{}, "Community", new Dimension(300, 50))
        );

        this.panel.setFocusable(true);
        this.panel.setFocusTraversalKeysEnabled(false);

        this.add(panel);
        this.add(stuffMenu);

        this.setVisible(true);
//        this.panel.setVisible(true);
    }
}
