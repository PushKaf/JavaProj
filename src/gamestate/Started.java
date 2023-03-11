package gamestate;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.Constants.UI;
import utils.DataLoader;

/**
 * 	State where the simulation has started
 */
public class Started {
	
	private BufferedImage backgroundImg;
	
	public Started() {
		
		//Get the image using our utils DataLoader
		backgroundImg = DataLoader.GetSpriteData(DataLoader.MAIN_BACKGROUND);
	}
	
	
	//Once we have buttons you can click, we'll call the update here
	public void update() {
		
	}
	
	//Drawing the background
	public void draw(Graphics g) {
		//Specifying image, (0,0) upper left start pos, (1280x720) size of window, null->imageObserver, will always be null for us
		g.drawImage(backgroundImg, 0, 0, UI.WIDTH, UI.HEIGHT, null);
	}
	
	
}
