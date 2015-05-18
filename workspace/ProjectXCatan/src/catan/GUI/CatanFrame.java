package catan.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import catan.SYS.Hex;
import catan.SYS.LandHex;
import catan.SYS.SeaHex;

/**
 * The window for the entire Catan Game
 * 
 * @author Eddie Gurnee
 * @version 0.0.05 10/15/2013
 * @see HexGui
 * @see HexBoard
 * @see CatanActionListeners
 * @see CatanMenuBar
 * 
 */


public class CatanFrame extends JFrame {
	
	//the size declarations
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;
	
	private CatanActionListeners cal = new CatanActionListeners();
	//window constructor
	public CatanFrame() {
		super("The Settlers of Catan - The Board Game - The Video Game");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		getContentPane().setBackground(Color.BLUE);
		
		//sets the layout for the window
		//options: NORTH, SOUTH, EAST, WEST, CENTER
		setLayout(new BorderLayout());
		
		//creates top, bottom, left, and right panels
		JPanel topDiv = new JPanel();
		JPanel botDiv = new JPanel();
		JPanel rDiv = new JPanel();
		JPanel lDiv = new JPanel();
		
		//adds the top, bottom, left, and right panels to the container
		add(topDiv, BorderLayout.NORTH);
		add(botDiv, BorderLayout.SOUTH);
		add(rDiv, BorderLayout.EAST);
		add(lDiv, BorderLayout.WEST);
		
		//adds things to the top panel
		topDiv.setBackground(Color.WHITE);
		topDiv.add(new JLabel("Welcome to Catan!"));
		
		//adds things to the bottom panel
		botDiv.setBackground(Color.WHITE);
		JButton en = new JButton("Click Here!");
		en.addActionListener(cal.new EndGameListener());
		botDiv.add(en);
		
		//adds things to the left panel
		lDiv.add(new JLabel("Other Stuff!"));
		
		//adds things to the right panel
		rDiv.add(new JLabel("Other Pieces!"));
				
		//adds things to the center panel
		JLayeredPane centerDiv = new JLayeredPane();
		centerDiv.setLayout(new BorderLayout());
		add(centerDiv, BorderLayout.CENTER);
		
//		centerDiv.setBackground(Color.GREEN);
//		HexGUI hex4 = new HexGUI(new LandHex("Sheep", 4));
//		hex4.setBounds(250, 125, 100, 100);
		
		
		/*
		centerDiv.setLayout(null);
		centerDiv.setBounds(0, 0, 800, 650);		
		System.out.println(centerDiv.getBounds());
		
		HexGUI hex1 = new HexGUI("Brick");		
		hex1.setBounds(0, 0, 99, 99);
		centerDiv.add(hex1);	
		System.out.println(hex1.getBounds());

		HexGUI hex2 = new HexGUI("Wheat");
		centerDiv.add(hex2);
		hex2.setBounds(200, 200, 150, 150);
		hex2.revalidate();
		centerDiv.repaint();
		System.out.println(hex2.getBounds());
		
//		HexGUI hex3 = new HexGUI("Sheep");
//		hex3.setBounds(300, 200, 100, 100);
//		System.out.println(hex3.getBounds());
//		
//		HexGUI hex4 = new HexGUI("Sheep");
//		hex4.setBounds(250, 125, 100, 100);
//		System.out.println(hex4.getBounds());
//		
//		HexGUI hex5 = new HexGUI("Desert");
//		hex5.setBounds(400, 200, 100, 100);
//		System.out.println(hex5.getBounds());
//		
//		HexGUI hex6 = new HexGUI("Sea");
//		hex6.setBounds(350, 125, 100, 100);
//		System.out.println(hex6.getBounds());		
		
//		centerDiv.add(hex3);
//		centerDiv.add(hex4);
//		centerDiv.add(hex5);
//		centerDiv.add(hex6);
		
		System.out.println(centerDiv.getSize());
		
		
//		centerDiv.setVisible(true);
		//centerDiv.updateUI();
		centerDiv.revalidate();
//		centerDiv.repaint();
//
		this.revalidate();
//		this.repaint();
 * 
 */
		
		String[] rLands = {"Wood", "Sheep", "Ore", "Brick", "Wheat"};
		Hex[] hexes = new Hex[37];
		int[] numberOrder = {5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11, 18};
		
		for (int i = 0; i < 18; i++) {
			hexes[i] = new SeaHex();
		}
		for (int i = 18; i < hexes.length; i++) {
			hexes[i] = new LandHex(rLands[(int)(Math.random() * 5)], numberOrder[i - 18]);
		}
		HexBoard theBoard = new HexBoard(hexes);
		centerDiv.add(theBoard, BorderLayout.CENTER);
		System.out.println(theBoard.getSize());
		
		//theBoard.setLayout(null);

		
		setJMenuBar(new CatanMenuBar());		
	}
}