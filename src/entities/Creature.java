package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

abstract class Creature extends Entity {
	private int energy; //Current energy of the creature, used for various functions
	private int reproduceVal; //The energy value needed to be exceeded to create another creature object
	private int strength; //Determines the creature's placement on the food chain
	private boolean isDead = false;
	
	public Creature() {
		super();
		energy = 10;
		reproduceVal = 20;
		strength = 1;
	}
	
	public Creature(int x, int y, int energy, int reproduceVal, int strength) {
		super(x, y);
		this.energy = energy;
		this.reproduceVal = reproduceVal;
	}
	
	//All creatures will need a draw and update method
	abstract void draw(Graphics g);
	abstract void update();
	
	//Accessors and Mutators
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getReproduceVal() {
		return reproduceVal;
	}
	public void setReproduceVal(int reproduceVal) {
		this.reproduceVal = reproduceVal;
	}
	public int getStrength() {
		return strength;
	}
	public void setStregnth(int strength) {
		this.strength = strength;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
}