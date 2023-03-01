package main;


import java.awt.Graphics;
import java.util.ArrayList;

/*
 *	Main class where all the components (Panel, Window, etc.) will be combined  
 *	to create the simulation. This will also house our UPS (updates per second - the tick)
 *	and FPS which runs in another thread so it dosen't affect gameplay. 
 */
public class Game {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	private ArrayList<SUPERCLASS> creatures;
	private int timeDelay;
	private Graphics g;//I may be misunderstanding the graphics class

	/**
	 * Brings everything together by initializing classes and starting the game loop
	 */
	public Game() {

		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();

	}

	/**
	 * Holds the updating logic for each component.
	 */
	public void update() {
		//Before we implement the user choice I'm thinking we just arbitrarily add some creatures
		
		for (SUPERCLASS c: creatures)
		{
			c.SUPERMOVEMENTMETHOD(); //could be irrelevant based on creature (tree class would not move)
			c.SUPERCONSUMEMETHOD();
			c.SUPERDECAYMETHOD();
			c.SUPERREPRODUCEMETHOD();
		}
		
		draw(g);
		
		//we only need to delay every round of updates
		delay(timeDelay);
	}

	
	public void delay(int x)
	{
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	/**
	 * Holds the drawing/rendering for each component.
	 */
	public void draw(Graphics g) {
		//I'm assuming we're implementing drawable interface for graphics??
	    for (Drawable d : creatures){
	        d.ANIMATE(g);
	    }
	}

	/**
	 * Will initialize classes to de-clutter the code block in our constructor
	 * class.
	 */
	private void initClasses() {
		creatures = new ArrayList<SUPERCLASS>();
		timeDelay = 1000; //change as needed
		//Here is where we would set up the initial GUI with rocks, non-living, etc?
	}

}
