package entities;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import main.GamePanel;
import utils.Constants;
import utils.Constants.UI;

/*
 * Consumers cannot produce their own energy
 * Consumers eat other creatures and can move
 * Put update, most of important info in here
 */
public class Consumer extends Creature {
	protected int speed;
	//Past is to show what last direction of movement was
	private int past = -1;

	public Consumer(int x, int y, int width, int height, int energy, int reproduceVal, int strength, int speed,
			BufferedImage sprite) {
		super(x, y, width, height, energy, reproduceVal, strength, sprite);
		this.speed = speed;
	}

	// Accessors and Mutators
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	// All consumers will need a draw and update method
	@Override
	public void draw(Graphics g) {
		drawViewBox(g);
		drawHitBox(g);
		g.drawImage(sprite, x, y, 128, 64, null);
	}

	@Override
	public void update(ArrayList<Creature> main) {
		//death and reproduction
		if (energy <= 0)
			delete = true;
		else {
			sense(main);
			energy -= 1;
			if (energy >= reproduceVal) {
				incubating = true;
			}
		}
		
		//wrapping around the screen
		if (x > GamePanel.getWidthO())
			x = 0;
		if (y > GamePanel.getHeightO())
			y = 0;
		if (x < 0)
			x = GamePanel.getWidthO();
		if (y < 0)
			y = GamePanel.getHeightO();
	}

	private void sense(ArrayList<Creature> main) {
		Creature hold = new Creature();
		for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
			//kill, harm, or ignore when hunting
			if (viewBox.intersects(e.hitBox)) {
				if (((strength + 2 == e.strength) || (strength + 1 == e.strength)) && (e.strength < hold.strength)) {
					hold = e;
				}
			}
			//clearing any null leftovers since that's apparently a problem somehow
			while (main.remove(null));
		}
		if (hold.delete())
			move();
		else {
			moveTarget(hold.getX(), hold.getY());
			interaction(hold);
		}

	}

	private void interaction(Creature e) {
		//When hurt/killed, energy is stolen like a leech
		if (e.hitBox.intersects(hitBox)) {
			if (strength == e.strength + 2) {
				e.delete = true;
				e.setEnergy(0);
				setEnergy(e.getEnergy() / 2 + getEnergy());
			} else if (strength == e.strength + 1) {
				e.setEnergy(e.getEnergy() / 2 - 30);
				setEnergy(e.getEnergy() / 4 + getEnergy());
			}
		}
	}

	public void move() {
		//3/4 chance of moving in the same direction, and then a random chance of any direction
		int z = (int) (Math.random() * 20);
		if (past == -1) {
			z = (int) (Math.random() * 4);
			moveHelper(z);
			past = z;
		} else if (z < 4) {
			moveHelper(z);
			past = z;
		} else {
			moveHelper(past);
		}
		updateBoxes(x, y, (int) this.getViewBox().getWidth() / 2, (int) this.getViewBox().getHeight() / 2);
	}

	private void moveHelper(int past)
	{
		if (past == 0)
			x += speed;
		else if (past == 1)
			x -= speed;
		else if (past == 2)
			y += speed;
		else if (past == 3)
			y -= speed;
	}
	
	protected void moveTarget(int otherX, int otherY) {
		double x1 = (otherX - x) / Math.pow((Math.pow((otherX - x), 2) + Math.pow((otherY - y), 2)), 0.5);
		double y1 = (otherY - y) / Math.pow((Math.pow((otherX - x), 2) + Math.pow((otherY - y), 2)), 0.5);
		x += (x1) * speed;
		y += (y1) * speed;
		updateBoxes(x, y, (int) this.getViewBox().getWidth() / 2, (int) this.getViewBox().getHeight() / 2);
	}
}