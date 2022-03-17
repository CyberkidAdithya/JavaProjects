package Proj10;

public class BookingBot extends Thread {

    private TicketCounter BookingSystem;
    private String passengerName;
    private int passengerSeats;

    public BookingBot(TicketCounter ticketCounter, String passengerName, int noOfSeatsToBook) {
        this.BookingSystem = ticketCounter;
        this.passengerName = passengerName;
        this.passengerSeats = noOfSeatsToBook;
    }

    public void run() {
        int bookingStatus = BookingSystem.bookTicket(passengerName, passengerSeats);
        System.out.println("Booking Status: " + bookingStatus);
    }
}

