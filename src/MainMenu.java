import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;


public class MainMenu extends JPanel {
     private final Menu[] menus;

    private static final int MENU_WIDTH = 630;
    private static final int MENU_HEIGHT = 100;
    private static final int MENU_X = 1280;
    private static final int MENU_Y = 10;

    private static final int H_GAP = 5;
    private static final int V_GAP = 7;

     public MainMenu(Menu... menus) {
         this.menus = new Menu[menus.length];

         for (int i = 0; i < this.menus.length; i++) {
             this.menus[i] = menus[i];

             this.add(this.menus[i].getSelfButton());
         }
             this.setLayout(new FlowLayout(CENTER, H_GAP, V_GAP));

             this.setBackground(Colors.BLUE.color);
             this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

             this.setBounds(MENU_X, MENU_Y, MENU_WIDTH, MENU_HEIGHT);
     }
}
