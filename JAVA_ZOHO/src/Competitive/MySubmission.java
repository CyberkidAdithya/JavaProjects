// package Competitive;    // comment this line if using Sublime Editor
// press Ctrl + D to duplicate line in Intellij
// press Ctrl + Shift + G to delete a line in Intellij
package Competitive;

import java.io.*;
import java.lang.*;
import java.math.*;     // BigInteger
import java.util.*;
import java.io.PrintStream;
//----------CODE BEGINS----------

public class MySubmission {     // press Ctrl + Alt + L to auto indent in Intellij
    public static void main(String[] args) {
        // File file_object = new File("E:\\ProjectFiles\\JAVA_ZOHO\\src\\Proj0\\studentdetails.txt");
        // Scanner fscan = new Scanner(file_object);
        // BufferedReader fbr = new BufferedReader(new InputStreamReader(file_object));
        PrintStream ss = System.out;
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello World!");
        String file_path = System.getProperty("user.dir");
        String className = MySubmission.class.getName();
        String packageName = className.substring(0, className.indexOf("."));
//        System.out.println(file_path);  // DEBUG
//        System.out.println(className);  // DEBUG
//        System.out.println(packageName);    // DEBUG
        try {
            System.setIn(new FileInputStream(file_path + "\\src\\" + packageName + "\\input.in"));
            System.setOut(new PrintStream(new FileOutputStream(file_path + "\\src\\Competitive\\output.out")));
        } catch (Exception e) {
            System.err.println("Error retrieving your I/O files");
            ;   // System.exit(0);     // terminate JVM
        }
        System.out.println("GoodBye!");
    }
}

//----------CODE ENDS----------