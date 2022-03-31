package Proj9;

import java.lang.*;     // Runtime, ProcessHandle
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.*;   // AtomicInteger

public class TicketCounter {

    private static int maxxBooking = 3;   // number of tickets available
    private static volatile int totalSeats = maxxBooking;
    private static volatile int [] seatArray = new int[maxxBooking + 1];
    public static volatile AtomicInteger ticketID = new AtomicInteger(0);
    public static HashMap<Integer, Integer> hp = new HashMap<Integer, Integer>();
    public static HashMap<Integer, String> hp2 = new HashMap<Integer, String>();

    public TicketCounter() {
        seatArray[0] = 1;
    }
    public synchronized int bookTicket(String currentBooker, int demandSeat) {
        int bookingStatus = 0;
        if ((seatArray[demandSeat] == 0) && (demandSeat > 0 && demandSeat < maxxBooking)) {
            System.out.print("Hi, " + currentBooker);
            System.out.print(" : Seat no " + demandSeat + " booked Successfully");
            System.out.println(" by Thread " + Thread.currentThread().getName());
            totalSeats = totalSeats - 1;
            seatArray[demandSeat] = 1;
            bookingStatus = ticketID.incrementAndGet();
            hp.putIfAbsent(bookingStatus, demandSeat);
            hp2.putIfAbsent(bookingStatus, currentBooker);
        } else {
            System.out.print("Hi, " + currentBooker);
            System.out.println(" : Seat no " + demandSeat + " Not Available");
            bookingStatus = -1;
        }
        return bookingStatus;
    }

    public synchronized void cancelTicket(int ticketID) {
        if (hp.containsKey(ticketID) && hp2.containsKey(ticketID)) {
            totalSeats = totalSeats + 1;
            int index = hp.get(ticketID);
            hp.replace(ticketID, -1);
//            System.out.println("INDEX: " + index);
            seatArray[index] = 0;

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
            System.out.println("Name: " + hp2.get(item.getKey()) + "\tTicket ID: " + item.getKey() + "\tSeat No: " + hp.get(item.getKey()));
        }
    }
}