package Proj1;// Application1.java
import java.io.*;
// import java.lang.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Queue;
import java.time.LocalDateTime;

public class Application1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nParking System - Stack Implementation");
		Date timenow = new Date();
		System.out.println("Date: " + timenow.toString());
		Stack<Vehicle> lane1 = new Stack<>();
		int choice = -1, maxxsize = 3;
		while (choice != 0) {
			System.out.println("\n1. Add a Vehicle\n2. Remove a Vehicle\n3. Number of Vehicles\n4. Peek into last Vehicle\n5. Exit\nEnter your choice: ");
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid Input :(");
				break;
			}
			switch (choice) {
			case 1: {
				if (lane1.size() == maxxsize) {
					System.out.println("Sorry, the lane is full.");
					break;
				}
				System.out.println("Enter the Driver's Name: ");
				String givenName = scan.next();
				System.out.println("Enter the Vehicle ID: ");
				int givenID = scan.nextInt();
				System.out.println("2 wheeler or 4 wheeler?(format: 2/4): ");
				int givenwheels = scan.nextInt();
				LocalDateTime givendate = LocalDateTime.now();
				scan.nextLine();
				lane1.push(new Vehicle(givenName, givenID, givenwheels, givendate));
				System.out.println("Vehicle added to lane!");
				break;
			}
			case 2: {
				if (lane1.empty()) {
					System.out.println("The lane is already empty.");
					break;
				}
				System.out.println("Vehicle removed from lane!");
				lane1.pop();
				break;
			}
			case 3: {
				System.out.println("Displaying lane details.");
				if (lane1.empty()) {
					System.out.println("The lane is already empty.");
				} else {
					System.out.println(lane1.size() + " vehicles found!");
					System.out.println(lane1);
				}
				break;
			}
			case 4: {
				if (lane1.empty()) {
					System.out.println("Unable to peek an empty lane.");
					break;
				}
				System.out.println("Peeking into the last vehicle.");
				System.out.println(lane1.peek());
				break;
			}
			case 5: {
				System.out.println("Exiting from the program.");
				choice = 0;
				break;
			}
			default: {
				System.out.println("Invalid Input!");
				break;
			}
			}
		}
	}
}