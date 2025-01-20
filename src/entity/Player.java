package src.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp,  KeyHandler keyH) {
            this.gp = gp;
            this.keyH = keyH;

            setDefaultValues();
            getPlayerImage();
    }
    public void setDefaultValues() { // default player spawn position
        x = 360;
        y = 312;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            // Load each image using FileInputStream and absolute file paths
            up1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/src/res/player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public void update() { // called 60 times per second
        if (keyH.upPressed == true || keyH.downPressed == true 
        || keyH.rightPressed == true || keyH.leftPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
        
                System.out.println("Up pressed: playerY = " + x + " " + y);
            }
            if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
        
                System.out.println("Down pressed: playerY = " + x + " " + y);
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                x += speed;
        
                System.out.println("Right pressed: playerX = " + x + " " + y);
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                x -= speed;
        
                System.out.println("Left pressed: playerX = " + x + " " + y);
            }
        
            // Used to create walking animation
            spriteCounter++;
            if (spriteCounter > 5) { // change this to make faster or slower
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
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
                if(spriteNumber == 1) {
                    image = up1;
                }
                if(spriteNumber == 2) {
                    image = up2;
                } 
                break;
            case "down":
                if(spriteNumber == 1) {
                    image = down1; 
                }
                if(spriteNumber == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber == 1) {
                    image = left1;
                }
                if(spriteNumber == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1) {
                    image = right1; 
                }
                if(spriteNumber == 2) {
                    image = right2;
                }
                break;
            default:
                image = down1; 
                break;
        }
        
        // Draw the image at the player's position
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, gp); 
    }
}
