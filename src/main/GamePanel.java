package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;


/*
 * 	The actual screen/panel where everything will be drawn. 
 * 	This is only the inside screen within the frame; so, it dosent include min, max, close.
 * 
 */
public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	private int deltaX = 0, deltaY = 0;
	
	public GamePanel() {
		mouseInputs = new MouseInputs();
		
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	
	public void changeDeltaX(int value) {
		deltaX += value;
	}
	
	public void changeDeltaY(int value) {
		deltaY += value;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(100 + deltaX, 100 + deltaY, 50, 50);
		
		//remove this with an actual game loop
		repaint();
	}
	
}
