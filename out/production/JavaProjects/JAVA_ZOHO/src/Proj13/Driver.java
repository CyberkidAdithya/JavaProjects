package Proj13;

public class Driver {

    boolean is_available = true;    // status of the driver;
    String leave_application = "";  // reason for absence

    public void accept_trip() {
        is_available = false;
    }

    public void reject_trip() {
        leave_application = "Not feeling well";
    }
}