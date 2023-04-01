package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 */
public class Dog extends Consumer {
	
	private BufferedImage sprite;
//	
//	private int hitBoxWidth;
//	private int hitBoxHeight;
//	private int viewBoxWidth;
//	private int viewBoxHeight;
	
	
	public Dog(int x, int y) { //Only position is unique to each Dog
		super(x, y, 128, 64, 10, 20, 1, 10);
		sprite = DataLoader.GetSpriteData(DataLoader.DOG_ATLAS);
		
		
		
	}
	
	public void update() {
//		getViewBox().intersects()
		
//		if(getViewBox().intersects()) {
//			System.out.println("OPPPOPOPOPOPOPO");
//		}
		
		
		
//		System.out.println("L");
		
		
		
		//Dog Logic
//		updateBoxes(x, y);
	}
	
	// Draw the sprite on screen with x and y so we can later change positions
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	//Key inputs
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: {
				this.y -= getSpeed();
				break;
			}
			case KeyEvent.VK_S: {
				this.y += getSpeed();
				break;
			}		
			case KeyEvent.VK_D: {
				this.x += getSpeed();
				break;
			}		
			case KeyEvent.VK_A: {
				this.x -= getSpeed();
				break;
			}
		}
		
		updateBoxes(x, y);
	}
	
//	private void initBoxes() {
//		hitBoxWidth = sprite.getWidth();
//		hitBoxHeight = sprite.getHeight();
//	}
}
