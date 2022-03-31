package Proj13;

import java.sql.*;

public class Database {
    static Connection conn = null;
    public Connection connect(String DB_url, String DB_name, String DB_user, String DB_pwd) {
        try {
            conn = DriverManager.getConnection(DB_url + DB_name, DB_user, DB_pwd);
        } catch (Exception err) {
            System.out.println(err);
        } finally {
            System.out.println("Current Session Database: " + "testdb");
            System.out.println("Current Session Username: " + "postgres");
//            System.out.printf("LOGIN SUCCESS: %s connected to the database %s", DB_user, DB_name);
            return conn;
        }
    }

    public static void view_drivers() throws SQLException {
        String query = "SELECT * FROM driver;";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int driver_id = rs.getInt("id");
                String driver_name = rs.getString("name");
                int driver_current_cab_id = rs.getInt("current_cab_id");
                boolean isAvailable = rs.getString("isavailable").equals("yes");
                System.out.println(driver_id + ". " + driver_name + ", [" + driver_id +
                        "] " + "| Status: " + (isAvailable ?  "Free" : "Not Free"));
            }
        } catch (SQLException err) {
            System.out.println(err);
        }
    }

    public static void assign_trip() throws SQLException {

    }
}
