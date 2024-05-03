package Utils;


import javax.swing.*;
import java.awt.*;

public class BasicMenu extends JLabel {

    public BasicMenu(int x, int y, int width, int height, int hGap, int vGap) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, hGap, vGap));
        this.setBackground(Colors.BLUE.color);
        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));
    }
}
