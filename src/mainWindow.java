import Manues.StuffMenu;
import Util.Buttons;
import Util.Menu;
import Util.MyButton;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.WHITE;

public class mainWindow extends JFrame {
    private final Menu stuffMenu;
    private final Menu mechanicsMenu;
    private final Menu electronicsMenu;
    private final Menu programmingMenu;
    private final Menu communityMenu;


    public mainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(WHITE);
        this.setLayout(new BorderLayout());

        this.stuffMenu = new Menu(new Dimension(1680, 50), new MyButton[]{

        });

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        new StuffMenu();

        this.setVisible(true);
    }
}
