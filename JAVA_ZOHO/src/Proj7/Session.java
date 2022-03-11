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

//thread creation using extends: Session t1=new Session(threadname);

class Session implements Runnable {
    private volatile int count = 0;

    public void run() {
        while (count++ < 10) {
            System.out.println(Thread.currentThread().getName() + ": " + count);
            try {
                Thread.sleep(100);  // static method of Thread Class
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//thread creation using runnable: Thread t1 = new Thread(new Session(threadname));

    private void stop() {
        this.setCount(10);
    }

    public void setCount(int xx) {
        this.count = xx;
    }

}
