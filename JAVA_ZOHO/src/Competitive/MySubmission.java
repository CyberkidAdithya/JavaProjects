// package Competitive;    // comment this line if using Sublime Editor
// press Ctrl + D to duplicate line in Intellij
// press Ctrl + Shift + G to delete a line in Intellij
package Competitive;

import java.io.*;
import java.lang.*;     // Runtime, ProcessHandle
import java.math.*;     // BigInteger
import java.util.*;
import java.io.PrintStream;
//----------CODE BEGINS----------

// press Ctrl + Alt + L to auto indent in Intellij
// press Ctrl + D to duplicate line in Intellij
// press Ctrl + Y to delete a line in Intellij


class CPUwaster extends Thread {
    public int star_count = 0;
    public static boolean threadflag = true;

    public CPUwaster(String threadname) {
        // giving the new born thread a name
        this.setName(threadname);
    }

    public void run() {
        while (star_count < 5) {
            System.out.print("*");
            star_count++;
        }
        System.out.println("\n" + threadflag);
    }
}

public class MySubmission {
    public static void main(String[] args) {
        // File file_object = new File("E:\\ProjectFiles\\JAVA_ZOHO\\src\\Proj0\\studentdetails.txt");
        // Scanner fscan = new Scanner(file_object);
        // BufferedReader fbr = new BufferedReader(new InputStreamReader(file_object));
        PrintStream ss = System.out;
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Runtime rt = Runtime.getRuntime();

        String file_path = System.getProperty("user.dir");
        String className = MySubmission.class.getName();
        String packageName = className.substring(0, className.indexOf("."));
//        System.out.println(file_path);  // DEBUG
//        System.out.println(className);  // DEBUG
//        System.out.println(packageName);    // DEBUG

        try {
//            System.setIn(new FileInputStream(file_path + "\\src\\" + packageName + "\\input.in"));
//            System.setOut(new PrintStream(new FileOutputStream(file_path + "\\src\\Competitive\\output.out")));
        } catch (Exception err) {
            err.printStackTrace();
            System.err.println("Error retrieving your I/O files");
            ;   // System.exit(0);     // terminate JVM
        } finally {
            System.out.println("Welcome to the Program!");     // OUTPUT STREAM BEGINS
        }

        CPUwaster t1 = new CPUwaster("first_thread");
        CPUwaster t2 = new CPUwaster("second_thread");
        System.out.println(t1.getPriority());
        String farewell = "Goodbye";
        System.out.format("%s!", farewell);     // EOF

    }
}

//----------CODE ENDS----------

/*
    ArrayList:
        add(index), addAll(ArrayList),  get(index), set(index, value), remove(index), remove(value), size(), isEmpty(), clear()
    Stack:
        push(value), pop(), peek()
    Queue:
        offer(value), poll(), peek()
    Set:
        add(value), remove(value), contains(value)
    HashMap:
        get(index), put(index, value), containsKey(value)
 */

/*
    Thread:
        start(), sleep(ms), getState(), getName(), getPriority(), getCount(), run(), setName(), isDaemon(), join(), setDaemon(),
 */