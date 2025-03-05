package src.main;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.buttons.ResumeButton;
import src.buttons.ExitButton;

public class GameMenu extends JPanel {

    final int background_width = GamePanel.screenWidth;
    final int background_height = GamePanel.screenHeight;
    
    KeyHandler keyH = new KeyHandler();

    public GameMenu() {

        this.setLayout(null);
   
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, background_width, background_height);

        // setup button holder
        JLabel buttonHolder = new JLabel();
        buttonHolder.setBounds(background_width / 4, 0, background_width / 2, background_height);
        buttonHolder.setOpaque(false); // determines if its visible
        buttonHolder.setBackground(Color.BLUE);
        
        // setup start button
        ResumeButton resumeButton = new ResumeButton("Resume", "1,50,150", false, 50, 410, 253, 50);
        // setup exit button
        ExitButton exitButton = new ExitButton("Exit Game", "1,50,150", false, 50, 500, 253, 50);

        // add start button to button holder
        buttonHolder.add(resumeButton);
        // add exit button to button holder
        buttonHolder.add(exitButton);
        
        // add background gif
        this.add(backgroundLabel);
        // add button holder
        this.add(buttonHolder);
        
        // setup menu panel
        this.setPreferredSize(new Dimension(background_width, background_height)); 
        this.setBackground(Color.BLACK); // set background color of the game menu
        this.setDoubleBuffered(true);
        this.setComponentZOrder(buttonHolder, 0);   // force correct Z-order: move `buttonHolder` above `backgroundLabel`
        this.setFocusable(true);

    }
}
