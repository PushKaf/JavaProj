
package entities;

import java.awt.image.BufferedImage;
import gamestate.Started;
import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 * essentially a consumer with specific values and a sprite
 */
public class Mouse extends Consumer {
	
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.MOUSE_SPRITE);
	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	public static int ENERGY = 100;
	public static int REPRODUCEVAL = 100;
	public static int STRENGTH = 2;
	public static int SPEED = 20;
	
	public Mouse(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, STRENGTH, SPEED, SPRITE);
		
	}
	
	public void spawnCreature(int x, int y) {
		Started.main.add(new Mouse(x, y));
	}
	
}
