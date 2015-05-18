package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The window for the entire Catan Game
 * 
 * @author Eddie Gurnee
 * @version 0.0.13 10/29/2013
 * @see HexBoard
 * @see CatanMenuBar
 */
public class CatanFrame extends JFrame {
    /**
     * This class creates the Catan menu bar, including menus and menuItems.
     * 
     * @author Eddie Gurnee
     * @version 0.0.09 10/17/2013
     * @since 10/16/2013
     */
    private class CatanMenuBar extends JMenuBar {
        private CatanMenuBar() {
            super();
            // adds the menu headings to the menu bar
            add(mFile());
            add(mSettings());
            add(mHelp());
        }

        private JMenu mFile() {
            JMenu theFile = new JMenu("File");

            JMenuItem newGameMenuItem = new JMenuItem("New");
            newGameMenuItem.addActionListener(new NumPlayersListener());

            JMenuItem saveGameMenuItem = new JMenuItem("Save");
            // saveGameMenuItem.addActionListener(cal.new SaveGameListener());

            JMenuItem loadGameMenuItem = new JMenuItem("Load");
            // loadGameMenuItem.addActionListener(cal.new LoadGameListener());

            JMenuItem exitGameMenuItem = new JMenuItem("Exit");
            exitGameMenuItem.addActionListener(new EndGameListener());

            theFile.add(newGameMenuItem);
            theFile.add(saveGameMenuItem);
            theFile.add(loadGameMenuItem);
            theFile.add(exitGameMenuItem);

            return theFile;
        }

        /**
         * @author Eddie Gurnee
         * @version 0.0.01 11/17/2013
         * @since 10/16/2013
         * @return
         */
        private JMenu mSettings() {
            JMenu theSettings = new JMenu("Settings");

            JMenu selectVersionMenu = new JMenu("Select Version");
            JMenuItem versionOriginal = new JMenuItem("Original");
            versionOriginal.addActionListener(new VersionGameListener(1));
            JMenuItem versionStarTrek = new JMenuItem("Star Trek");
            versionStarTrek.addActionListener(new VersionGameListener(2));
            JMenuItem versionKirk = new JMenuItem("For Kirk");
            versionKirk.addActionListener(new VersionGameListener(3));
            selectVersionMenu.add(versionOriginal);
            selectVersionMenu.add(versionStarTrek);
            selectVersionMenu.add(versionKirk);

            JMenuItem saveGameMenuItem = new JMenuItem("Enable Password");
            // saveGameMenuItem.addActionListener(cal.new SaveGameListener());

            JMenuItem loadGameMenuItem = new JMenuItem("Load");
            // loadGameMenuItem.addActionListener(cal.new LoadGameListener());

            JMenuItem exitGameMenuItem = new JMenuItem("Exit");
            exitGameMenuItem.addActionListener(new EndGameListener());

            theSettings.add(selectVersionMenu);
            theSettings.add(saveGameMenuItem);
            theSettings.add(loadGameMenuItem);
            theSettings.add(exitGameMenuItem);

            return theSettings;
        }

        /**
         * @author Eddie Gurnee
         * @version 0.0.01 11/17/2013
         * @since 10/16/2013
         * @return
         */
        private JMenu mHelp() {
            JMenu theHelp = new JMenu("Help");
            JMenuItem manualMenuItem = new JMenuItem("User Manual");
            manualMenuItem.addActionListener(new HelpMenuListener());

            JMenuItem aboutMenuItem = new JMenuItem("About");
            aboutMenuItem.addActionListener(new AboutMenuListener());

            theHelp.add(manualMenuItem);
            theHelp.add(aboutMenuItem);

            return theHelp;
        }

