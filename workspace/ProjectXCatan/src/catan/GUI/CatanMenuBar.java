package catan.GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.08 10/15/2013
 *
 */
public class CatanMenuBar extends JMenuBar {
	private CatanActionListeners cal = new CatanActionListeners();
	
	public CatanMenuBar() {
		super();		
		
		//adds the menu headings to the menu bar
		add(mFile());
		add(mSettings());
		add(mHelp());
	}
	private JMenu mFile() {
		JMenu theFile = new JMenu("File");	
		
		JMenuItem newGameMenuItem = new JMenuItem("New");
		newGameMenuItem.addActionListener(cal.new NewGameListener());	

		JMenuItem saveGameMenuItem = new JMenuItem("Save");
		//saveGameMenuItem.addActionListener(cal.new SaveGameListener());		

		JMenuItem loadGameMenuItem = new JMenuItem("Load");
		//loadGameMenuItem.addActionListener(cal.new LoadGameListener());
		
		JMenuItem exitGameMenuItem = new JMenuItem("Exit");
		exitGameMenuItem.addActionListener(cal.new EndGameListener());
		
		theFile.add(newGameMenuItem);
		theFile.add(saveGameMenuItem);
		theFile.add(loadGameMenuItem);		
		theFile.add(exitGameMenuItem);
		
		return theFile;
	}
	private JMenu mSettings() {
		JMenu theSettings = new JMenu("Settings");		
				
		JMenu selectVersionMenu = new JMenu("Select Version");
		JMenuItem versionOriginal = new JMenuItem("Original");
		//versionOriginal.addActionListener(cal.new VersionGameListener());	
		JMenuItem versionStarTrek = new JMenuItem("Star Trek");
		//versionStarTrek.addActionListener(cal.new SaveGameListener());
		JMenuItem versionKirk = new JMenuItem("For Kirk");
		//versionKirk.addActionListener(cal.new SaveGameListener());	
		selectVersionMenu.add(versionOriginal);
		selectVersionMenu.add(versionStarTrek);
		selectVersionMenu.add(versionKirk);
		
		JMenuItem saveGameMenuItem = new JMenuItem("Save");
		//saveGameMenuItem.addActionListener(cal.new SaveGameListener());		

		JMenuItem loadGameMenuItem = new JMenuItem("Load");
		//loadGameMenuItem.addActionListener(cal.new LoadGameListener());
		
		JMenuItem exitGameMenuItem = new JMenuItem("Exit");
		exitGameMenuItem.addActionListener(cal.new EndGameListener());
		
		theSettings.add(selectVersionMenu);
		theSettings.add(saveGameMenuItem);
		theSettings.add(loadGameMenuItem);		
		theSettings.add(exitGameMenuItem);
		
		return theSettings;
	}
	private JMenu mHelp() {
		JMenu theHelp = new JMenu("Help");
		JMenuItem manualMenuItem = new JMenuItem("User Manual");
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		
		theHelp.add(manualMenuItem);
		theHelp.add(aboutMenuItem);
		
		return theHelp;
	}
}

