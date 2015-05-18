package webcrawler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is the webcrawler. Objects of this should only be called Bugbert, as
 * that is his name.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.06 11/07/13
 * @since 10/30/2013
 */
public class WebCrawler {
    private String savefile;

    private URL webpage;
    private Scanner scanHTML;

    // used to stop multiple readings of the same website
    private int scannedPages = 0;

    // regex used to find e-mails
    private Pattern emailRegex = Pattern
            .compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}",
                    Pattern.CASE_INSENSITIVE);

    public WebCrawler() {
        this("http://people.emich.edu/egurnee/", "links.txt");
    }

    public WebCrawler(String address) {
        this(address, "links.txt");
    }

    public WebCrawler(String address, String savefile) {
        try {
            this.savefile = savefile;
            this.webpage = new URL(address);
            this.scanHTML = new Scanner(this.webpage.openConnection()
                    .getInputStream());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // opens the links page to read the next webpage
    public void nextPage() {
        Scanner inFile = null;
        try {
            inFile = new Scanner(new FileInputStream(new File(this.savefile)));
        } catch (FileNotFoundException e1) {
            // obviously the file is there, you just created it...
        }
        for (int i = 0; i < scannedPages; i++) {
            inFile.nextLine();
        }
        String newAddress = "";
        while (true) {
            try {
                newAddress = inFile.nextLine();
                this.scanHTML = new Scanner(new URL(newAddress)
                        .openConnection().getInputStream());
                break;
            } catch (MalformedURLException e) {
                System.err.println("Not a valid URL: " + newAddress);
            } catch (IOException e) {
                System.err.println("Error connecting to the net.");
            }
        }
        inFile.close();
        addPageLinks();

    }

    public void addPageLinks() {
        PrintWriter toFile = null;

        try {
            // URLConnection theConnection = webpage.openConnection();
            // InputStream theStream = theConnection.getInputStream();
            // scanHTML = new
            // Scanner(this.webpage.openConnection().getInputStream());
            toFile = new PrintWriter(new FileOutputStream(this.savefile, true));

            do {
                for (String str : findInfoInLine(this.scanHTML.nextLine())) {
                    toFile.println(new URL(this.webpage, str));
                    // System.out.println(new URL(this.webpage, str));
                }
            } while (this.scanHTML.hasNextLine());
        } catch (FileNotFoundException | MalformedURLException e) {
            System.err.println("Error connecting to the net.");
            e.printStackTrace();
        } finally {
            this.scanHTML.close();
            toFile.close();
        }
        scannedPages++;
    }

    private String[] findInfoInLine(String line) {
        ArrayList<String> theLinks = new ArrayList<>();

        Matcher matchLine = this.emailRegex.matcher(line);
        int end = 0;
        do {
            if (matchLine.find(end)) {
                PrintWriter outEmail = null;
                try {
                    outEmail = new PrintWriter(new FileOutputStream(new File(
                            "emails.txt"), true));
                    outEmail.println(matchLine.group());
                    end = matchLine.end();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    outEmail.close();
                }
            }
        } while (!matchLine.hitEnd());

        while (line.indexOf("<a href=\"") >= 0) {
            int startURLIndex = line.indexOf("<a href=\"") + 9;
            line = line.substring(startURLIndex);
            int endURLIndex = line.indexOf("\"");
            theLinks.add(line.substring(0, endURLIndex));
        }
        return theLinks.toArray(new String[theLinks.size()]);
    }
}