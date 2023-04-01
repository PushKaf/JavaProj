package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Entity {
	protected int x, y;
	protected Rectangle2D.Float hitBox;
	protected Rectangle2D.Float viewBox;
	
	private int width;
	private int height;
	
	public Entity() {
		x = 0;
		y = 0;
	}
	
	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		hitBox = new Rectangle2D.Float(x, y, width, height);
		viewBox = new Rectangle2D.Float(x, y, width*2, height*2);
	}
	
	protected void drawHitBox(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)hitBox.x, (int)hitBox.y, width, height);
	}
	
	protected void drawViewBox(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)viewBox.x, (int)viewBox.y, (int)(viewBox.width), (int)(viewBox.height));
	}
	
	protected void updateBoxes(int x, int y) {
		hitBox.x = x;
		hitBox.y = y;
		
		viewBox.x = x;
		viewBox.y = y;
	}

	public Rectangle2D.Float getHitBox() {
		return hitBox;
	}

	public Rectangle2D.Float getViewBox() {
		return viewBox;
	}
	
}