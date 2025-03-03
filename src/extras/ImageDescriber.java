package src.extras;

import javax.swing.ImageIcon;

public class ImageDescriber {
    public static void main(String[] args) {

        ImageDescriber describer = new ImageDescriber();
        ImageIcon img = new ImageIcon(describer.getClass().getResource("/src/res/misc/background_gif2.gif"));

        System.out.println("Width:" + img.getIconWidth());
        System.out.println("Height:" + img.getIconHeight());
    }
}
