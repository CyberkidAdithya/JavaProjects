package Proj12;

import java.sql.*;

public class Main {
    public static void main(String args[]) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + "testdb", "postgres", "tswnciJ-");
//            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();

            String sql = null;

//            sql = "INSERT INTO testschema.testtable (name) "
//                    + "VALUES ('Swarna');";
//            stmt.executeUpdate(sql);
//
//            sql = "INSERT INTO testschema.testtable (name) "
//                    + "VALUES ('Daniel');";
//            stmt.executeUpdate(sql);

            sql = "DELETE FROM testschema.testtable "
                    + "WHERE ID >= 4";
            stmt.executeUpdate(sql);

        } catch (Exception err) {
            err.printStackTrace();
            System.err.println(err.getClass().getName() + ": " + err.getMessage());
            System.exit(0);
        } finally {
            stmt.close();
//            conn.commit();
//            conn.close();
        }
        System.out.println("Records created successfully");

        String curr_query = "SELECT * FROM testschema.testtable";
        PreparedStatement stmt2 = conn.prepareStatement(curr_query);
        ResultSet rs = stmt2.executeQuery();
        System.out.println(rs);

        conn.close();
    }
}