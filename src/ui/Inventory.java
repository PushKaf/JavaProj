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
import javax.swing.JScrollPane;

import entities.Bush;
import entities.Creature;
import entities.Crow;
import entities.Deer;
import entities.Dog;
import entities.Dragon;
import entities.Eagle;
import entities.Human;
import entities.Mouse;
import entities.Squirrel;
import entities.Tree;
import entities.Turkey;
import entities.Turtle;
import entities.Wolf;
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
		items.add(new Bush(0, 0));
		items.add(new Crow(0, 0));
		items.add(new Deer(0, 0));
		items.add(new Dragon(0, 0));
		items.add(new Eagle(0, 0));
		items.add(new Human(0, 0));
		items.add(new Mouse(0, 0));
		items.add(new Squirrel(0, 0));
		items.add(new Turkey(0, 0));
		items.add(new Turtle(0, 0));
		items.add(new Wolf(0, 0));
		
		for(int i = 0; i < items.size(); i++) {
			Creature c = items.get(i);
			JButton creature = new JButton(new ImageIcon(c.getSprite().getScaledInstance(90, 50, Image.SCALE_SMOOTH)));
			
			creature.setBorder(null);
			creature.setOpaque(false);
			creature.setContentAreaFilled(false);
			creature.setMargin(new Insets(5,5,5,5));
			creature.addActionListener(e -> c.spawnCreature(rand.nextInt((int) gamePanel.getSize().getWidth()), rand.nextInt((int) gamePanel.getSize().getHeight())));
			
			panel.add(creature);
		}
		
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				Dimension panelSize = gamePanel.getSize();
				
				int btnWidth = (int)(size.getWidth()*.09);
				int btnHeight = (int)(size.getHeight()*.85);

				for(Component c : panel.getComponents()) {	
					c.setPreferredSize(new Dimension(btnWidth, btnHeight));
				}
				
				int rectWidth = (int) (panelSize.getWidth()*.93);
				int rectHeight = (int) (panelSize.getHeight()*.10);
				
				int rectX = (int) ((panelSize.getWidth() - rectWidth)/2);
				int rectY = (int) ((panelSize.getHeight() - rectHeight)/2);

				panel.setSize(rectWidth, rectHeight);
				panel.setLocation(rectX, (int)(rectY*1.855));
				
//				panel.revalidate();
			}
		});
		
		gamePanel.add(panel, BorderLayout.SOUTH);
	}
	
	public void draw(Graphics g) {
//		Dimension size = gamePanel.getSize();
//
//		int rectWidth = (int) (size.getWidth()*.93);
//		int rectHeight = (int) (size.getHeight()*.10);
//
//		int rectX = (int) ((size.getWidth() - rectWidth)/2);
//		int rectY = (int) ((size.getHeight() - rectHeight)/2);
//
//		panel.setSize(rectWidth, rectHeight);
//		panel.setLocation(rectX, (int)(rectY*1.855));
	}
}
