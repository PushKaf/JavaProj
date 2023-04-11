package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

<<<<<<< HEAD
public abstract class Creature extends Entity {
	protected int energy; //Current energy of the creature, used for various functions
	protected boolean incubating; //if Creature is incubating creature (we want to change the main arrayList after updates are finished)
	protected int reproduceVal;	//Value of energy needed to reproduce
=======
abstract class Creature extends Entity {
	private int energy; //Current energy of the creature, used for various functions
	private int reproduceVal; //The energy value needed to be exceeded to create another creature object
	private int strength; //Determines the creature's placement on the food chain
	private boolean isDead = false;
>>>>>>> parent of 99162c8 (Added Inventory)
	
	public Creature() {
		super();
		energy = 0;
		incubating = false;
		reproduceVal = 10000;
	}
	
	public Creature(int x, int y, int width, int height, int energy, int reproduceVal, int strength) {
		super(x, y, width, height, strength);
		this.energy = energy;
		this.reproduceVal  = reproduceVal;
		incubating = false;
	}
	
	//All creatures will need a draw and update method
	abstract void draw(Graphics g);
	abstract void update();
	
	//Accessors and Mutators
<<<<<<< HEAD
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	//Accessors and Mutators
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

=======
>>>>>>> parent of 99162c8 (Added Inventory)
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
	public boolean getIncubating() {
		return incubating;
	}
	public void setIncubating(boolean incubating) {
		this.incubating  = incubating ;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}

}