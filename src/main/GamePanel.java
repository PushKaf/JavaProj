package main;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import utils.Constants.UI;

/*
 * 	The actual screen/panel where everything will be drawn--the canvas. 
 * 	This is only the inside screen within the frame; so, it dosent include min, max, close.
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private Game game;
	
	private static int panelHeight;
	private static int panelWidth;
	
	public GamePanel(Game game) {
		this.game = game;
		setPanelSize();
	}
	
	private void setPanelSize() {
		Dimension panelSize = new Dimension(UI.WIDTH, UI.HEIGHT);
		setPreferredSize(panelSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.draw(g);
		panelHeight = this.getHeight();
		panelWidth = this.getWidth();
	}
	
	public static int getPanelHeight() {
		return panelHeight;
	}
	
	public static int getPanelWidth() {
		return panelWidth;
	}
	
	public Game getGame() {
		return game;
	}
}