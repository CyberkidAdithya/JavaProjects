package Proj6;

public class Ticket {
	String name;
	int age;
	String gender;
	String seatClass;
	String ticketStatus;

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
