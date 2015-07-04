package data_struct.proj.p2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * This class is used to run the webcrawler that has been affectionately named
 * Bugburt.
 * 
 * @author Eddie Gurnee
 * @author Nicole Downer
 * @version 0.0.1 11/05/2013
 * @see WebCrawler
 */
public class ThisIsForCrawling {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // String address = "http://www.emich.edu/";
        // String address = "http://people.emich.edu/egurnee/";
        // String address =
        // "http://www.tutorialspoint.com/java/java_string_indexof.htm";
        // String address = "http://www.wikipedia.org/";
        // String address = "http://www.tvtropes.org/";
        String address = "";
        while (true) {
            System.out.println("What website would "
                    + "you like for me to crawl through?");
            address = kb.nextLine().trim();
            try {
                URL temp = new URL(address);
                break;
            } catch (MalformedURLException e) {
                System.err.println("That's not a valid "
                        + "website.\nPlease include \""
                        + "http://\" and \"www\" if necessary.");
            }
        }
        int crawlPages = 3;
        while (true) {
            System.out.println("How many connected pages "
                    + "do you want me to crawl through?");
            if (kb.hasNextInt()) {
                crawlPages = kb.nextInt();
                if (crawlPages > 5) {
                    System.out.print("WARNING: That many "
                            + "pages is sure to bog down "
                            + "your computer for quite some "
                            + "time, are you sure that is "
                            + "what you want to do? [y/n] ");
                    if (kb.next().equalsIgnoreCase("y")) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                kb.nextLine();
            }
        }

        kb.close();

        WebCrawler bugbert = new WebCrawler(address);

        long start = System.currentTimeMillis();
        System.out.println("Crawling through base page...");
        bugbert.addPageLinks();
        System.out.println("...base page complete!");

        for (int i = 0; i < crawlPages; i++) {
            System.out.println("Crawling through connected page " + (i + 1)
                    + "...");
            bugbert.nextPage();
            System.out.println("...page " + (i + 1) + " complete!");
        }
        long end = System.currentTimeMillis();
        System.out.println("Crawling complete.\nTook " + (end - start)
                + " milliseconds in total.");
    }
}