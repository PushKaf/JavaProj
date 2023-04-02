package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/*
 * 	Where all of our crucial mouse inputs will take place. 
 * 	Other classes will also have listeners to make
 * 	code easier to read. 
 */
public class MouseInputs implements MouseListener, MouseMotionListener{

	/*
	 * 	This is when the user presses && releases the mouse button. 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		switch(e.getButton()) {
		case MouseEvent.BUTTON1: {
			System.out.println("L");
			break;
		}
		case MouseEvent.BUTTON2: {
			System.out.println("M");
			break;
		}
		case MouseEvent.BUTTON3: {
			System.out.println("R");
			break;
		}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

}
