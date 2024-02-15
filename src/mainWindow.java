import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.SOUTH;
import static java.awt.Color.WHITE;

public class mainWindow extends JFrame {

    public mainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(WHITE);
        this.setLayout(new BorderLayout());

        this.add(new stuffPanel(), SOUTH);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);
    }
}
