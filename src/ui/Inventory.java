package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import entities.Creature;
import entities.Dog;
import entities.Tree;
import gamestate.Started;
import main.GamePanel;


public class Inventory {
	private ArrayList<Creature> items = new ArrayList<>();
	
	private GamePanel gamePanel;
	private JPanel panel;
	private Random rand = new Random();
	
	public Inventory(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		panel = new JPanel(new FlowLayout());
//		panel.setSize(gamePanel.getWidth(), gamePanel.getHeight());
		
		items.add(new Dog(0, 0));
		items.add(new Tree(0, 0));
		items.add(new Dog(0, 0));
		items.add(new Tree(0, 0));		
		items.add(new Dog(0, 0));
		items.add(new Tree(0, 0));
		
		for(int i = 0; i < items.size(); i++) {
			Creature c = items.get(i);
			JButton creature = new JButton(new ImageIcon(c.getSprite().getScaledInstance(100, 70, Image.SCALE_SMOOTH)));
			creature.setBorder(null);
			creature.setOpaque(false);
			creature.setContentAreaFilled(false);
			creature.setMargin(new Insets(5,5,5,5));
			
			//Temporary Code: Create method!!!
			if(i == 0)
			{
				creature.addActionListener(e -> Started.main.add(new Dog(rand.nextInt(1000), rand.nextInt(1000))));
			} else {
				creature.addActionListener(e -> Started.main.add(new Tree(rand.nextInt(1000), rand.nextInt(1000))));
			}
//			creature.setPreferredSize(new Dimension(1000, 1000));
			
			panel.add(creature);
		}
		
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				
				int btnWidth = (int)(size.getWidth()*.1);
				int btnHeight = (int)(size.getHeight()*.9);
				
				for(Component c : panel.getComponents()) {	
					c.setPreferredSize(new Dimension(btnWidth, btnHeight));
				}
				
				panel.revalidate();
			}
			
		});
		
		gamePanel.add(panel, BorderLayout.NORTH);
		
	}
	
	public void draw(Graphics g) {
		Dimension size = gamePanel.getSize();
		
//		g.setColor(Color.CYAN);
		
		int rectWidth = (int) (size.getWidth()*.90);
		int rectHeight = (int) (size.getHeight()*.10);

		int rectX = (int) ((size.getWidth() - rectWidth)/2);
		int rectY = (int) ((size.getHeight() - rectHeight)/2);
//		
//		g.fillRoundRect((int)(rectX), (int)(rectY*1.855), rectWidth, rectHeight, 25, 25);
//		
		panel.setSize(rectWidth, rectHeight);
		panel.setLocation(rectX, (int)(rectY*1.855));

	}
}
