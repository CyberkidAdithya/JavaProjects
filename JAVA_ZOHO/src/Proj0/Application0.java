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
        System.out.println(class_name);
        System.out.println(package_name);
        File file_object = new File(file_path + "\\src\\" + package_name + "\\input.in");
        if (!file_object.exists()) {
            System.out.println("Failed to load the input file!");
            scan = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            scan = new Scanner(file_object);    // input file and cmd
            BufferedReader br = new BufferedReader(new FileReader(file_object));    // input file and cmd
        }

        ArrayList<Student> cseA = new ArrayList<>();
//        ss.println("Number of Students: ");
//        int numberofstudents = scan.nextInt();
//        scan.nextLine();
        while (scan.hasNext()) {
            ss.println("Student Name: ");
            String newname = scan.next();
            ss.println("Student Marks (format: mark1, mark2, mark3): ");
            int[] newmarks = new int[3];
            for (int i = 0; i < 3; i++) {
                newmarks[i] = scan.nextInt();
            }
            Student newcomer = new Student(newname, newmarks);
            cseA.add(newcomer);
        }
        ss.println(cseA);
        ss.println("Enter roll no. to query:\t");
        int queryindex = scan2.nextInt();
        boolean found = false;
        for (Student stud: cseA) {
            if (stud.getId() == queryindex) {
                ss.println("Result of " + cseA.get(queryindex).getName() + ": " + (Student.getaverage(cseA.get(queryindex).getMarks()) > 40 ? "pass" : "fail"));      // class.function(object.variable)
                found = true;
                break;
            }
        }
        if (!found) {
            ss.println("Student not found");
        }

    }
}