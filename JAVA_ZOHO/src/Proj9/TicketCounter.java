package Proj9;

import java.lang.*;     // Runtime, ProcessHandle
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.*;   // AtomicInteger

public class TicketCounter {

    private static volatile int totalSeats = 3;
    public static volatile AtomicInteger ticketID = new AtomicInteger(0);
    public static HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
    public static HashMap<Integer, String> hp2 = new HashMap<Integer, String>();

    public synchronized int bookTicket(String currentBooker, int currentDemand) {
        int bookingStatus = 0;
        if ((totalSeats >= currentDemand) && (currentDemand > 0)) {
            System.out.print("Hi, " + currentBooker + " : " + currentDemand + " Seats booked Successfully");
            System.out.println(" by Thread " + Thread.currentThread().getName());
            totalSeats = totalSeats - currentDemand;
            bookingStatus = ticketID.incrementAndGet();
            hp.putIfAbsent(bookingStatus, currentDemand);
            hp2.putIfAbsent(bookingStatus, currentBooker);
        } else {
            System.out.println("Hi, " + currentBooker + " : Seats Not Available");
            bookingStatus = -1;
        }
        return bookingStatus;
    }

    public synchronized void cancelTicket(int ticketID) {
        if (hp.containsKey(ticketID)) {
            totalSeats = totalSeats + hp.get(ticketID);
            hp.replace(ticketID, 0);
            System.out.println("Ticket cancelled successfully");
        } else {
            System.out.println("Failed to cancel the ticket");
        }
    }

    public static int getTotalSeats() {
        return totalSeats;
    }

    public static void showUserTickets() {
        for (Map.Entry item : hp2.entrySet()) {
            System.out.println(hp2.get(item.getKey()) + " - Ticket ID " + item.getKey() + " : " + hp.get(item.getKey()) + " tickets");
        }
    }
}