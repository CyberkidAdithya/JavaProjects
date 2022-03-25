package Proj13;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBfunctions {
    public Connection DB_connect(String DB_name, String DB_user, String DB_pwd) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            String DB_url = "jdbc:postgresql://localhost:5432/";
            conn = DriverManager.getConnection(DB_url + DB_name, DB_user, DB_pwd);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Connected to DB");
            return conn;
        }
    }
}
