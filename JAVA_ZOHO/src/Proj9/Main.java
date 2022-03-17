package Proj9;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter();
        List<BookingBot> bookingQueue = new ArrayList<BookingBot>();
        System.out.println("Welcome to Ticket Booking System");
        int choice = -1;
        try {
            do {
                System.out.println("1. Add to Booking Queue: ");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. View Tickets");
                System.out.println("4. Availability");
                System.out.println("5. Start Booking Queue: ");
                System.out.println("6. Exit System");
                System.out.println("Enter your choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Enter passenger name: ");
                        String passengerName = scan.next();
                        System.out.println("Enter no. of tickets: ");
                        int noOfSeatsToBook = scan.nextInt();
                        BookingBot ticketObject = new BookingBot(ticketCounter, passengerName, noOfSeatsToBook);
                        bookingQueue.add(ticketObject);
                        break;
                    }
                    case 2: {
                        System.out.println("Enter ticket ID to cancel: ");
                        int ticketID = scan.nextInt();
                        ticketCounter.cancelTicket(ticketID);
                        break;
                    }
                    case 3: {
//                    TicketCounter tc = new TicketCounter();
                        showTickets(ticketCounter);
                        break;
                    }
                    case 4: {
//                    TicketCounter tc = new TicketCounter();
                        System.out.println("Available tickets: " + ticketCounter.getTotalSeats());
                        break;
                    }
                    case 5: {
                        ExecutorService helperbot = Executors.newFixedThreadPool(10);
                        for (BookingBot item : bookingQueue) {
                            helperbot.execute(item);
                        }
                        bookingQueue.clear();
                        helperbot.shutdown();
                        break;
                    }
                    case 6: {
                        choice = 0;
                        break;
                    }
                    default: {
                        System.out.println("Invalid Input");
                    }
                }
            } while (choice != 0);
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static void showTickets(TicketCounter tc) {
        tc.showUserTickets();
    }

}
