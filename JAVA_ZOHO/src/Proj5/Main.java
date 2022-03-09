package Proj5;	// flightReservationSystem

import java.util.Date;
import java.util.Stack;
import java.util.Scanner;
import java.io.PrintStream;

public class Main {
	static int ticketno = 0;
	static Date timenow = new Date();
	static Flight flight = new Flight();
	static PrintStream ss = System.out;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean loopControl = true;
		Stack<String> historyStack = new Stack<String>();

		System.out.println("Date: " + timenow.toString());
		do {
			ss.println("\n1.Book new Ticket");
			ss.println("2.Cancel last ticket");
			ss.println("3.Booked & Confirmed Tickets");
			ss.println("4.Available Tickets");
			ss.println("5.Exit");
			ss.print("Enter your choice : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				flight.bookTicket(generateTicket());
				break;
			case 2:
				flight.cancelTicket(generateTicket());
				break;
			case 3:
				flight.displayAllTickets();
				break;
			case 4:
				flight.availableTickets();
				break;
			case 5:
				loopControl = false;
				break;
			default:
				ss.println("Invalid Choice!");
			}
		} while (loopControl);
	}

	public static Ticket generateTicket() {
		ss.print("Name : ");
		String name = scan.next();
		ss.print("Age : ");
		int age = scan.nextInt();
		ss.print("Gender : ");
		String gender = scan.next();
		ss.print("seat Class Type (EC - Economy[100], BC - Business[50], FC - First[25]): ");
		String seatpref = scan.next();
		return new Ticket(name, age, gender, seatpref);

	}
}
