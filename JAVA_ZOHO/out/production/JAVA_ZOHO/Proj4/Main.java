package Proj4;	// if Editor == Sublime: Comment this line

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    static Map<String, User> userlist = new HashMap<>();    // unique usernames

    public static void showsorteduserlist()
    {
        TreeMap<String, User> sorted = new TreeMap<>();
        sorted.putAll(userlist);
        for (Map.Entry<String, User> queryuser : sorted.entrySet())
            System.out.println("Username = " + queryuser.getKey() +
                    "\n\tData = " + queryuser.getValue());
    }

    public static Map<String, String> readHashfile()
    {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader br = null;
        try {
            String filePath = "E:\\Coding\\Dev\\passwords.txt";
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String number = parts[1].trim();
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis(); // Program Start

        // File file_object = new File("E:\\Coding\\Dev\\Inputf.txt");
        // Scanner fscan = new Scanner(file_object);
        // BufferedReader fbr = new BufferedReader(new InputStreamReader(file_object));
        PrintStream ss = System.out;
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dateformat1 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // ss.println("hello world");
        } catch (Exception e) {
            ss.println(e); // ss.println("Some Error occurred");
        }

//        Map<String, String> login_map = readHashfile();

        int choice = 1;
        do {
            try {
                ss.println("Enter your choice: ");
                ss.println("1. Insert new user");
                ss.println("2. Delete existing user");
                ss.println("3. Update existing user");
                ss.println("4. Display users details");
                ss.println("5. Search user by username");
                ss.println("6. Show all users details");
                ss.println("0. Exit");
                choice = scan.nextInt();
                scan.nextLine();    // strip("\t\n")
            } catch (Exception e) {
                System.out.println("Invalid Input :(");
                break;
            }
            switch (choice) {
                case 0: {
                    choice = 0;
                    break;
                }
                case 1: {
                    ss.println("First Name: ");
                    String fname = scan.nextLine();
                    ss.println("Last Name: ");
                    String lname = scan.nextLine();
                    ss.println("User Name: ");
                    String uname = scan.nextLine();
                    ss.println("Password: ");
                    String pwd = scan.nextLine();
                    ss.println("City: ");
                    String city = scan.nextLine();
                    ss.println("Email Address: ");
                    String email = scan.nextLine();
                    ss.println("Join Date: ");
                    String doj = scan.nextLine();

                    User newaccount = new User(fname, lname, uname, pwd, city, email, doj);
                    userlist.put(newaccount.getUname(), newaccount);
                    ss.println(userlist);
                    // user
                    break;
                }
                case 2: {
                    ss.println("Enter Username: ");
                    String uname = scan.nextLine();
                    userlist.remove(uname);
                    break;
                }
                case 3: {
                    ss.println("Username: ");
                    String queryuser = scan.nextLine();
                    if (userlist.containsKey(queryuser)) {
                        ss.println("What to update?");
                        ss.println("1.pwd\t2.city\t3.email");
                        int query2 = scan.nextInt();
                        scan.nextLine();    // strip("\t\n")
                        switch (query2) {
                            case 1: {
                                ss.println("New Password: ");
                                String pwd = scan.nextLine();
                                userlist.get(queryuser).setPwd(pwd);
                                break;
                            }
                            case 2: {
                                ss.println("New City: ");
                                String city = scan.nextLine();
                                userlist.get(queryuser).setCity(city);
                                break;
                            }
                            case 3: {
                                ss.println("New Email Address: ");
                                String email = scan.nextLine();
                                userlist.get(queryuser).setEmail(email);
                                break;
                            }
                            default: {
                                ss.println("Invalid Input");
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    for (Map.Entry<String, User> usr : userlist.entrySet()) {
                        ss.println(
                                usr.getKey() + "-" +
                                        usr.getValue().getFname() + " " +
                                        usr.getValue().getLname() + "-" +
                                        usr.getValue().getEmail()
                        );
                    }
                    break;
                }
                case 5: {
                    ss.println("Username: ");
                    String queryuser = scan.nextLine();
                    if (userlist.containsKey(queryuser)) {
                        ss.println(userlist.get(queryuser).getFullname());
                    } else {
                        ss.println("User not found.");
                    }
                    break;
                }
                case 6: {
//                    ss.println(userlist);
                    showsorteduserlist();
                    break;
                }
                default: {
                    ss.println("Invalid choice :(");
                    break;
                }
            }
        } while (choice != 0);

        long end = System.currentTimeMillis(); // Program End

        // performance testing
        ss.println("\nTime taken to copy in milliseconds: " + (end - start)/1000);
    }
}