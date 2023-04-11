<<<<<<< HEAD
package gamestate;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.RepaintManager;

import entities.*;
import main.GamePanel;
<<<<<<< HEAD
<<<<<<< HEAD
import ui.Inventory;
=======
import utils.Constants;
import utils.Constants.UI;
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
=======
import utils.Constants.UI;
>>>>>>> parent of 99162c8 (Added Inventory)
import utils.DataLoader;

/**
 * State where the simulation has started
 */
public class Started {

	private BufferedImage backgroundImg;
	private Dog dog;
	private Tree tree;
	private GamePanel gamePanel;
<<<<<<< HEAD
<<<<<<< HEAD
	private Inventory inventory;
	
	public static ArrayList<Creature> creatures = new ArrayList<Creature>();
=======
>>>>>>> parent of 99162c8 (Added Inventory)
	
=======
	private ArrayList<Creature> main;

>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
	public Started(GamePanel gamePanel) {

		// Get the image using our utils DataLoader

		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
<<<<<<< HEAD
<<<<<<< HEAD
		
		dog = new Dog(100, 100);
		tree = new Tree(100, 1000);
		
		creatures.add(new Tree(0, 10));
		creatures.add(new Dog(1000, 100));
		
		inventory = new Inventory(gamePanel);
=======
		dog = new Dog(10, 10);
		tree = new Tree(200, 200);
		main = new ArrayList<>();
		main.add(dog);
		main.add(tree);
		main.add(new Tree(300, 300));
		main.add(new Tree(400, 400));
		main.add(new Tree(500, 300));
		main.add(new Tree(600, 200));
		main.add(new Tree(700, 300));
		main.add(new Tree(800, 400));
		main.add(new Tree(900, 300));
		// these are test trees to check if the dog actually does "pathfinding"
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
=======
		dog = new Dog(10, 10);
		tree = new Tree(200, 200);
>>>>>>> parent of 99162c8 (Added Inventory)
	}

	public void update() {
<<<<<<< HEAD
<<<<<<< HEAD
		for(Creature c : creatures) {
			c.update();
		}
		
=======
		for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
			if (e.delete())
				main.remove(e);
			if (e.getIncubating()) {
				e.setIncubating(false);
				Creature c = null;
				if (e instanceof Dog) {	//we're going to need to make one of these lines for each class? Better way to do this?
					c = new Dog(e.getX(), e.getY());
				}
				if (e instanceof Tree) {	//we're going to need to make one of these lines for each class? Better way to do this?
					c = new Tree(e.getX() + (int)(Math.random()*Tree.WIDTH) - Tree.WIDTH/2 - 50, e.getY()+ (int)(Math.random()*Tree.HEIGHT) - Tree.HEIGHT/2);
				}
				e.setEnergy(e.getReproduceVal()/2 -100);// so creatures don't keep spitting out children

				main.add(c);
			}
		}
		for (Creature e : main) {
			e.update(main);
		}
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
=======
		dog.update();
>>>>>>> parent of 99162c8 (Added Inventory)
	}

	// Drawing the background
	public void draw(Graphics g) {
		// Specifying image, (0,0) upper left start pos, (1280x720) size of window,
		// null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
<<<<<<< HEAD
<<<<<<< HEAD
		inventory.draw(g);
		
		for(Creature c : creatures) {
			c.draw(g);
=======
		for (Creature e : main) {
			e.draw(g);
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
		}
=======
		dog.draw(g);
		tree.draw(g);
>>>>>>> parent of 99162c8 (Added Inventory)
	}

	public void keyPressed(KeyEvent e) {
		//dog.keyPressed(e);
	}
}
=======
package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.RepaintManager;

import entities.*;
import main.GamePanel;
import utils.Constants.UI;
import utils.DataLoader;

/**
 * 	State where the simulation has started
 */
public class Started {
	
	private BufferedImage backgroundImg;
	private Dog dog;
	private Tree tree;
	private GamePanel gamePanel;
	
	public Started(GamePanel gamePanel) {
		
		//Get the image using our utils DataLoader
		
		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
		dog = new Dog(10, 10);
		tree = new Tree(200, 200);
	}
	
	
	//Once we have buttons you can click, we'll call the update here
	public void update() {
		dog.update();
	}
	
	//Drawing the background
	public void draw(Graphics g) {
		//Specifying image, (0,0) upper left start pos, (1280x720) size of window, null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
		dog.draw(g);
		tree.draw(g);
	}
	
	//
	public void keyPressed(KeyEvent e) {
		dog.keyPressed(e);
	}
}
>>>>>>> 7f0cfcc3aa3d4a5a024f052d349fa511ab2fda0f
