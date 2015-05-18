package catan.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import catan.SYS.Hex;

/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.18 10/15/2013
 * @see CatanFrame
 * @see HexGui
 * 
 */
public class HexBoard extends JLayeredPane {
	private final int HEIGHT = 625;
	private final int WIDTH = 750;

	public HexBoard(Hex[] theHexes) {
		super();
		setLayout(null);
		setBackground(new Color(30, 50, 80));
		setOpaque(true);
		
		setBounds(0, 0, WIDTH, HEIGHT);
		HexGUI[] board = new HexGUI[theHexes.length];
		
		//creates the locations that will be used to absolutely position the hexes
		int locX = 300;
		int locY = 50;
		
		//initializes each element in the board array as a hexGUI element
		//with data given by the hex array
		for (int i = 0; i < board.length; i++) {
			board[i] = new HexGUI(theHexes[i]);
		}

		//creates outer ring of sea
		//across the top
		for (int i = 0; i < 3; i++) {
			locX += 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right top
		for (int i = 3; i < 6; i++) {
			locX += 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right bottom
		for (int i = 6; i < 9; i++) {
			locX -= 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//backwards across the bottom
		for (int i = 9; i < 12; i++) {
			locX -= 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the bottom left
		for (int i = 12; i < 15; i++) {
			locX -= 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the top left
		for (int i = 15; i < 18; i++) {
			locX += 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//the first ring of land
		//the inner ring starting location		
		locX += 50;
		locY += 75;			
		//across the second row
		for (int i = 18; i < 20; i++) {
			locX += 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right top
		for (int i = 20; i < 22; i++) {
			locX += 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right bottom
		for (int i = 22; i < 24; i++) {
			locX -= 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//backwards across the bottom
		for (int i = 24; i < 26; i++) {
			locX -= 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the bottom left
		for (int i = 26; i < 28; i++) {
			locX -= 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the top left
		for (int i = 28; i < 30; i++) {
			locX += 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//the innermost ring of land
		//the innermost ring starting location		
		locX += 50;
		locY += 75;			
		//across the second row
		for (int i = 30; i < 31; i++) {
			locX += 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right top
		for (int i = 31; i < 32; i++) {
			locX += 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//down the right bottom
		for (int i = 32; i < 33; i++) {
			locX -= 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//backwards across the bottom
		for (int i = 33; i < 34; i++) {
			locX -= 100;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the bottom left
		for (int i = 34; i < 35; i++) {
			locX -= 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//up the top left
		for (int i = 35; i < 36; i++) {
			locX += 50;
			locY -= 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		//the center location
		for (int i = 36; i < 37; i++) {
			locX += 50;
			locY += 75;
			board[i].setBounds(locX, locY, board[i].getWidth(), board[i].getHeight());
			add(board[i]);
		}
		/*
		HexGUI hex1 = new HexGUI("Brick");
		hex1.setBounds(150, 125, 100, 100);
		add(hex1);
		System.out.println(hex1.getBounds());
		
		HexGUI hex2 = new HexGUI("Wheat");
		hex2.setBounds(200, 200, 100, 100);
		add(hex2);
		
		HexGUI hex3 = new HexGUI("Sheep");
		hex3.setBounds(300, 200, 100, 100);
		add(hex3);
		
		HexGUI hex4 = new HexGUI("Sheep");
		hex4.setBounds(250, 125, 100, 100);
		add(hex4);
		
		HexGUI hex5 = new HexGUI("Desert");
		hex5.setBounds(400, 200, 100, 100);
		add(hex5);
		
		HexGUI hex6 = new HexGUI("Sea");
		hex6.setBounds(350, 125, 100, 100);
		add(hex6);
		*/
//				for (int i = 0; i < 18; i++) {
//					add(board[i]);
//				}
	}
	private void createRing() {
		
	}
}