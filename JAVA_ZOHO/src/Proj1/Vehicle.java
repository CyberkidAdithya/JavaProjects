package Proj1;// Application1Util.java

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

enum VehicleOutline {
    username,
    unique_vehicleID,
    wheeler;
}

public class Vehicle {
    private String username;
    private int wheeler;
    private String numberplate;

    private LocalDateTime entry;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    private int vehicleID = 1;
    static AtomicInteger nextId = new AtomicInteger();

    Vehicle(String uname, String numberplate, int vWheeler, LocalDateTime today) {
        this.username = uname;
        this.vehicleID = nextId.incrementAndGet();
        this.wheeler = vWheeler;
        this.numberplate = numberplate;
        this.entry = today;
    }

    private int findCost(int wheeler) {
        int cost = 25;
        switch (wheeler) {
            case 2: {
                cost *= 2;
                break;
            }
            case 4: {
                cost *= 4;
                break;
            }
            default: {
//                System.out.println("Unknown Vehicle, Charging minimum.");
                cost *= 2;
            }
        }
        return cost;
    }

    public int getCost() {
        return findCost(wheeler);
    }

    @Override
    public String toString() {
        return "\n" + vehicleID + " " + username + " " + wheeler + "-wheeler " + dtf.format(entry);
    }
}