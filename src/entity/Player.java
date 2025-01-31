package src.entity;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp,  KeyHandler keyH) {
            this.gp = gp;
            this.keyH = keyH;
            screenX = gp.screenWidth/2 - gp.tileSize/2;
            screenY = gp.screenHeight/2 - gp.tileSize/2;

            setDefaultValues();
            getPlayerImage();
    }
    
    public void setDefaultValues() { // default player spawn position
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 23;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            // Walking down
            down1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_down/down_6.png"));

            // walking up
            up1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_up/up_6.png"));

            
            // walking right
            right1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_right/right_7.png"));

            // walking left
            left1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/new_player/walking_left/left_7.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() { // called 60 times per second
        if (keyH.upPressed == true || keyH.downPressed == true 
        || keyH.rightPressed == true || keyH.leftPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
                worldY -= speed;
        
            }
            if (keyH.downPressed == true) {
                direction = "down";
                worldY += speed;
        
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;
        
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                worldX -= speed;
        
            }
        
            // Used to create walking animation
            spriteCounter++;
            if (spriteCounter > 5) { // Change this to make it faster or slower
                spriteNumber++;
                if (spriteNumber > 7) { // Cycle back to 1 after 7
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
        
    }

    public void draw(Graphics g2) {
        BufferedImage image = null;
        
        switch(direction) {
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                if (spriteNumber == 2) {
                    image = up2;
                }
                if (spriteNumber == 3) {
                    image = up3;
                }
                if (spriteNumber == 4) {
                    image = up4;
                }
                if (spriteNumber == 5) {
                    image = up5;
                }
                if (spriteNumber >= 6) {
                    image = up6;
                }
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = down1; 
                }
                if(spriteNumber == 2) {
                    image = down2;
                }
                if(spriteNumber == 3) {
                    image = down3; 
                }
                if(spriteNumber == 4) {
                    image = down4;
                }
                if(spriteNumber == 5) {
                    image = down5; 
                }
                if(spriteNumber >= 6) {
                    image = down6;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                if (spriteNumber == 2) {
                    image = left2;
                }
                if (spriteNumber == 3) {
                    image = left3;
                }
                if (spriteNumber == 4) {
                    image = left4;
                }
                if (spriteNumber == 5) {
                    image = left5;
                }
                if (spriteNumber == 6) {
                    image = left6;
                }
                if (spriteNumber == 7) {
                    image = left7;
                }
                break;
            case "right":
                if(spriteNumber == 1) {
                    image = right1; 
                }
                if(spriteNumber == 2) {
                    image = right2;
                }
                if(spriteNumber == 3) {
                    image = right3; 
                }
                if(spriteNumber == 4) {
                    image = right4;
                }
                if(spriteNumber == 5) {
                    image = right5; 
                }
                if(spriteNumber == 6) {
                    image = right6;
                }
                if(spriteNumber == 7) {
                    image = right7; 
                }
                break;
            default:
                image = down1; 
                break;
        }
        
        // Draw the image at the player's position
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, gp); 
    }
}
