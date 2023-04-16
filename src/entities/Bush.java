package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utils.DataLoader;

/*
 * A tree is a producer with a set reproduce value and grow speed configuration
 * Reproduce value and grow speed will be consistent for all Trees
 */
public class Bush extends Producer {
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.TREE_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 500;
	public static int REPRODUCEVAL = 750;
	public static int GROWSPEED = 1;
	public static int STRENGTH = 1;
	
	
	public Bush(int x, int y) { //Only position is unique to each Tree
		//int x, int y, int width, int height, int energy, int reproduceVal, int growSpeed, int strength, picture
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, GROWSPEED, STRENGTH, SPRITE);
	}
}