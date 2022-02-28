package Proj1;// Application1Util.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

enum VehicleOutline {
	username,
	vehicleID,
	wheeler;
}

public class Vehicle {
	String username;
	int vehicleID;
	int wheeler;
	LocalDateTime entry;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
	Vehicle (String uname, int vID, int vWheeler, LocalDateTime today) {
		this.username = uname;
		this.vehicleID = vID;
		this.wheeler = vWheeler;
		this.entry = today;
	}

	@Override
	public String toString() {
		return "\n" + dtf.format(entry) + " " + username + " " + wheeler + "-wheeler " + vehicleID;
	}
}