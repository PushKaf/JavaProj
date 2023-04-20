package gamestate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Bush;
import entities.Creature;
import entities.Crow;
import entities.Deer;
import entities.Dog;
import entities.Dragon;
import entities.Eagle;
import entities.Human;
import entities.Mouse;
import entities.Squirrel;
import entities.Tree;
import entities.Turkey;
import entities.Wolf;
import main.GamePanel;
import ui.Inventory;
import ui.TimeButtons;
import utils.DataLoader;

/**
 * 	State where the simulation has started
 */
public class Started {

	private BufferedImage backgroundImg;
	private GamePanel gamePanel;

	private Inventory inventory;
	private TimeButtons timeButtons;
	
	public static ArrayList<Creature> main = new ArrayList<Creature>();
	
	public Started(GamePanel gamePanel) {
		
		//Get the image using our utils DataLoader
		
		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
		
		inventory = new Inventory(gamePanel);
		timeButtons = new TimeButtons(gamePanel);
	}
	
	public void update() {
		
		//clears out dead creatures
	  	ArrayList<Creature> rep = new ArrayList<Creature>();
		rep = main;
		for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
		  	if (e.delete()) {
		  		rep.remove(e);		  		
		  	}
		}
		
		main = rep;
		
		for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
			
			if (e.getIncubating()) {
				
				e.setIncubating(false);
				Creature c = null;
				if (e instanceof Dog) {	//we're going to need to make one of these lines for each class? Better way to do this?
					c = new Dog(e.getX(), e.getY());
				}
				else if (e instanceof Crow) {	
					c = new Crow(e.getX(), e.getY());
				}
				else if (e instanceof Deer) {	
					c = new Deer(e.getX(), e.getY());
				}
				else if (e instanceof Dragon) {	
					c = new Dragon(e.getX(), e.getY());
				}
				else if (e instanceof Human) {	
					c = new Human(e.getX(), e.getY());
				}
				else if (e instanceof Mouse) {	
					c = new Mouse(e.getX(), e.getY());
				}
				else if (e instanceof Squirrel) {	
					c = new Squirrel(e.getX(), e.getY());
				}
				else if (e instanceof Turkey) {	
					c = new Turkey(e.getX(), e.getY());
				}
				else if (e instanceof Wolf) {	
					c = new Wolf(e.getX(), e.getY());
				}
				else if (e instanceof Eagle) {	
					c = new Eagle(e.getX(), e.getY());
				}
				else if (e instanceof Tree) {
					c = new Tree(e.getX() + (int)(Math.random()*Tree.WIDTH) - Tree.WIDTH/2 - 50, e.getY()+ (int)(Math.random()*Tree.HEIGHT) - Tree.HEIGHT/2 - 50);
				}
				else if (e instanceof Bush) {	//we're going to need to make one of these lines for each class? Better way to do this?
					c = new Bush(e.getX() + (int)(Math.random()*Tree.WIDTH) - Tree.WIDTH/2 - 50, e.getY()+ (int)(Math.random()*Tree.HEIGHT) - Tree.HEIGHT/2 - 50);
				}
				
				e.setEnergy(e.getReproduceVal()/2);// so creatures don't keep spitting out children
				main.add(c);
			}
		}
		
		for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
			e.update(main);
		}
	}
		
		//Drawing the background
	public void draw(Graphics g) {
		//Specifying image, (0,0) upper left start pos, (1280x720) size of window, null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
	  	
	  	for (int x = 0; x < main.size(); x++) {
			Creature e = main.get(x);
			e.draw(g);
		}
	}
}
