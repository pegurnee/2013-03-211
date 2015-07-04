package data_struct.proj.pX.edterm;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a functioning terminal program. Theoretically.
 * 
 * @author Eddie Gurnee
 * @version 0.0.01 11/19/2013
 * @since 11/19/2013
 */
public class EdTerm {
    private final static String USER = System.getProperty("user.name");

    // private
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        File pwd = new File(System.getProperty("user.home"));
        ArrayList<String> history = new ArrayList<>();

        enterCmd: while (true) {
            System.out.print(pwd.getName() + ": " + USER + "$: ");
            String cmdLine = kb.nextLine().trim();
            if (!cmdLine.isEmpty()) {
                history.add(cmdLine);
                Scanner cmd = new Scanner(cmdLine);
                String theCMD = cmd.next().toLowerCase();
                switch (theCMD) {
                case "pwd":
                    System.out.println(pwd.getAbsolutePath());
                    break;
                case "open":

                    break;
                case "cd":
                    if (cmd.hasNext()) {
                        String dir = cmd.next();
                        if (dir.equals("../")) {
                            pwd = pwd.getParentFile();
                        } else if (new File(pwd, dir).exists()) {
                            pwd = new File(pwd, dir);
                        } else {
                            System.out.println("No such file or directory");
                        }
                    }
                    break;
                case "ls":
                    if (pwd.list().length != 0) {
                        for (File s : pwd.listFiles()) {
                            if (!s.isHidden()) {
                                System.out.println(s);
                            }
                        }
                    }
                    break;
                case "history":
                    for (String s : history) {
                        System.out.println(s);
                    }
                    break;
                case "exit":
                    cmd.close();
                    break enterCmd;
                default:
                    System.out.println(theCMD + ": command not found");
                    break;
                }
            }
        }
        System.out.println("EdTerm Terminated.");
        kb.close();
    }
}
