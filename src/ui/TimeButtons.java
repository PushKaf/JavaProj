package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import gamestate.Started;
import main.Game;
import main.GamePanel;
import utils.Constants.CGame;
import utils.Toast;

public class TimeButtons {
	
	private final String PAUSE_UNI = "\u23F8";
	private final String PLAY_UNI = "\u25B6";
	
	private GamePanel gamePanel;
	private JPanel panel;
	private JButton pause, speed, clear, slow;
	
	public TimeButtons(GamePanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
		panel = new JPanel(new GridLayout(2,3));
		
		pause = new JButton(PAUSE_UNI);
		speed = new JButton("\u22D9");
		slow = new JButton("\u22D8");
		clear = new JButton("X");

		pause.addActionListener(e -> pauseControls());
		speed.addActionListener(e -> timeControls(e));
		slow.addActionListener(e -> timeControls(e));
		clear.addActionListener(e -> clearControls());
		
		panel.add(slow);
		panel.add(pause);
		panel.add(speed);
		panel.add(clear);

		gamePanel.add(panel);
	}
	
	public void clearControls() {
		Started.main.clear();
		
		new Toast(gamePanel, "Cleared All Animals");
	}
	
	public void timeControls(ActionEvent e) {
		int ups = Game.getUPS();
		
		if(ups != 0) {			
			if(e.getSource().equals(speed)) {
				Game.setUPS(ups+5);
				
				new Toast(gamePanel, String.format("Speed Up! New Speed: %d", ups));
			}else {
				if(ups > 5) {
					Game.setUPS(ups-5);	
					
					new Toast(gamePanel, String.format("Slow Down! New Speed: %d", ups));
				}else if(ups-1 != 0){
					Game.setUPS(ups-1);
					
					new Toast(gamePanel, String.format("Slow Down! New Speed: %d", ups));
				}else {
					new Toast(gamePanel, "Can't go lower than 1!");
				}
			}
		}else {
			new Toast(gamePanel, "Unpause the game first", 500);
		}
	}
	
	public void pauseControls() {
		System.out.println(pause.getText());
		
		if(pause.getText().equals(PAUSE_UNI)) {
			Game.setUPS(0);
			pause.setText(PLAY_UNI);
			
			new Toast(gamePanel, "Paused Game.");
			
		}else {
			Game.setUPS(CGame.UPS);
			pause.setText(PAUSE_UNI);
			
			new Toast(gamePanel, "Resumed Game.");
		}
	}
	
}
