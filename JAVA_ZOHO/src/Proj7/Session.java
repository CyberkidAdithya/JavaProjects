package Proj7;

import java.lang.Thread;

//class Session extends Thread {
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Current: " + i);
//            try {
//                Thread.sleep(100);  // static method of Thread Class
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

class Session implements Runnable {
    public void run() {
        System.out.println("Active Thread Count: " + Thread.activeCount() + Thread.currentThread().getName());
        try {
            Thread.sleep(100);  // static method of Thread Class
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
