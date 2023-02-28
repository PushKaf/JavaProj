package main;

import javax.swing.JFrame;


/*
 *	The entire window itself, including the min, max, close buttons. 
 */
public class GameWindow extends JFrame{
	
	public GameWindow(GamePanel gamePanel) {
		
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(gamePanel);
		
		setVisible(true);
		
		
	}
}