        /**
         * @author Eddie Gurnee
         * @version 0.0.01 11/17/2013
         * @since 11/17/2013
         * @return
         */
        private class HelpMenuListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpFrame().setVisible(true);
            }

        }
        /**
         * @author Eddie Gurnee
         * @version 0.0.02 10/30/2013
         * @since 10/30/2013
         * @return
         */
        private class AboutMenuListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String str = "All of the sweat, blood, tears, and coding were provided by:"
                        + "\nNicole Downer"
                        + "\nEddie Gurnee"
                        + "\n"
                        + "\nNeither of whom own the rights to the Settlers of Catan Board Game.";
                JOptionPane.showMessageDialog(null, str, "About Us",
                        JOptionPane.PLAIN_MESSAGE);
                JOptionPane
                        .showMessageDialog(
                                null,
                                "The programmers would like to thank:"
                                        + "\nMike Nitchie & Nicole Arruda for attempting to understand Java GUI's, and allowing us to pester them with questions"
                                        + "\nMark Binkowski for being volunteered to draw up some graphics for us",
                                "Special Thanks:", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    /**
     * This class holds all of the variables and methods needed for the dice to
     * take action in Catan.
     * 
     * @author Eddie Gurnee
     * @version 0.0.09 10/28/2013
     */
    private class DiceSet extends JButton implements ActionListener {
        private int die1;
        private int die2;
        private int numRolled;
        private boolean rolled;

        private class DieFace extends JPanel {
            private int numRolled;
            private int dieNum;
            private final int HEIGHT = 60;
            private final int WIDTH = 60;
            private final int DIAMETER = 15;

            private DieFace(int numRolled, int dieNum) {
                super();
                this.setSize(WIDTH, HEIGHT);
                // this.setMinimumSize(getSize());
                setOpaque(true);
                setContentAreaFilled(true);
                setVisible(true);

                this.numRolled = numRolled;
                this.dieNum = dieNum;
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (dieNum == 1) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.YELLOW);
                }

                g.fillRect(0, 0, WIDTH, HEIGHT);
                g.setColor(Color.WHITE);

                // numRolled == 1 || numRolled == 3 || numRolled == 5
                if (numRolled % 2 == 1) {
                    // center
                    g.fillOval( (WIDTH / 2) - (DIAMETER / 2), (HEIGHT / 2)
                            - (DIAMETER / 2), DIAMETER, DIAMETER);
                }
                if (numRolled != 1) {
                    // bottom left
                    g.fillOval( (DIAMETER / 2), HEIGHT - (DIAMETER / 2)
                            - DIAMETER, DIAMETER, DIAMETER);
                    // top right
                    g.fillOval(WIDTH - (DIAMETER / 2) - DIAMETER,
                            (DIAMETER / 2), DIAMETER, DIAMETER);
                }
                // numRolled == 4 || numRolled == 5 || numRolled == 6
                if (numRolled > 3) {
                    // bottom right
                    g.fillOval(WIDTH - (DIAMETER / 2) - DIAMETER, HEIGHT
                            - (DIAMETER / 2) - DIAMETER, DIAMETER, DIAMETER);
                    // top left
                    g.fillOval( (DIAMETER / 2), (DIAMETER / 2), DIAMETER,
                            DIAMETER);
                }
                if (numRolled == 6) {
                    // middle left
                    g.fillOval( (DIAMETER / 2), (HEIGHT / 2) - (DIAMETER / 2),
                            DIAMETER, DIAMETER);
                    // middle right
                    g.fillOval(WIDTH - (DIAMETER / 2) - DIAMETER, (HEIGHT / 2)
                            - (DIAMETER / 2), DIAMETER, DIAMETER);
                }
            }
        }

        private DiceSet() {
            super("Roll dice");

            this.rolled = false;

            addActionListener(this);
        }

        private void rollDice() {
            Random rn = new Random();

            die1 = rn.nextInt(5) + 1;
            die2 = rn.nextInt(5) + 1;

            numRolled = die1 + die2;

            String str = "\n";
            if (numRolled == 7) {
                str += "You rolled a 7!\nMove the robber!";
            } else {
                str += "All " + numRolled + "s produce!";
            }

            JOptionPane.showMessageDialog(null, "You rolled a " + die1
                    + " and a " + die2 + "!" + str, "Numbers Rolled",
                    JOptionPane.PLAIN_MESSAGE);

            lDiv.add(new DieFace(die1, 1));
            lDiv.add(new DieFace(die2, 2));
            lDiv.revalidate();
            lDiv.repaint();
        }

        public void actionPerformed(ActionEvent e) {
            try {
                if (BoardGame.start) {
                    throw new CatanException();
                }
                if (rolled) {
                    throw new CatanException();
                }
                this.rolled = true;
                rollDice();
                if (numRolled != 7) {
                    for (int r = 1; r < BoardGame.board.gameBoard.length - 1; r++) {
                        for (int c = 1; c < BoardGame.board.gameBoard[r].length - 1; c++) {
                            if ( ((LandHex) (BoardGame.board.gameBoard[r][c]))
                                    .getProduceOn() == numRolled) {
                                ((LandHex) (BoardGame.board.gameBoard[r][c]))
                                        .produce();
                            }
                        }
                    }
                    BoardGame.getActivePlayer().displayNewResources();
                } else {
                    // move the robber
                    BoardGame.board.theRobber.unPlace();

                    // doesn't work for hotseat
                    // for (Player a : BoardGame.thePlayers) {
                    // a.robberDiscard();
                    // }
                }
            } catch (CatanException ex) {
                // you've already rolled
                ex.displayErrMessage();
            }
        }

        public boolean isRolled() {
            return rolled;
        }
    }

    /**
     * This Panel is the start page shown when the game loads.
     * 
     * @author Eddie Gurnee
     * @version 0.0.01 10/29/2013
     */
    public class StartPage extends JPanel {
        public StartPage() {
            super();
            this.setLayout(new BorderLayout());

            JButton numPlayers = new JButton("Set Up Players");
            numPlayers.addActionListener(new NumPlayersListener());
            this.add(numPlayers);
        }
    }

    // the size declarations
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    private JPanel topDiv;
    private JPanel botDiv;
    private JPanel rDiv;
    private JPanel lDiv;

    private DiceSet theDice;
    private boolean initalSettings;

    // window constructor
    public CatanFrame(boolean initialSettings) {
        super("The Settlers of Catan - The Board Game - The Video Game");

        this.setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);

        this.initalSettings = initialSettings;

        // sets the layout for the window with a border around each divider of
        // 10 pixels
        // options: NORTH, SOUTH, EAST, WEST, CENTER
        setLayout(new BorderLayout(10, 10));

        // creates top, bottom, left, and right panels
        topDiv = new JPanel();
        botDiv = new JPanel();
        rDiv = new JPanel();
        lDiv = new JPanel();

        // adds the top, bottom, left, and right panels to the container
        add(topDiv, BorderLayout.NORTH);
        add(botDiv, BorderLayout.SOUTH);
        add(rDiv, BorderLayout.EAST);
        add(lDiv, BorderLayout.WEST);

        // adds things to the top panel
        topDiv.setBackground(Color.WHITE);
        if (BoardGame.start) {
            topDiv.add(new JLabel("Welcome to Catan!"));
        } else {
            topDiv.add(new JLabel("Your turn: "
                    + BoardGame.getActivePlayer().getName()));
        }

        // adds things to the bottom panel
        botDiv.setBackground(Color.WHITE);
        if (!initalSettings) {
            JButton en = new JButton("End Turn!");
            en.addActionListener(new EndTurnListener());
            botDiv.add(en);
        }

        String nbsp = "";
        for (int i = 0; i < 49; i++) {
            nbsp += " ";
        }
        // adds things to the left panel
        lDiv.setLayout(new BoxLayout(lDiv, BoxLayout.Y_AXIS));

        lDiv.add(new JLabel(nbsp));
        if (!BoardGame.start) {
            lDiv.add(new JLabel("Game Pieces:"));

            theDice = new DiceSet();
            lDiv.add(theDice);

            JButton buyDevCard = new JButton("Buy Development Card");
            buyDevCard.addActionListener(new BuyDevCardListener());
            lDiv.add(buyDevCard);

            JButton showOtherPlayers = new JButton("Other Players");
            showOtherPlayers.addActionListener(new OtherPlayersListener());
            lDiv.add(showOtherPlayers);
        }

        // adds things to the right panel
        rDiv.setLayout(new BoxLayout(rDiv, BoxLayout.Y_AXIS));

        rDiv.add(new JLabel(nbsp));
        if (!BoardGame.start) {
            rDiv.add(new JLabel("Your Pieces:"));

            rDiv.add(BoardGame.getActivePlayer().getPieceLabel(0));
            rDiv.add(BoardGame.getActivePlayer().getPieceLabel(1));
            rDiv.add(BoardGame.getActivePlayer().getPieceLabel(2));
            rDiv.repaint();

            JButton playDevCard = new JButton("Play Development Card");
            playDevCard.addActionListener(new PlayDevCardListener());
            rDiv.add(playDevCard);

            JButton showResource = new JButton("My Resources");
            showResource.addActionListener(new UserResourcesListener());
            rDiv.add(showResource);
        }

        if (initialSettings) {
            // adds the JPanel to set up the players
            add(new StartPage(), BorderLayout.CENTER);
        }

        // adds the menu bar
        setJMenuBar(new CatanMenuBar());
    }

    public CatanFrame(Player currentPlayer, HexBoard theBoard) {
        this(false);
        add(theBoard, BorderLayout.CENTER);
        setVisible(true);
        JOptionPane.showMessageDialog(null, BoardGame.getActivePlayer()
                + " it is now your turn!", "", JOptionPane.PLAIN_MESSAGE);
        BoardGame.getActivePlayer().displayTempResources();
    }

    private class NumPlayersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] possNum = {
                    3, 4
            };
            int i = (int)JOptionPane.showOptionDialog(null,
                    "How many players are playing today?", "Number of Players",
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                    possNum, possNum[0]);
            i += 3;
            String[] names = new String[i];
            for (int j = 0; j < names.length; j++) {
                names[j] = (String)JOptionPane.showInputDialog(null, "Player "
                        + (j + 1) + "'s name:", "Enter Player Name",
                        JOptionPane.PLAIN_MESSAGE, null, null, null);
            }
            BoardGame.establishPlayers(i);
            BoardGame.namesOfPlayers(names);

            BoardGame.newFrame();
            CatanFrame.this.dispose();
        }
    }
    private class EndTurnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BoardGame.board.revalidate();
                if (!BoardGame.start) {
                    if (!theDice.isRolled()) {
                        throw new CatanException("Must Roll Dice");
                    }
                    if (!BoardGame.board.theRobber.isPlaced()) {
                        throw new CatanException("Must Place Robber");
                    }
                    if (BoardGame.getActivePlayer().isRoadBuilding()) {
                        throw new CatanException("Must finish Placing Roads");
                    }
                    if (BoardGame.getActivePlayer().getVictoryPoints() >= 10) {
                        throw new Exception();
                    }
                    BoardGame.newFrame();
                } else if (BoardGame.thePlayers[0].isSecondRoadPlaced()) {
                    BoardGame.startGame();
                } else if (BoardGame.getActivePlayer().isSecondRoadPlaced()) {
                    BoardGame.firstSettlements(true);
                } else if (BoardGame.getActivePlayer().isTheRoadPlaced()) {
                    BoardGame.firstSettlements(false);
                }
                CatanFrame.this.dispose();
            } catch (CatanException ex) {
                ex.displayErrMessage();
            } catch (Exception ex) {
                String str = "The current players:";
                for (Player a : BoardGame.thePlayers) {
                    str += "\n" + a.getName() + ": " + a.getVictoryPoints()
                            + " victory points.";
                }
                JOptionPane
                        .showMessageDialog(null, str,
                                "The Players Victory Points",
                                JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "At "
                        + BoardGame.getActivePlayer().getVictoryPoints()
                        + " Victory Points, you've won!", "YOU WIN!",
                        JOptionPane.PLAIN_MESSAGE);
                Object[] options = {
                        "No", "No"
                };
                int n = JOptionPane
                        .showOptionDialog(
                                null,
                                "Would you and your friends like to play again?",
                                "Play again?", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n != 42) {
                    System.exit(0);
                }
            }
        }
    }
    private class BuyDevCardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BoardGame.getActivePlayer().buyDevCard();
            } catch (NotEnoughResourcesException | NotEnoughCardsException ex) {
                ex.displayErrMessage();
            }
        }
    }
    private class PlayDevCardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BoardGame.getActivePlayer().playDevCard();
        }
    }
    private class UserResourcesListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BoardGame.getActivePlayer().displayCurrentResources();
        }
    }
    private class OtherPlayersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str = "The current players:";
            for (Player a : BoardGame.thePlayers) {
                str += "\n" + a.getName() + ": " + a.getVictoryPoints()
                        + " victory points.";
            }
            JOptionPane.showMessageDialog(null, str,
                    "The Players Victory Points", JOptionPane.PLAIN_MESSAGE);
        }
    }
    private class EndGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class VersionGameListener implements ActionListener {
        private int version;

        private VersionGameListener(int version) {
            this.version = version;
        }

        public void actionPerformed(ActionEvent e) {
            // sets different graphics based on version selected
            switch (version) {
            case 1:
                // normal
                break;
            case 2:
                // star trek
                break;
            case 3:
                // for kirk
                break;
            default:
                // default
                break;
            }
        }
    }
}