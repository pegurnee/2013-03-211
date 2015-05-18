package catan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This is the window holding all of the help stuff.
 * 
 * @author Nicole Downer
 * @author Eddie Gurnee
 * @version 0.0.06 11/16/2013
 * @since 11/12/2013
 */
public class HelpFrame extends JFrame {
    private final int WIDTH = 600;
    private final int HEIGHT = 400;

    private int helpIndex = 0;

    private ArrayList<String> helpData;
    private ArrayList<String> foundHelp;
    private ArrayList<String> refinedHelp;

    private boolean refined;

    JTextArea discoveredHelp = new JTextArea("");
    JButton nextBtn = new JButton("Next Search Result");
    JButton lastBtn = new JButton("Previous Search Result");
    JPanel bottomBtns = new JPanel();

    public HelpFrame() {
        super("Settler's of Catan - Help");

        this.setResizable(false);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(new BorderLayout(5, 5));

        JPanel rightSide = new JPanel();
        rightSide.setLayout(new BoxLayout(rightSide, BoxLayout.Y_AXIS));
        add(rightSide, BorderLayout.EAST);

        JButton loadHelp = new JButton("Reload Help");
        JButton searchHelp = new JButton("Search Help");
        JButton browseHelp = new JButton("Browse Help");
        loadHelp.addActionListener(new LoadHelpListener());
        searchHelp.addActionListener(new SearchHelpListener());
        browseHelp.addActionListener(new BrowseHelpListener());

        rightSide.add(searchHelp);
        rightSide.add(browseHelp);
        rightSide.add(loadHelp);

        this.helpData = new ArrayList<String>();

        this.load();

        JPanel leftSide = new JPanel();
        leftSide.setLayout(new BorderLayout());
        add(leftSide, BorderLayout.WEST);
        leftSide.add(discoveredHelp, BorderLayout.CENTER);
        this.discoveredHelp.setTabSize(3);

        nextBtn.addActionListener(new ScrollHelpListener(true));
        lastBtn.addActionListener(new ScrollHelpListener(false));
        // add(discoveredHelp, BorderLayout.WEST);

        add(this.bottomBtns, BorderLayout.SOUTH);
        bottomBtns.add(lastBtn);
        bottomBtns.add(nextBtn);
    }

    /**
     * @author Nicole Downer
     * @author Eddie Gurnee
     * @version 0.0.03 11/17/2013
     * @since 11/14/2013
     */
    private void load() {
        Scanner infile = null;
        try {
            infile = new Scanner(new FileInputStream(new File("GLOSSARY.txt")));
            while (infile.hasNextLine()) {
                String line = infile.nextLine();
                int start = line.indexOf("<!BS@>");

                if (start > -1) {
                    String data = "";

                    while (true) {
                        String temp = infile.nextLine() + "\n";
                        int end = temp.indexOf("</!BS@>");
                        if (end == -1) {
                            data += temp;
                        } else {
                            break;
                        }
                    }
                    helpData.add(data);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            infile.close();
        }
    }

    /**
     * @author Nicole Downer
     * @author Eddie Gurnee
     * @param searchTerm
     * @version 0.0.02 11/16/2013
     * @since 11/15/2013
     */
    private void search(String searchTerm) {
        searchTerm = searchTerm.toLowerCase();
        this.foundHelp = new ArrayList<String>();
        this.refinedHelp = new ArrayList<String>();
        this.refined = false;

        this.helpIndex = 0;
        for (String s : this.helpData) {
            String tempStr = s.toLowerCase();
            if (tempStr.indexOf(searchTerm) > -1) {
                this.foundHelp.add(s);
            }
        }
        if (this.foundHelp.size() == 0) {
            this.foundHelp.add("Your search term was not found.");
        }
        this.discoveredHelp.setText(foundHelp.get(this.helpIndex));
        if (this.foundHelp.size() > 5) {
            int n = JOptionPane
                    .showConfirmDialog(
                            null,
                            "There are "
                                    + foundHelp.size()
                                    + " results found."
                                    + "\nWould you like to refine your search with another term?",
                            "Refine Search", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null);
            if (n == 0) {
                String term = (String)JOptionPane.showInputDialog(null,
                        "Enter search term:", "Search",
                        JOptionPane.PLAIN_MESSAGE);
                this.refined = true;
                this.refineSearch(term);
            }
        }
    }

    /**
     * @author Eddie Gurnee
     * @author Nicole Downer
     * @param searchTerm
     * @version 0.0.01 11/17/2013
     * @since 11/17/2013
     */
    private void refineSearch(String searchTerm) {
        searchTerm = searchTerm.toLowerCase();
        this.refinedHelp = new ArrayList<String>();
        this.helpIndex = 0;
        for (String s : this.foundHelp) {
            String tempStr = s.toLowerCase();
            if (tempStr.indexOf(searchTerm) > -1) {
                this.refinedHelp.add(s);
            }
        }
        if (this.refinedHelp.size() == 0) {
            this.refinedHelp.add("Your search term was not found.");
        }
        this.discoveredHelp.setText(this.refinedHelp.get(this.helpIndex));
    }

    /**
     * @author Eddie Gurnee
     * @author Nicole Downer
     * @version 0.0.03 11/16/2013
     * @since 11/15/2013
     */
    private class LoadHelpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HelpFrame.this.load();
        }
    }
    private class ScrollHelpListener implements ActionListener {
        private boolean forward;

        private ScrollHelpListener(boolean forward) {
            this.forward = forward;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (forward) {
                if (!HelpFrame.this.refined) {
                    if (HelpFrame.this.helpIndex < HelpFrame.this.foundHelp
                            .size() - 1) {
                        HelpFrame.this.helpIndex++;
                        HelpFrame.this.discoveredHelp.setText(foundHelp
                                .get(HelpFrame.this.helpIndex));
                    }
                } else {
                    if (HelpFrame.this.helpIndex < HelpFrame.this.refinedHelp
                            .size() - 1) {
                        HelpFrame.this.helpIndex++;
                        HelpFrame.this.discoveredHelp.setText(refinedHelp
                                .get(HelpFrame.this.helpIndex));
                    }
                }
            } else {
                if (!HelpFrame.this.refined) {
                    if (HelpFrame.this.helpIndex > 0) {
                        HelpFrame.this.helpIndex--;
                        HelpFrame.this.discoveredHelp.setText(foundHelp
                                .get(HelpFrame.this.helpIndex));
                    }
                } else {
                    if (HelpFrame.this.helpIndex > 0) {
                        HelpFrame.this.helpIndex--;
                        HelpFrame.this.discoveredHelp.setText(refinedHelp
                                .get(HelpFrame.this.helpIndex));
                    }
                }
            }
        }
    }
    private class SearchHelpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String term = (String)JOptionPane.showInputDialog(null,
                    "Enter search term:", "Search", JOptionPane.PLAIN_MESSAGE);

            HelpFrame.this.search(term);
        }
    }
    private class BrowseHelpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            HelpFrame.this.search(" ");
        }
    }
}