 package Proj0;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Application0 {
    public static void main(String[] args) throws FileNotFoundException {
        File file_object = new File("E:\\ProjectFiles\\JAVA_ZOHO\\src\\Proj0\\studentdetails.txt");
        Scanner scan = new Scanner(file_object);    // input file and cmd
        Scanner scan2 = new Scanner(System.in);     // input file and cmd
        BufferedReader br = new BufferedReader(new FileReader(file_object));    // input file and cmd
//        Scanner scan = new Scanner(System.in);
//        Scanner scan2 = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream ss = System.out;
        ArrayList<Student> cseA = new ArrayList<>();
//        ss.println("Number of Students: ");
        int numberofstudents = scan.nextInt();
        scan.nextLine();
        while (numberofstudents-- > 0) {
            ss.println("Student Name: ");
            String newname = scan.next();
            ss.println("Student Age: ");
            int newage = scan.nextInt();
            scan.nextLine();
            ss.println("Student Marks (format: mark1, mark2, mark3): ");
            int[] newmarks = new int[3];
            for (int i = 0; i < 3; i++) {
                newmarks[i] = scan.nextInt();
            }
            Student newcomer = new Student(newname, newage, newmarks);
            cseA.add(newcomer);
        }
        ss.println(cseA);
        ss.println("Enter roll no. to query:\t");
        int queryindex = scan2.nextInt() - 1;
        if (queryindex > 0 && (queryindex < cseA.size())) {
            ss.println("Result of " + cseA.get(queryindex).name + ": " + (Student.getaverage(cseA.get(queryindex).marks) > 40 ? "pass" : "fail"));      // class.function(object.variable)
        } else {
            ss.println("Invalid Input!");
        }
    }
}