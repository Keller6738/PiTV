import javax.swing.*;
import java.awt.*;

import static java.awt.FlowLayout.CENTER;

public class stuffPanel extends JPanel {
    //flow
    private final JLabel[] stuffLabels = {
            new JLabel("Mechanics"),
            new JLabel("Electronics"),
            new JLabel("Programing"),
            new JLabel("Community"),
    };

    stuffPanel() {
        this.setLayout(new FlowLayout(CENTER, 1920, 50));
        for (int i = 0; i < 4; i++) {
            this.stuffLabels[i].setSize(new Dimension(480 ,50));
            this.add(stuffLabels[i]);
        }
    }
}
