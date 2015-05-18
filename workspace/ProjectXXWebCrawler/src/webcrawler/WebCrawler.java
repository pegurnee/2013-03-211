package webcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Eddie Gurnee
 * @version 0.0.04 11/05/13
 */
public class WebCrawler {
    private String savefile;
    private URL webpage;
    private Scanner scanHTML;

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

    public void addPageLinks(RandomAccessFile theFile) {
        try {
            theFile.seek(theFile.length());

            do {
                String temp = scanHTML.nextLine();
                while (temp.indexOf("<a href=\"") >= 0) {
                    int startURLIndex = temp.indexOf("<a href=\"") + 9;
                    temp = temp.substring(startURLIndex);
                    int endURLIndex = temp.indexOf("\"");
                    String theLink = temp.substring(0, endURLIndex);
                    // System.out.println(
                    // temp.substring(
                    // (temp.indexOf("href=\"") + 6),
                    // (temp.indexOf("\"", temp.indexOf("href=\"") + 6))
                    // )
                    // );
                    // By creating a new URL here, we manage to grab the
                    // absolute URL from the current relative links
                    System.out.println(new URL(this.webpage, theLink));
                }
            } while (this.scanHTML.hasNextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPageLinks() {
        PrintWriter toFile = null;

        try {
            // URLConnection theConnection = webpage.openConnection();
            // InputStream theStream = theConnection.getInputStream();
            // scanHTML = new
            // Scanner(this.webpage.openConnection().getInputStream());
            toFile = new PrintWriter(new File(this.savefile));

            do {
                for (String str : findLinksInLine(this.scanHTML.nextLine())) {
                    System.out.println(new URL(this.webpage, str));
                }
            } while (this.scanHTML.hasNextLine());
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            this.scanHTML.close();
            toFile.close();
        }
    }

    private String[] findLinksInLine(String line) {
        ArrayList<String> theLinks = new ArrayList<>();
        while (line.indexOf("<a href=\"") >= 0) {
            int startURLIndex = line.indexOf("<a href=\"") + 9;
            line = line.substring(startURLIndex);
            int endURLIndex = line.indexOf("\"");
            theLinks.add(line.substring(0, endURLIndex));
        }
        return theLinks.toArray(new String[theLinks.size()]);
    }

}