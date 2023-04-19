
package entities;

import java.awt.image.BufferedImage;
import gamestate.Started;
import utils.DataLoader;

/*
 * A dog is a consumer with a set values
 * essentially a consumer with specific values and a sprite
 */
public class Turtle extends Consumer {
	
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.TURTLE_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 499;
	public static int REPRODUCEVAL = 500;
	public static int STRENGTH = 2;
	public static int SPEED = 30;
	
	public Turtle(int x, int y) { //Only position is unique to each Dog
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, STRENGTH, SPEED, SPRITE);
		
	}
	
	public void spawnCreature(int x, int y) {
		Started.main.add(new Turtle(x, y));
	}
}
