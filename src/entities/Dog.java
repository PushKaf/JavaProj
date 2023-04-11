
package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 * essentially a consumer with specific values and a sprite
 */
public class Dog extends Consumer {
	
	private static BufferedImage sprite = DataLoader.GetSpriteData(DataLoader.DOG_ATLAS);
//	
//	private int hitBoxWidth;
//	private int hitBoxHeight;
//	private int viewBoxWidth;
//	private int viewBoxHeight;
	
	
	public Dog(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		//I set energy to 499 to maximize dog life without having it reproduce so it can only reproduce after it eats a tree
		super(x, y, 128, 64, 499, 500, 1, 10, sprite);
		
	}
	
	public Dog reproduce(int x, int y)
	{
		return (new Dog (x, y));
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
