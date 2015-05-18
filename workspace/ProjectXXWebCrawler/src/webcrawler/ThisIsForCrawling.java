package webcrawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Eddie Gurnee
 * @version 0.0.1 11/05/2013
 * @see WebCrawler
 * 
 */
public class ThisIsForCrawling {
	public static void main(String[] args) {
		RandomAccessFile allTheLinks = null;
		String address = "http://www.emich.edu/";
//		String address = "http://people.emich.edu/egurnee/";
		//		String address = "http://www.tutorialspoint.com/java/java_string_indexof.htm";
//				String address = "http://www.wikipedia.org/";
		//		String address = "http://www.tvtropes.org/";
				WebCrawler bugbert = new WebCrawler(address);
		try {
			allTheLinks = new RandomAccessFile(new File("links.txt"), "rw");
			
//			WebCrawler bugbert = new WebCrawler();
			bugbert.addPageLinks();
		} catch (FileNotFoundException ex) {

		}
		

	}
}