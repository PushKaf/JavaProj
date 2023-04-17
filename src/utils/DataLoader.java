package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


/**
 * 	Will only hold the variable names for the images, and the method to get the data.
 */
public class DataLoader {
	
	//Using constants since these will never change. Here, we'll 
	//have a bunch of the same constant for our other images/sprites
	public static final String MAIN_BACKGROUND = "main_background.png";
	public static final String DOG_SPRITE = "dog_sprites.png";
	public static final String TREE_SPRITE = "tree.png";
	public static final String DEER_SPRITE = "deer.png";
	public static final String BUSH_SPRITE = "bush.png";
	public static final String DRAGON_SPRITE = "dragon.png";
	public static final String HUMAN_SPRITE = "farmer.png";
	public static final String CROW_SPRITE = "crow.png";
	public static final String MOUSE_SPRITE = "mouse.png";
	public static final String SQUIRREL_SPRITE = "squirrel.png";
	public static final String TURTLE_SPRITE = "turtle.png";
	public static final String WOLF_SPRITE = "wolf.png";
	public static final String TURKEY_SPRITE = "turkey.png";
	public static final String EAGLE_SPRITE = "eagle.png";
	
	//Using BufferedImage(concrete) to load the file and read it as an actual image
	public static BufferedImage GetSpriteData(String fileName) {
		//Making a stream to get ready to read the file. Will get the class, and to go the top 
		InputStream is = DataLoader.class.getResourceAsStream("/"+fileName);
		BufferedImage img = null;
		
		//Try to read the file with ImageIO (same as with scanner, we need to check if the file is valid)
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return img;
		
	}
	
	
}
