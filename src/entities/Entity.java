
package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

//changed entity to abstract because we still need some kind of abstract class and entity seems unlikely to be declared
//draw and update are the abstract classes
abstract class Entity {
	protected int x, y, strength;
	protected Rectangle2D.Float hitBox;
	protected Rectangle2D.Float viewBox;
	
	protected boolean delete;
	private int width;
	private int height;
	
	public Entity() {
		x = 0;
		y = 0;
		strength = 1000;
		delete = true;
	}
	
	public boolean delete() {
		return delete;
	}
	public int getStrength() {
		return strength;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Entity(int x, int y, int width, int height, int strength) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.strength = strength;
		
		hitBox = new Rectangle2D.Float(x, y, width, height);
		viewBox = new Rectangle2D.Float(x - width/2, y - height/2, width*2, height*2);
	}
	
	protected void drawHitBox(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)hitBox.x, (int)hitBox.y, width, height);
	}
	
	protected void drawViewBox(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int)viewBox.x, (int)viewBox.y, (int)(viewBox.width), (int)(viewBox.height));
	}
	
	abstract void update(ArrayList<Creature> main);
	abstract void draw(Graphics g);
	
	protected void updateBoxes(int x, int y, int width, int height) {
		hitBox.x = x;
		hitBox.y = y;
		
		viewBox.x = x - width/2;
		viewBox.y = y - height/2;
	}

	public Rectangle2D.Float getHitBox() {
		return hitBox;
	}

	public Rectangle2D.Float getViewBox() {
		return viewBox;
	}
}