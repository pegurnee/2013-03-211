package catan.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.03 10/15/2013
 *
 */
public class CatanActionListeners {
	
	public class TestListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("What a twist!");
		}
	}
	public class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//creates a new map, starts a new game
		}
	}
	public class EndGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}	
	public class VersionGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//sets different graphics based on version selected
		}
	}
}
