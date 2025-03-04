package src.buttons;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.main.Main;

public class ExitButton extends JButton {

    public ExitButton(String text, String rgbColor, boolean transparency, int x, int y, int width, int height) {

        // split the string into an array of strings
        String[] parts = rgbColor.split(",");

        // convert each part to an int
        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());

        Color color = new Color(r, g, b);
        
        this.setBounds(x, y, width, height); 
        this.setOpaque(!transparency);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
        this.setFont(new Font("Arial", Font.BOLD, 30)); // button font settings
        this.setForeground(color); // set exit button to the blue from the title
        this.setBorderPainted(false);
        this.setBorder(new LineBorder(new Color(1,50,113), 3));
        this.setText(text);
        this.setFocusable(false);


        // add events for mouse leaving buttons
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ExitButton.this.setForeground(new Color(4, 50, 200)); 
                //exitButton.setBorderPainted(true);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                ExitButton.this.setForeground(new Color(1,50,150)); 
                ExitButton.this.setBorderPainted(false);
            }
        });

        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.exitGame();
            }
        });

    }

}
