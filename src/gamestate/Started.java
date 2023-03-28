package gamestate;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.RepaintManager;

import entities.*;
import main.GamePanel;
import utils.Constants.UI;
import utils.DataLoader;
import java.util.*;

/**
 * 	State where the simulation has started
 */
public class Started<T extends Entity> {
	
	private BufferedImage backgroundImg;
	private Dog dog;
	private Tree tree;
	private GamePanel gamePanel;
	private ArrayList<T> ents;
	
	public Started(GamePanel gamePanel) {
		
		//Get the image using our utils DataLoader
		
		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
		dog = new Dog(0, 0);
		tree = new Tree(200, 200);
		
		ents = new ArrayList<T>();
	}
	
	
	//Once we have buttons you can click, we'll call the update here
	public void update() {
		
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
