package entities;

import java.awt.Graphics;
<<<<<<< HEAD
import java.awt.image.BufferedImage;
<<<<<<< HEAD
=======
import java.util.ArrayList;

import utils.Constants;
import utils.Constants.UI;
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
=======
>>>>>>> parent of 99162c8 (Added Inventory)

/*
 * Consumers cannot produce their own energy
 * Consumers eat other creatures and can move
 * Put update, most of important info in here
 */
abstract class Consumer extends Creature {
	private int speed;
	
	public Consumer(int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed) {
public class Consumer extends Creature {
	private int speed;
	private BufferedImage sprite;
	
	public Consumer(int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed, BufferedImage sprite) {
		super(x, y, width, height, energy, reproduceVal, strength);
		this.speed = speed;
		this.sprite = sprite;
	}
	
	//Accessors and Mutators
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//All consumers will need a draw and update method
<<<<<<< HEAD
	public abstract void draw(Graphics g);
	public abstract void update();

	private void sense(ArrayList<Creature> main)
	{
		Creature hold = new Creature();
		for (Creature e: main)
		{
			if (!e.equals(this))
			{
				if (viewBox.intersects(e.hitBox))
				{
					if (e.getStrength() < strength && e.getStrength() < hold.getStrength())
					{
						hold = e;
					}
				}
			}
		}
		if (hold.delete()) move();
		else 
		{
			move(hold.getX(), hold.getY());
			interaction(hold);
		}
		

	}
	private void interaction(Creature e)
	{
		if (e.hitBox.intersects(hitBox))
		{
			if (e.strength > strength)
			{
				delete = true;
				e.setEnergy(e.getEnergy() + getEnergy());
			}
			else if (strength > e.strength)
			{
				e.delete = true;
				setEnergy(e.getEnergy() + getEnergy());
			}
		}
	}
	public void move()
	{
		int z = (int)(Math.random()*4);
		if (z == 0)
			x += speed;
		else if (z == 1)
			x -= speed;
		else if (z == 2)
			y += speed;
		else if (z ==3)
			y -= speed;
		updateBoxes(x, y, (int)this.getViewBox().getWidth()/2, (int)this.getViewBox().getHeight()/2);
	}
	protected void move(int otherX, int otherY)
	{
		double x1 = (otherX-x)/Math.pow((Math.pow((otherX-x), 2) + Math.pow((otherY-y), 2)), 0.5);
		double y1 = (otherY-y)/Math.pow((Math.pow((otherX-x), 2) + Math.pow((otherY-y), 2)), 0.5);
		x += (x1)*speed;
		y += (y1)*speed;
		updateBoxes(x, y, (int)this.getViewBox().getWidth()/2, (int)this.getViewBox().getHeight()/2);
	}
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
=======
	abstract void draw(Graphics g);
	abstract void update();
>>>>>>> parent of 99162c8 (Added Inventory)
}