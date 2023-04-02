package gamestate;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.RepaintManager;

import entities.*;
import main.GamePanel;
import utils.Constants;
import utils.Constants.UI;
import utils.DataLoader;

/**
 * State where the simulation has started
 */
public class Started {

	private BufferedImage backgroundImg;
	private Dog dog;
	private Tree tree;
	private GamePanel gamePanel;
	private ArrayList<Creature> main;

	public Started(GamePanel gamePanel) {

		// Get the image using our utils DataLoader

		this.gamePanel = gamePanel;
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
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
				e.setEnergy(e.getReproduceVal() - 100);// so creatures don't keep spitting out children
				main.add(c);
			}
		}
		for (Creature e : main) {
			e.update(main);
		}
	}

	// Drawing the background
	public void draw(Graphics g) {
		// Specifying image, (0,0) upper left start pos, (1280x720) size of window,
		// null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, gamePanel.getWidth(), gamePanel.getHeight(), null);
		for (Creature e : main) {
			e.draw(g);
		}
	}

	//
	public void keyPressed(KeyEvent e) {
		dog.keyPressed(e);
	}
}
