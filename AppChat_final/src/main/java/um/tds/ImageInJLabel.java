package um.tds;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageInJLabel {
    public static void resizeImage(JLabel label, URL originalIcon) {
    	ImageIcon og = new ImageIcon(originalIcon);
        if (og.getIconWidth() > 0 && og.getIconHeight() > 0) {
            Image image = og.getImage();
            Image resizedImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(resizedImage));
        }
    }
}