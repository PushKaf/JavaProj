package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W: {
			gamePanel.changeDeltaY(-10);
			break;
		}
		case KeyEvent.VK_S: {
			gamePanel.changeDeltaY(10);
			break;
		}		
		case KeyEvent.VK_D: {
			gamePanel.changeDeltaX(10);
			break;
		}		
		case KeyEvent.VK_A: {
			gamePanel.changeDeltaX(-10);
			break;
		}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 	No idea what this does.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
