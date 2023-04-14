package main;

import java.awt.Graphics;

import gamestate.Started;


/**
 *	Main class where all the components (Panel, Window, etc.) will be combined  
 *	to create the simulation. This will also house our UPS (updates per second - the tick)
 *	and FPS which runs in another thread so it dosen't affect gameplay. 
 *  
 *  Needs to be Runnable since we're using threads to separate the game loop and actual content.
 */
public class Game implements Runnable{
	private final double NANOSECOND_PER_SECOND = 1000000000.0;

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Started started;
	private Thread gameThread;
	
	private final int SET_FPS = 24;
	private final int SET_UPS = 24;
	private final boolean SHOW_STATS = true;
	
	/**
	 * 	Brings everything together by initializing classes
	 * 	and starting the game loop
	 */
	public Game() {
		initClasses();
		
		gamePanel.requestFocusInWindow();
		startLoop();
	}
	
	/**
	 * 	Holds the updating logic for each component.
	 */
	public void update() {
		started.update();
	}
	
	/**
	 * 	Holds the drawing/rendering for each component.
	 */
	public void draw(Graphics g) {
		started.draw(g);
	}

	/**
	 * 	Creates and starts a new thread with this class (must implement runnable)
	 */
	private void startLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	/**
	 * 	Will initialize classes to de-clutter the code block in our constructor class. 
	 */
	private void initClasses() {
		gamePanel = new GamePanel(this);
		started = new Started(gamePanel);
		gameWindow = new GameWindow(gamePanel);
	}

	/**
	 * 	Mandatory method when implementing "Runnable"
	 */
	@Override
	public void run() {
		//The amount of time per each individual update/frame
		//1 billion is used to convert seconds, to nanoseconds
		double timePerUpdate = NANOSECOND_PER_SECOND/SET_UPS;
		double timePerFrame = NANOSECOND_PER_SECOND/SET_FPS;
		
		long pTime = System.nanoTime();
		
		//Keep track of frames, updates, and our last checked time
		int frames = 0;
		int updates = 0;
		long lastChecked = System.currentTimeMillis();
		
		//Delta values for frame and update -- time elapsed since the last update
		double deltaF = 0;
		double deltaU = 0;
		
		//Actual "game loop"
		while(true) {
			long curTime = System.nanoTime();
			
			//Calculates and adds the number of timePerUpdate/Frame intervals that have passed
			deltaF += (curTime - pTime)/timePerUpdate;
			deltaU += (curTime - pTime)/timePerFrame;
			
			//set the previous time to the current time
			pTime = curTime;
			
			//If more than one interval has passed for any delta value, do the corresponding body
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			//Showing FPS and UPS
			if(SHOW_STATS) {				
				if(System.currentTimeMillis() - lastChecked == 1000) {
					
					//Update when we lastchecked and display info
					lastChecked = System.currentTimeMillis();
					System.out.printf("FPS: %d | UPS: %d %n", frames, updates);
					
					//Reset the values
					frames = 0;
					updates = 0;
				}
			}
		}
	}
	
	public Started getStarted() {
		return started;
	}
}