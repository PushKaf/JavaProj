
package entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 * essentially a consumer with specific values and a sprite
 */
public class Dog extends Consumer {
	
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.DOG_ATLAS);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 499;
	public static int REPRODUCEVAL = 500;
	public static int STRENGTH = 2;
	public static int SPEED = 10;
	
	public Dog(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		//I set energy to 499 to maximize dog life without having it reproduce so it can only reproduce after it eats a tree
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, STRENGTH, SPEED, SPRITE);
		
	}


	public Dog(int x, int y) { //Only position is unique to each Dog
		super(x, y, 128, 64, 10, 20, 1, 10);
		sprite = DataLoader.GetSpriteData(DataLoader.DOG_ATLAS);
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
