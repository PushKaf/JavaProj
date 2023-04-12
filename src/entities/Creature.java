package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Creature extends Entity {
	private int energy; //Current energy of the creature, used for various functions
	private int reproduceVal; //The energy value needed to be exceeded to create another creature object
	private int strength; //Determines the creature's placement on the food chain
	private boolean isDead = false;
	
	protected BufferedImage sprite;
	public Creature() {
		super();
		energy = 10;
		reproduceVal = 20;
		strength = 1;
	}
	
	public Creature(int x, int y, int width, int height, int energy, int reproduceVal, int strength) {
		super(x, y, width, height);
		this.energy = energy;
		this.reproduceVal = reproduceVal;
	}
	
	public void update(ArrayList<Creature> main)
	{
		//meant to be overriden
	}
	public void draw(Graphics g)
	{
		//meant to be overriden, there a better way to do this?
	}

	
	//Accessors and Mutators
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
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