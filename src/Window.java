import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class Window extends JPanel {
    private final JLabel imageLabel;
    private ImageIcon imageIcon;

    public Window(String fileName, int width, int height, int x, int y) {

        this.imageLabel = new JLabel();
        this.imageIcon = new ImageIcon(fileName);
        this.imageLabel.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(imageLabel);
    }

    public Window(String fileName, int width, int height, int x, int y, double scaleFactor) {

        this.imageLabel = new JLabel();
        this.imageIcon = new ImageIcon(fileName);
        this.imageLabel.setIcon(imageIcon);

        this.setBounds(x, y, width, height);
        this.setBorder(BorderFactory.createLineBorder(Colors.YELLOW.color, 3, true));

        this.setBackground(Colors.BLUE.color);

        this.add(imageLabel);

        if (isGif(imageIcon)) this.imageIcon = scaleGifIcon(this.imageIcon, scaleFactor);
        else this.imageIcon = scaleImageIcon(this.imageIcon, scaleFactor);
    }

    private ImageIcon scaleImageIcon(ImageIcon originalIcon, double scaleFactor) {
        Image originalImage = originalIcon.getImage();

        int newWidth = (int) (originalImage.getWidth(null) * scaleFactor);
        int newHeight = (int) (originalImage.getHeight(null) * scaleFactor);

        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, SCALE_SMOOTH);

        return new ImageIcon(scaledImage);
    }

    private ImageIcon scaleGifIcon(ImageIcon originalIcon, double scaleFactor) {
        try {
            Image image = originalIcon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), TYPE_INT_ARGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();

            BufferedImage scaledImage = new BufferedImage((int) (this.imageIcon.getIconWidth() * scaleFactor), (int) (this.imageIcon.getIconWidth() * scaleFactor), TYPE_INT_ARGB);
            Graphics2D g = scaledImage.createGraphics();
            g.drawImage(bufferedImage, 0, 0, (int) (this.imageIcon.getIconWidth() * scaleFactor), (int) (this.imageIcon.getIconWidth() * scaleFactor), null);
            g.dispose();

            // Save scaled image frames to a new GIF
            File outputfile = new File("scaled.gif");
            ImageIO.write(scaledImage, "gif", outputfile);

            return new ImageIcon(outputfile.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean isGif(ImageIcon icon) {
        String filename = icon.getDescription();
        return filename != null && filename.toLowerCase().endsWith(".gif");
    }
}
