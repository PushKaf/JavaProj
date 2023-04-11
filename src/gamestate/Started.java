package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.Creature;
import entities.Dog;
import entities.Tree;
import main.GamePanel;
import ui.Inventory;
import utils.DataLoader;

/**
 * 	State where the simulation has started
 */
public class Started {
	
	private BufferedImage backgroundImg;
	private Dog dog;
	private Tree tree;
	private GamePanel gamePanel;
	private Inventory inventory;
	
	public static ArrayList<Creature> creatures = new ArrayList<Creature>();
	
	public Started(GamePanel gamePanel) {
		
		//Get the image using our utils DataLoader
		
		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
		
		dog = new Dog(100, 100);
		tree = new Tree(100, 1000);
		
		creatures.add(new Tree(0, 10));
		creatures.add(new Dog(1000, 100));
		
		inventory = new Inventory(gamePanel);
	}
	
	
	//Once we have buttons you can click, we'll call the update here
	public void update() {
		for(Creature c : creatures) {
			c.update();
		}
		
	}
	
	//Drawing the background
	public void draw(Graphics g) {
		//Specifying image, (0,0) upper left start pos, (1280x720) size of window, null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
		inventory.draw(g);
		
		for(Creature c : creatures) {
			c.draw(g);
		}
	}
	
	//
	public void keyPressed(KeyEvent e) {
		dog.keyPressed(e);
	}
}
