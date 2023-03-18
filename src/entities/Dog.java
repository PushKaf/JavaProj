package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import utils.DataLoader;


/** 
 * 	Basic Dog class which is an animal.
 */
public class Dog extends Animal{
	private BufferedImage sprite;
	private int speed = 10;
	
	public Dog() {
		x = 0;
		y = 0;

		sprite = DataLoader.GetSpriteData(DataLoader.DOG_ATLAS);
	}
	
	public void update() {
		//Dog Logic
		
	}
	
	// Draw the sprite on screen with x and y so we can later change positions
	public void draw(Graphics g) {
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	//Key inputs
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: {
				this.y -= speed;
				break;
			}
			case KeyEvent.VK_S: {
				this.y += speed;
				break;
			}		
			case KeyEvent.VK_D: {
				this.x += speed;
				break;
			}		
			case KeyEvent.VK_A: {
				this.x -= speed;
				break;
			}
		}
	}
}
