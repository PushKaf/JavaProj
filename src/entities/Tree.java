package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.DataLoader;

/*
 * A tree is a producer with a set reproduce value and grow speed configuration
 * Reproduce value and grow speed will be consistent for all Trees
 */
public class Tree extends Producer {
	private BufferedImage sprite;
	
	public Tree(int x, int y) { //Only position is unique to each Tree
		super(x, y, 128, 64, 10, 20, 2, 0); //Preset values for starting energy, reproduceVal, and growthSpeed
		
		sprite = DataLoader.GetSpriteData(DataLoader.TREE_SPRITE);
	}

	@Override
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}
}