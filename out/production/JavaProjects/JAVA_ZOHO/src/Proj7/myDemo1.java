package Proj7;

import java.lang.*;

// class MyThread0 extends Thread {
class myDemo1 implements Runnable {
    int beg, end;
    myDemo1(int xx, int yy) {     // constructor
        this.beg = xx;
        this.end = yy;
    }
    public void run() {     // overriding run method
        for (int i = beg; i < end; i++) {
            System.out.println("Thread: " + Thread.currentThread().getId());
        }
    }
}