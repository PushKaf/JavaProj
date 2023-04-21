package entities;

import java.awt.image.BufferedImage;
import gamestate.Started;
import utils.DataLoader;

/*
 * A tree is a producer with a set reproduce value and grow speed configuration
 * Reproduce value and grow speed will be consistent for all Trees
 */
public class Tree extends Producer {
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.TREE_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 200;
	public static int REPRODUCEVAL = 300;
	public static int GROWSPEED = 1;
	public static int STRENGTH = 1;
	
	
	public Tree(int x, int y) { //Only position is unique to each Tree
		//int x, int y, int width, int height, int energy, int reproduceVal, int growSpeed, int strength, picture
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, GROWSPEED, STRENGTH, SPRITE);
	}
	
	public void spawnCreature(int x, int y) {
		Started.main.add(new Tree(x, y));
	}
}