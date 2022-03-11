package Proj7;

import java.util.*;

public class myServer {
    public volatile int controlFlow = 1;
    private static int count = 1;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Thread t1 = new Thread(new Session());
        t1.setName("player1");
//        t1.setDaemon(true);
        t1.start();
        Thread t2 = new Thread(new Session());
        t2.setName("player2");
        t2.start();

//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException err) {
//            System.out.println("Error: " + err);
//        }

    }
}
