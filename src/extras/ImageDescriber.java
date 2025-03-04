package src.extras;

import javax.swing.ImageIcon;

public class ImageDescriber {
    public static void main(String[] args) {

        ImageDescriber describer = new ImageDescriber();

        try {
            ImageIcon img = new ImageIcon(describer.getClass().getResource("/src/res/ui/background_gif2_scaled.gif"));
            System.out.println("Width:" + img.getIconWidth());
            System.out.println("Height:" + img.getIconHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }
}
