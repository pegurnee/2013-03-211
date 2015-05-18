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
public class EdgeGUI extends JButton {
	
	public EdgeGUI() {
		super();
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		
		addActionListener(new EdgeListener());
	}
	private class EdgeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Motherfucking edge yo!");			
		}		
	}	
}