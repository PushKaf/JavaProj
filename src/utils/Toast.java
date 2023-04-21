package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
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
		this(gPanel, new JLabel(msg) , msg.length()*10, 33, delay, false);

	}
	
	//Made this so I can show the menu on load
	public Toast(GamePanel gPanel, JLabel info, int width, int height, int delay, boolean isMenu) {
		//Make frame look pretty
		setUndecorated(true);
		setSize(width, height);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 25, 25));
		
		//Format Label
		info.setFont(new Font("Times New Roman", Font.BOLD, 17));
		info.setForeground(Color.BLACK);
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setVerticalAlignment(JLabel.CENTER);

		if(isMenu) {			
			JButton ply = new JButton("Play");
			ply.addActionListener(e -> {
				removeToast(delay);
			});
			
			JButton exit = new JButton("Exit");
			exit.addActionListener(e -> {
				System.exit(0);
			});
			
			gPanel.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					setSize(gPanel.getWidth(), gPanel.getHeight());
					setShape(new RoundRectangle2D.Double(0, 0, gPanel.getWidth(), gPanel.getHeight(), 25, 25));
					setLocationRelativeTo(gPanel);
				}
			});
			
			add(info, BorderLayout.NORTH);
			add(exit, BorderLayout.EAST);
			add(ply, BorderLayout.SOUTH);
		}else {
			add(info, BorderLayout.CENTER);
		}
		
		//Set location in the middle of the gamepanel no matter where it is, and always on top
		setLocationRelativeTo(gPanel);
		setVisible(true);
		setAlwaysOnTop(true);
		
		if(!isMenu) { removeToast(delay); }
	}
	
	private void removeToast(int delay) {
		//Delete after delay time
		new Timer(delay, n -> {
			dispose();
		}).start();
	}
}
