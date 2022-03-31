// package Competitive;

import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            String DB_url = "jdbc:postgresql://localhost:5432/",
                   DB_name = "testdb",
                   DB_user = "postgres",
                   DB_pwd = "tswnciJ-";
            c = DriverManager.getConnection(DB_url + DB_name, DB_user, DB_pwd);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
