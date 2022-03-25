package Proj13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            CRUD
         */

        /*      // CONNECTION TO THE DATABASE
        Scanner scan = new Scanner(System.in);
        String DB_url = "jdbc:postgresql://localhost:5432/",
                DB_name = "postgres",
                DB_user = "postgres",
                DB_pwd = "";
        System.out.println("Database: " + "testdb");
        System.out.println("Username: " + "postgres");
        System.out.println("Enter your Password: ");
        String cur_ses_pwd = scan.nextLine();
        DBfunctions db = new DBfunctions();
        db.DB_connect("testdb", "postgres", cur_ses_pwd);
        /*      */

//        /*      // THE CITY GRAPH
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
