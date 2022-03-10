package Proj0;

import Competitive.MySubmission;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Application0 {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream ss = System.out;    // LAZINESS OVERLOADED :P
        Scanner scan2 = new Scanner(System.in);
        Scanner scan;

        String file_path = System.getProperty("user.dir");
        String abs_class_name = Application0.class.getName();
        String class_name = abs_class_name.substring(1 + abs_class_name.indexOf("."));
        String package_name = abs_class_name.substring(0, abs_class_name.indexOf("."));
        ss.println(class_name);     // DEBUG
        ss.println(package_name);   // DEBUG
        File file_object = new File(file_path + "\\src\\" + package_name + "\\input.in");
        boolean readfromfile = file_object.exists();
        if (!readfromfile) {
            ss.println("Failed to load the input file!");
            scan = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            scan = new Scanner(file_object);    // input file and cmd
            BufferedReader br = new BufferedReader(new FileReader(file_object));    // input file and cmd
        }

        try {
            ArrayList<Student> cseA = new ArrayList<>();
            int numberofstudents = 0;
            while (scan.hasNext()) {
                ss.print(!readfromfile ? "\nStudent Name: " : "");
                String newname = scan.next();
                ss.println(!readfromfile ? "\nStudent Marks (format: mark1, mark2, mark3): " : "");
                int[] newmarks = new int[3];
                for (int i = 0; i < 3; i++) {
                    newmarks[i] = scan.nextInt();
                }
                Student newcomer = new Student(newname, newmarks);
                cseA.add(newcomer);
                numberofstudents++;
            }
            ss.println(cseA);
            ss.println("Enter roll no. to query:\t");

            int queryindex = -1;
            try {
                queryindex = scan2.nextInt();
            } catch (Exception err) {
                ss.println("Invalid Input given: " + err);
            }
            boolean found = false;
            for (Student stud : cseA) {      // Search Records
                if (queryindex > numberofstudents) {
                    ss.println("Invalid Index Given");
                    break;
                }
                if (stud.getId() == queryindex) {
                    // class.function(object.variable)
                    ss.println("Result of " + stud.getName() + ": " + (Student.getaverage(stud.getMarks()) > 40 ? "pass" : "fail"));
                    found = true;
                    break;
                }
            }
            if (!found) {
                ss.println("Student not found!");
            }
        }
        catch (Exception err) {
            System.out.println("Program crashed successfully: " + err);
        }

        scan.close();
        scan2.close();
    }
}