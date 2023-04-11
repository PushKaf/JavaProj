package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * Producers will create energy
 * Producers will not have a move method but can still reproduce
 */
public abstract class Producer extends Creature {
	private int growSpeed; //The amount of energy gained each cycle of growth
	
	public Producer(int x, int y, int width, int height, int energy, int reproduceVal, int growSpeed, int strength) {
		super(x, y, width, height, energy, reproduceVal, strength);
		this.growSpeed = growSpeed;
	}
	
	public void grow() {
		setEnergy(getEnergy() + growSpeed);
	}
	
	public int getGrowSpeed() {
		return growSpeed;
	}
	public void setGrowSpeed(int growSpeed) {
		this.growSpeed = growSpeed;
	}

	//All producers will need a draw and update method
	public abstract void draw(Graphics g);
	public abstract void update();
}