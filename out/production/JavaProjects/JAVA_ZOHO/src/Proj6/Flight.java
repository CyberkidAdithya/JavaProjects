package Proj6;

import java.util.ArrayList;
import java.io.PrintStream;

public class Flight {
	static PrintStream ss = System.out;
	ArrayList<Ticket> cfTickets = new ArrayList<Ticket>();
	ArrayList<Ticket> racTickets = new ArrayList<Ticket>();
	ArrayList<Ticket> wlTickets = new ArrayList<Ticket>();
	seatClass requestClass = new seatClass();

	public void bookTicket(Ticket ticket) {
		if (ticket.age > 5) {
			if (cfTickets.size() < 4) {
				requestClass.allocateClass(ticket);
				cfTickets.add(ticket);
			} else if (racTickets.size() < 3) {
				ticket.setTicketStatus("In Reservation against Cancellation.");
				racTickets.add(ticket);
			} else if (wlTickets.size() < 2) {
				ticket.setTicketStatus("In Waiting List.");
				wlTickets.add(ticket);
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
				cfTickets.add(cfTickets.size() - 1, racTickets.get(0));
				racTickets.remove(0);
				if (!wlTickets.isEmpty()) {
					racTickets.add(racTickets.size() - 1, wlTickets.get(0));
					wlTickets.remove(0);
				}
			}
			return;
		} else if (removeTicket(ticket, racTickets)) {
			if (!wlTickets.isEmpty()) {
				racTickets.add(racTickets.size() - 1, wlTickets.get(0));
				wlTickets.remove(0);
			}
			return;
		} else if (removeTicket(ticket, wlTickets)) {
			return;
		} else {
			ss.println("No such ticket was found!");
			return;
		}
	}

	private boolean removeTicket(Ticket ticket, ArrayList<Ticket> ticketBookings) {
		for (Ticket tickets : ticketBookings) {
			displayTicket(tickets);
			displayTicket(ticket);
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
		else if (racTickets.contains(ticket))
			return racTickets;
		else {
			return wlTickets;
		}
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
		for (Ticket ticket : racTickets) {
			ss.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
			           + ticket.getTicketStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
		}
		for (Ticket ticket : wlTickets) {
			ss.println(ticket.name + "\n" + ticket.age + "\n" + ticket.gender + "\n"
			           + ticket.getTicketStatus() + " " + (findTicketStatus(ticket).indexOf(ticket) + 1));
		}
	}

	public void availabelTickets() {
		ss.println("Confirm available tickets are " + (4 - cfTickets.size()));
		ss.println("Rac available tickets are " + (3 - racTickets.size()));
		ss.println("Waiting list available tickets are " + (2 - wlTickets.size()));
	}
}
