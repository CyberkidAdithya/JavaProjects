package Proj7;

public class myServer {
    public volatile int controlFlow = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Session());
        t1.setName("player1");
//        t1.setDaemon(true);
        t1.start();
//        Thread t2 = new Thread(new Session());
//        t2.setName("player2");
//        t2.start();
    }
}
