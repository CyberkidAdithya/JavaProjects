package Proj5;

import java.util.Objects;

public class Ticket {
    String name;
    int age;
    String gender;
    String seatClass;
    String ticketStatus;

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Ticket ticket = (Ticket) o;
//		return age == ticket.age && Objects.equals(name, ticket.name) && Objects.equals(gender, ticket.gender) && Objects.equals(seatClass, ticket.seatClass) && Objects.equals(ticketStatus, ticket.ticketStatus);
//	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, gender, seatClass, ticketStatus);
	}

	public Ticket(String name, int age, String gender, String seatClass) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.seatClass = seatClass;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
