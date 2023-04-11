package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/*
 * Consumers cannot produce their own energy
 * Consumers eat other creatures and can move
 */
public abstract class Consumer extends Creature {
	private int speed;

	public Consumer(int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed) {
		super(x, y, width, height, energy, reproduceVal, strength);
		this.speed = speed;
	}
	
	
	//Accessors and Mutators
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//All consumers will need a draw and update method
	public abstract void draw(Graphics g);
	public abstract void update();
}