package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273

/*
 * Producers will create energy
 * Producers will not have a move method but can still reproduce
 */
public abstract class Producer extends Creature {
	private int growSpeed; //The amount of energy gained each cycle of growth
	private BufferedImage sprite;
	
	public Producer(int x, int y, int width, int height, int energy, int reproduceVal, int growSpeed, int strength, BufferedImage sprite) {
		super(x, y, width, height, energy, reproduceVal, strength);
		this.growSpeed = growSpeed;
		this.sprite = sprite;
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
<<<<<<< HEAD
	public abstract void draw(Graphics g);
	public abstract void update();
=======
	@Override
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}
	
	@Override
	public void update(ArrayList<Creature> main)
	{
		if (energy <= 0)
			delete = true;
		else
		{
			energy += growSpeed;
			if (energy >= reproduceVal)
			{
				incubating = true;
			}
		}
	}
	
	
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
}