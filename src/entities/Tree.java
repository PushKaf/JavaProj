package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import utils.DataLoader;

/*
 * A tree is a producer with a set reproduce value and grow speed configuration
 * Reproduce value and grow speed will be consistent for all Trees
 */
public class Tree extends Producer {
<<<<<<< HEAD
=======
	public static BufferedImage SPRITE = DataLoader.GetSpriteData(DataLoader.TREE_SPRITE);
	public static int WIDTH = 128;
	public static int HEIGHT = 64;
	public static int ENERGY = 500;
	public static int REPRODUCEVAL = 1000;
	public static int GROWSPEED = 1;
	public static int STRENGTH = 1;
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
	
	
	public Tree(int x, int y) { //Only position is unique to each Tree
		//int x, int y, int width, int height, int energy, int reproduceVal, int growSpeed, int strength, picture
		super(x, y, WIDTH, HEIGHT, ENERGY, REPRODUCEVAL, GROWSPEED, STRENGTH, SPRITE);
	}

<<<<<<< HEAD
	@Override
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
=======
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
}