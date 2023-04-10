package main;

import javax.swing.JFrame;


/**
 *	The entire window itself, including the min, max, close buttons. 
 */
@SuppressWarnings("serial")
public class GameWindow extends JFrame{
	
	public GameWindow(GamePanel gamePanel) {
		//Making sure the "x" button actually terminates the program
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		//Adding the panel so we can see stuff
		add(gamePanel);
//		setResizable(false);
		
		//Packs the content in the window
		pack();
		
		setVisible(true);
	}
}
