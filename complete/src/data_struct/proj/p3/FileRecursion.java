package data_struct.proj.p3;

import java.io.File;
import java.util.Scanner;

/**
 * This program is used to do a variety of recursion based directory lookup
 * tasks.
 * 
 * @author Becca Quaintance
 * @author Eddie Gurnee
 * @version 0.0.06 12/05/2013
 * @since 11/25/2013
 * 
 */
public class FileRecursion {

    public static void main(String[] args) {
        String directory;
        String target;
        File theFile = null;

        Scanner scan = new Scanner(System.in);
        int failCount = 0;

        while (true) {
            System.out.print("Please enter a directory name: ");
            directory = scan.nextLine();

            theFile = new File(directory);

            if (theFile.exists() && theFile.isDirectory()) {
                break;
            } else if (failCount > 3) {
                System.out.println("No directory recursion for you.");
            } else {
                System.out.println("That's not a valid directory.");
                failCount++;
            }
        }

        System.out.println();
        System.out.println("Within \"" + theFile.getName() + "\", there are "
                + countFiles(theFile) + " files:");

        displayFiles(theFile);

        System.out.println();
        System.out.print("Please enter a file you would like to find: ");
        target = scan.nextLine();

        File targetFile = new File(target);

        if (target.length() > 0 && fileFound(theFile, targetFile)) {
            System.out.println("File Found!");
        } else {
            System.out.println("Sorry file was not found!");
        }

        scan.close();
    }

    /**
     * 
     * @param file
     *            the directory of which to count all contained files
     * @return the number of files a given directory and its subdirectories (if
     *         any) contain
     */
    private static int countFiles(File file) {
        File[] listing = file.listFiles();
        int counter = 0;
        for (File f : listing) {
            counter++;
            if (f.isDirectory()) {
                counter += countFiles(f);
            }
        }
        return counter;
    }

    /**
     * 
     * @param file
     *            the directory that all contained files will be displayed
     */
    private static void displayFiles(File file) {
        File[] listing = file.listFiles();

        for (File f : listing) {
            System.out.println(f.getName());
            if (f.isDirectory()) {
                displayFiles(f);
            }
        }
    }

    /**
     * 
     * @param file
     *            the directory to check if the target file is contained in
     * @param findFile
     *            the target file to search for
     * @return true if findFile is located anywhere within file or any of its
     *         subdirectories
     */
    private static boolean fileFound(File file, File findFile) {
        boolean found = false;
        File checkfile = new File(file, findFile.toString());
        if (!checkfile.exists()) {
            File[] listing = file.listFiles();
            for (File f : listing) {
                if (f.isDirectory()) {
                    found = fileFound(f, findFile);
                    if (found) {
                        break;
                    }
                }
            }
        } else {
            displaySource(checkfile.getParentFile());
            System.out.println(checkfile.getName());
            return true;
        }
        return found;
    }

    /**
     * EXTRA CREDIT METHOD: Used to display the absolute path of a file, through
     * recursion.
     * 
     * @param theFile
     *            the file who's absolute path will be displayed
     */
    private static void displaySource(File theFile) {
        if (theFile.getParent() == null) {
            System.out.print(theFile.getName()
                    + System.getProperty("file.separator"));
        } else {
            displaySource(theFile.getParentFile());
            System.out.print(theFile.getName()
                    + System.getProperty("file.separator"));
        }
    }
}
