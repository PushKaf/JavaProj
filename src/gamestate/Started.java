package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.*;
import main.GamePanel;
import ui.Inventory;
import utils.DataLoader;

/**
 * 	State where the simulation has started
 */
public class Started {

	private BufferedImage backgroundImg;
	private GamePanel gamePanel;

	private Inventory inventory;
	
	public static ArrayList<Creature> main = new ArrayList<Creature>();
	
	public Started(GamePanel gamePanel) {
		
		//Get the image using our utils DataLoader
		
		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
		
		main.add(new Tree(500, 200));
		main.add(new Bush(200, 500));
		main.add(new Dog(1000, 100));
		main.add(new Deer(1000, 100));
		main.add(new Dragon(1000, 100));
		main.add(new Human(1000, 100));
		main.add(new Mouse(1000, 100));
		main.add(new Turtle(1000, 100));
		main.add(new Squirrel(1000, 100));
		main.add(new Crow(1000, 100));
		
		
		inventory = new Inventory(gamePanel);
	}
	
	
  public void update() {
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
				else if (e instanceof Turtle) {	
					c = new Turtle(e.getX(), e.getY());
				}
				else if (e instanceof Tree) {
					c = new Tree(e.getX() + (int)(Math.random()*Tree.WIDTH) - Tree.WIDTH/2 - 50, e.getY()+ (int)(Math.random()*Tree.HEIGHT) - Tree.HEIGHT/2);
				}
				else if (e instanceof Bush) {	//we're going to need to make one of these lines for each class? Better way to do this?
					c = new Bush(e.getX() + (int)(Math.random()*Tree.WIDTH) - Tree.WIDTH/2 - 50, e.getY()+ (int)(Math.random()*Tree.HEIGHT) - Tree.HEIGHT/2);
				}
				
				e.setEnergy(e.getReproduceVal()/2 -100);// so creatures don't keep spitting out children

				main.add(c);
			}
		}
		for (Creature e : main) {
			if (!e.delete()) e.update(main);
		}
	}
	
	//Drawing the background
	public void draw(Graphics g) {
		//Specifying image, (0,0) upper left start pos, (1280x720) size of window, null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
		inventory.draw(g);
		
		for (Creature e : main) {
			if (!e.delete()) e.draw(g);
		}
	}
	
	//
	public void keyPressed(KeyEvent e) {
//		dog.keyPressed(e);
	}
}
