package Proj5;

import java.util.ArrayList;
import java.util.Queue;
import java.io.PrintStream;
import java.util.LinkedList;

public class Flight {
    static PrintStream ss = System.out;
    ArrayList<Ticket> cfTickets = new ArrayList<Ticket>();
    Queue<Ticket> racTickets = new LinkedList<Ticket>();        // offer poll peek size
    Queue<Ticket> wlTickets = new LinkedList<Ticket>();
    seatClass requestClass = new seatClass();

    public void bookTicket(Ticket ticket) {
        if (ticket.age > 5) {
            if (cfTickets.size() <= 2) {
                requestClass.allocateClass(ticket);
                cfTickets.add(ticket);
            } else if (racTickets.size() < 50) {
                ticket.setTicketStatus("In Reservation against Cancellation.");
                racTickets.offer(ticket);
            } else if (wlTickets.size() < 25) {
                ticket.setTicketStatus("In Waiting List.");
                wlTickets.offer(ticket);
            } else {
                ss.println("No Tickets available.");
                return;
            }
            displayTicket(ticket);
        } else {
            ss.println("Free [no ticket] for children below 5 years!");
            return;
        }
    }

    public void cancelTicket(Ticket ticket) {
        if (removeTicket(ticket, cfTickets)) {
            if (!racTickets.isEmpty()) {
                cfTickets.add(cfTickets.size() - 1, racTickets.poll());
                if (!wlTickets.isEmpty()) {
                    racTickets.offer(wlTickets.poll());
                }
            }
            return;
        } else {
            ss.println("No such confirmed ticket was found!");
            return;
        }
    }

    private boolean removeTicket(Ticket ticket, ArrayList<Ticket> ticketBookings) {
        for (Ticket tickets : ticketBookings) {
            if (tickets.name.equals(ticket.name) && tickets.age == ticket.age && tickets.gender.equals(ticket.gender)) {
                ticketBookings.remove(tickets);
                ss.println("Ticket cancelled successfully.");
                return true;
            }
        }
        return false;
    }

    private ArrayList<Ticket> findTicketStatus(Ticket ticket) {
        if (cfTickets.contains(ticket))
            return cfTickets;
        else
            return null;
    }

    public void displayTicket(Ticket ticket) {
        ss.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
                + ticket.getTicketStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
    }

    public void displayAllTickets() {
        for (Ticket ticket : cfTickets) {
            ss.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
                    + ticket.getTicketStatus() + " " + findTicketStatus(ticket).indexOf(ticket) + 1);
        }
    }

    public void availableTickets() {
        ss.println("Confirm available tickets are " + (100 - cfTickets.size()));
        ss.println("Rac available tickets are " + (50 - racTickets.size()));
        ss.println("Waiting list available tickets are " + (25 - wlTickets.size()));
    }
}
