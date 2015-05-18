package catan.GUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 10/15/2013
 *
 */
public class CornerGUI extends JButton {
	private final int WIDTH = 20;
	private final int HEIGHT = 20;
	
	public CornerGUI() {
		super();
		setSize(WIDTH, HEIGHT);
//		setContentAreaFilled(false);
//		setFocusPainted(false);
//		setBorderPainted(false);
		
		addActionListener(new TestListener());
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	private class TestListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("What a corner!");
		}
	}
}
