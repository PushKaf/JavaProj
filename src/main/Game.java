package main;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gamestate.Started;
import utils.DataLoader;
import utils.Toast;


/**
 *	Main class where all the components (Panel, Window, etc.) will be combined  
 *	to create the simulation. This will also house our UPS (updates per second - the tick)
 *	and FPS which runs in another thread so it dosen't affect gameplay. 
 *  
 *  Needs to be Runnable since we're using threads to separate the game loop and actual content.
 */
public class Game implements Runnable{
	private static final double NANOSECOND_PER_SECOND = 1000000000.0;

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Started started;
	private Thread gameThread;
	
	private static int SET_FPS = 60;
	private static int SET_UPS = 10;
	private final boolean SHOW_STATS = true;
	
	//Need these here, so we can update times
	static double timePerUpdate;
	static double timePerFrame;
	
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
		
		new Toast(gamePanel, new JLabel(new ImageIcon(DataLoader.GetSpriteData(DataLoader.MENU))), gamePanel.getWidth(), gamePanel.getHeight(), 5, true);
	}

	/**
	 * 	Mandatory method when implementing "Runnable"
	 */
	@Override
	public void run() {
		//The amount of time per each individual update/frame
		//1 billion is used to convert seconds, to nanoseconds
		timePerUpdate = NANOSECOND_PER_SECOND/SET_UPS;
		timePerFrame = NANOSECOND_PER_SECOND/SET_FPS;
		
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
			deltaF += (curTime - pTime)/timePerFrame;
			deltaU += (curTime - pTime)/timePerUpdate;
			
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
				if(System.currentTimeMillis() - lastChecked >= 1000) {
					
					//Update when we last checked and display info
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
	
	public static void setUPS(int ups) {
		if(ups >= 0) {
			SET_UPS = ups;
			
			//update this, so no updates will actually happen
			timePerUpdate = NANOSECOND_PER_SECOND/SET_UPS;			
		}
	}
	
	public static int getUPS() {
		return SET_UPS;
	}
}