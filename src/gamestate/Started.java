<<<<<<< HEAD
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
