package Proj13;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static boolean isAdmin = false;
    static int login_attempts;
    static Scanner scan = new Scanner(System.in);

    public static void admin_login() {
        // todo: Admin Login into the application *****DONE*****
        login_attempts = 0;
        while (login_attempts < 3 && !(isAdmin)) {
            Admin curr_admin = new Admin();
            isAdmin = curr_admin.auth();
            login_attempts++;
//             System.out.println(isSession);      // return value of the login block
        }
        if (!isAdmin) {
            System.out.println("Max login attempts exceeded.");
            System.exit(1);
        }
    }

    public static void main(String[] args) throws SQLException {

        // todo: Connect to the pgsql database
//        /*      // CONNECTION TO THE DATABASE
        Database db = new Database();
        String DB_url = "jdbc:postgresql://localhost:5432/",
                DB_name = "testdb",
                DB_user = "postgres",
                DB_pwd = "tswnciJ-";
        db.connect(DB_url, DB_name, DB_user, DB_pwd);

        admin_login();
        System.out.println(isAdmin);
        // todo: CRUD   *****DONE*****
        db.view_drivers();
        /*      */

 //       /*      // THE CITY GRAPH
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
//        System.out.println(graph);    // DEBUG
        System.out.println(graph.printGraph());
        System.out.println("Done");
        /*      */

    }
}
