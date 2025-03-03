package src.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;


public class MenuPanel extends JPanel {

    KeyHandler keyH = new KeyHandler();
    Sound sound = new Sound();

    public MenuPanel() {

        this.setLayout(null);
        
        // setup background gif
        JLabel backgroundLabel = new JLabel();
        ImageIcon backgroundGif;

        backgroundGif = new ImageIcon(getClass().getResource("/src/res/ui/background_gif3.gif"));
        backgroundLabel.setIcon(backgroundGif);
        backgroundLabel.setBounds(0, 0, backgroundGif.getIconWidth(), backgroundGif.getIconHeight());

        final int background_width = backgroundGif.getIconWidth();
        final int background_height = backgroundGif.getIconHeight();

        // setup button holder
        JLabel buttonHolder = new JLabel();
        buttonHolder.setBounds(background_width / 4, 0, background_width / 2, background_height);
        buttonHolder.setOpaque(false); // determines if its visible
        buttonHolder.setBackground(Color.BLUE);
        //System.out.println("width " + buttonHolder.getWidth());
        //System.out.println("height " + buttonHolder.getHeight());
        
        // setup start button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(50, 350, 253, 50); // centered horizontally
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(true);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setForeground(new Color(1,50,150)); // set start button to the blue from the title
        startButton.setBorderPainted(false); // removes the border
        startButton.setBorder(new LineBorder(new Color(1,50,250), 3));


        // setup exit button
        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(50, 410, 253, 50); // centered horizontally
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(true);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setForeground(new Color(1,50,150)); // set exit button to the blue from the title
        exitButton.setBorderPainted(false);
        exitButton.setBorder(new LineBorder(new Color(1,50,250), 3));

        // add hover events for mouse entering buttons
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setForeground(new Color(4, 50, 200)); 
                startButton.setBorderPainted(true);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setForeground(new Color(1,50,150)); 
                startButton.setBorderPainted(false);
            }
        });

        // add events for mouse leaving buttons
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setForeground(new Color(4, 50, 200)); 
                exitButton.setBorderPainted(true);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setForeground(new Color(1,50,150)); 
                exitButton.setBorderPainted(false);
            }
        });

        // add action listener to handle button clicks
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                Main.startGame(); // close the menu panel and open up the game panel
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.exitGame();
            }
        });

        // add start button to button holder
        buttonHolder.add(startButton);
        // add exit button to button holder
        buttonHolder.add(exitButton);
        
        // add background gif
        this.add(backgroundLabel);
        // add button holder
        this.add(buttonHolder);
        
        // setup menu panel
        this.setPreferredSize(new Dimension(background_width, background_height)); 
        this.setBackground(Color.BLACK); 
        this.setDoubleBuffered(true);
        this.setComponentZOrder(buttonHolder, 0);   // force correct Z-order: move `buttonHolder` above `backgroundLabel`
        this.setFocusable(true);

        playMusic(1);   // play title card music
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE); 
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("sunday", GamePanel.screenWidth / 2, GamePanel.screenHeight / 2); 
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }
}
