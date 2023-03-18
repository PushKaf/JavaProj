package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Dog;
import main.GamePanel;

/*
 * 	Where all of our crucial keyboard inputs will take place. 
 * 	Other classes will also have listeners to make
 * 	code easier to read. 
 */
public class KeyboardInputs implements KeyListener{
	private GamePanel gamePanel;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		gamePanel.getGame().getStarted().keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 	No idea what this does.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
