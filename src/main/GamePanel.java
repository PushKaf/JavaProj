<<<<<<< HEAD
package main;

import java.awt.BorderLayout;
=======

package main;

>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import utils.Constants.UI;

/*
 * 	The actual screen/panel where everything will be drawn--the canvas. 
 * 	This is only the inside screen within the frame; so, it dosent include min, max, close.
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private Game game;
	
	
	public GamePanel(Game game) {
		this.game = game;
		mouseInputs = new MouseInputs();
		
		// Add in the listeners
<<<<<<< HEAD
//		setLayout(new BorderLayout());
=======
		
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	private void setPanelSize() {
		Dimension panelSize = new Dimension(UI.WIDTH, UI.HEIGHT);
		setPreferredSize(panelSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g);
<<<<<<< HEAD
=======
		repaint();
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
	}
	
	public Game getGame() {
		return game;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 39d2fe99fcf471acc2643d099341412068c94273
