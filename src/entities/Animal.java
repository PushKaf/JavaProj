package entities;

import java.awt.Graphics;

/**
 * 	Abstract since we dont want "Animal" without definition.
 */
abstract class Animal extends Entity{
	private boolean isDead = false;
	private int strength; //The higher strength animal will eat the other in range.
	
	//All animals will need a draw and update class
	abstract void draw(Graphics g);
	abstract void update();
	
	public boolean isDead() {
		return isDead;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
}
