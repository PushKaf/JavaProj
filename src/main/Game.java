package main;

import java.awt.Graphics;


/*
 *	Main class where all the components (Panel, Window, etc.) will be combined  
 *	to create the simulation. This will also house our UPS (updates per second - the tick)
 *	and FPS which runs in another thread so it dosen't affect gameplay. 
 */
public class Game {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;

	
	/**
	 * 	Brings everything together by initializing classes
	 * 	and starting the game loop
	 */
	public Game() {
		
		gamePanel = new GamePanel();
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		
	}

	
	/**
	 * 	Holds the updating logic for each component.
	 */
	public void update() {
		
		
	}
	

	/**
	 * 	Holds the drawing/rendering for each component.
	 */
	public void draw(Graphics g) {
		
		
	}

	
	/**
	 * 	Will initialize classes to de-clutter the code block in our constructor class. 
	 */
	private void initClasses() {
		
		
	}
	
}
