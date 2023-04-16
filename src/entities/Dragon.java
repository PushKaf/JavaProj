
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
public class Dragon extends Consumer {
	
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.DRAGON_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 499;
	public static int REPRODUCEVAL = 500;
	public static int STRENGTH = 2;
	public static int SPEED = 30;
	
	public Dragon(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, STRENGTH, SPEED, SPRITE);
		
	}
	
}
