package Proj7;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class myServer {

    public volatile static boolean stop_searching = false;
    public static String curr_path = "E:\\MyMedia\\MyDocuments";
    public static String userfilename;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bot_count = 1;

        System.out.println("Enter filename to search: ");
        userfilename = scan.nextLine();

        // I have made constructor for my Thread Class
        // it will set a name for my new thread object
        File initial_dir = new File(curr_path);
        File[] thread_routes = initial_dir.listFiles();
        if (thread_routes != null)  {
            for (File thread_route : thread_routes) {
                System.out.println(thread_route);
//                System.out.println("DEBUG BOT COUNT: " + bot_count);
                Thread t1 = new Thread(new Session(), "bot " + bot_count);
                curr_path = thread_route.toString();
                t1.start();
                System.out.println(">>>> " + t1.getName() + " started searching " + thread_route);
                bot_count++;
            }
        }
    }
}



/*

//    public volatile int controlFlow = 1;
//    private static int count = 1;

//    Thread t1 = new Thread(new Session());
//    t1.setName("bot");  //  t1.setDaemon(true);

//        Thread t2 = new Thread(new Session());
//        t2.setName("player2");
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException err) {
//            System.out.println("Error: " + err);
//        }

 */