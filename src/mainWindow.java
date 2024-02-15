import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame {

    public mainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        this.add(new stuffPanel(), BorderLayout.SOUTH);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        this.setVisible(true);
    }
}
