package Proj13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Cab {

    public ArrayList<Cab> Cabs = new ArrayList<>();
    public HashMap<Integer, String> findCabOwnerbyID = new HashMap<>();
    static AtomicInteger nextId = new AtomicInteger();
    private int cabID = 1;

    Cab(int cabID) {
        this.cabID = cabID;
    }

    public void cab_add(String cabDriver) {
        Cab newcab = new Cab(cabID);
        findCabOwnerbyID.putIfAbsent(cabID, cabDriver);
        Cabs.add(newcab);
        cabID = nextId.incrementAndGet();
    }

    public void cab_remove(int cabID) {
        Cabs.remove(cabID);
        findCabOwnerbyID.remove(cabID);
    }

    public Cab cab_display(int cabID) {
        return Cabs.get(cabID);
    }

    public int cab_count() {
        return Cabs.size();
    }
}
