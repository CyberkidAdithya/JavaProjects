// package Competitive;    // comment this line if using Sublime Editor
// press Ctrl + D to duplicate line in Intellij
// press Ctrl + Shift + G to delete a line in Intellij

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
        try {
            System.setIn(new FileInputStream("inputf.txt"));
            System.setOut(new PrintStream(new FileOutputStream("outputf.txt")));
        } catch (Exception e) {
            ; // System.err.println("Error retrieving your I/O files");
        }
        System.out.println("GoodBye!");
    }
}

//----------CODE ENDS----------