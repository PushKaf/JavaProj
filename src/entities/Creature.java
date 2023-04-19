package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import gamestate.Started;

public class Creature extends Entity {
	protected int energy; //Current energy of the creature, used for various functions
	protected boolean incubating; //if Creature is incubating creature (we want to change the main arrayList after updates are finished)
	protected int reproduceVal;	//Value of energy needed to reproduce
	protected BufferedImage sprite;	//the Image of Creature
	
	public Creature() {
		super();
		energy = 0;
		incubating = false;
		reproduceVal = 10000;
		delete = true;
	}
	
	public Creature(int x, int y, int width, int height, int energy, int reproduceVal, int strength, BufferedImage sprite) {
		super(x, y, width, height, strength);
		this.energy = energy;
		this.reproduceVal  = reproduceVal;
		incubating = false;
		this.sprite = sprite;
	}
	
	public void update(ArrayList<Creature> main) {
		//meant to be overriden
	}
	
	public void draw(Graphics g) {
		//meant to be overriden, there a better way to do this?
	}
	
	//All will overide, this should be abstract... but 
	public void spawnCreature(int x, int y) {
		Started.main.add(this);
	}
	
	//Accessors and Mutators
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
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
	public BufferedImage getSprite() {
		return sprite;
	}

}