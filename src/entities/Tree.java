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
	private static BufferedImage sprite = DataLoader.GetSpriteData(DataLoader.TREE_SPRITE);
	
	public Tree(int x, int y) { //Only position is unique to each Tree
		//int x, int y, int width, int height, int energy, int reproduceVal, int strength
		super(x, y, 128, 64, 10, 499, 500, 0, sprite); //Preset values for starting energy, reproduceVal, and growthSpeed
			}

	@Override
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	@Override
	public void update(ArrayList<Creature> main) {
		energy++;
	}

//	@Override
//	void update() {
//		// TODO Auto-generated method stub
//		
//	}
}