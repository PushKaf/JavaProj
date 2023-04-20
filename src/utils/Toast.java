package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.Timer;

import main.GamePanel;

@SuppressWarnings("serial")
public class Toast extends JDialog {
	public Toast(GamePanel gPanel, String msg) {
		this(gPanel, msg, 1000);
	}
	
	public Toast(GamePanel gPanel, String msg, int delay) {
		//Make frame look pretty
		setUndecorated(true);
		setSize(msg.length()*10, 33);
		getContentPane().setBackground(Color.GRAY);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
		
		//Format Label
		JLabel info = new JLabel(msg);
		info.setFont(new Font("Times New Roman", Font.BOLD, 17));
		info.setForeground(Color.WHITE);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setVerticalAlignment(JLabel.CENTER);
		add(info);

		//Set location in the middle of the gamepanel no matter where it is, and always on top
		setLocationRelativeTo(gPanel);
		setVisible(true);
		setAlwaysOnTop(true);

		//Delete after delay time
		new Timer(delay, e -> {
			dispose();
		}).start();
	}
}
