package Proj0;

import java.util.concurrent.atomic.AtomicInteger;

enum StudentOutline {
    name,
    marks,
    unique_id;
}

public class Student {
    private String name;
    private int[] marks = new int[3];
    private int id = 1;
    static AtomicInteger nextId = new AtomicInteger();

    Student(String username, int usermarks[]) {
        this.id = nextId.incrementAndGet();
        this.name = username;
        this.marks = usermarks.clone();
    }

    static double getaverage(int[] marks) {
        double tot = 0;
        for (int i = 0; i < 3; i++) {
            tot += marks[i];
        }
        return tot / 3;
    }

    @Override
    public String toString() {
        return name + ": " + "[" + marks[0] + "," + marks[1] + "," + marks[2] + "]";
    }

    public String getName() {
        return name;
    }
    public int[] getMarks() {
        return marks;
    }
    public int getId() {
        return id;
    }

}