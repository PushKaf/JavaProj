package entities;

import java.awt.Graphics;

/*
 * Producers will create energy
 * Producers will not have a move method but can still reproduce
 */
abstract class Producer extends Creature {
	private int growSpeed; //The amount of energy gained each cycle of growth
	
	public Producer(int x, int y, int energy, int reproduceVal, int growSpeed, int strength) {
		super(x, y, energy, reproduceVal, strength);
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
	abstract void draw(Graphics g);
	abstract void update();
}