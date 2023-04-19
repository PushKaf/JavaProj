
package entities;

import java.awt.image.BufferedImage;
import gamestate.Started;
import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 * essentially a consumer with specific values and a sprite
 */
public class Dog extends Consumer {
	
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.DOG_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 200;
	public static int REPRODUCEVAL = 400;
	public static int STRENGTH = 4;
	public static int SPEED = 30;
	
	public Dog(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		//I set energy to 499 to maximize dog life without having it reproduce so it can only reproduce after it eats a tree
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, STRENGTH, SPEED, SPRITE);
		
	}
	
	public void spawnCreature(int x, int y) {
		Started.main.add(new Dog(x, y));
	}
	
//	//Key inputs
//	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()) {
//			case KeyEvent.VK_W: {
//				this.y -= getSpeed();
//				break;
//			}
//			case KeyEvent.VK_S: {
//				this.y += getSpeed();
//				break;
//			}		
//			case KeyEvent.VK_D: {
//				this.x += getSpeed();
//				break;
//			}		
//			case KeyEvent.VK_A: {
//				this.x -= getSpeed();
//				break;
//			}
//		}
//		
//		updateBoxes(x, y);
//	}
}
