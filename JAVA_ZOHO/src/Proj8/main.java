package Proj8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static String searchstring = "";
    String query_filename = "";
    String indentation2 = "";
    String indentation1 = "";
    static boolean foundstringflag = false;

//    private void readDirectory(File directory) {    // recursive DFS
//        if (foundstringflag) {
//            return;
//        }
//        if (directory.isDirectory()) {
//            System.out.println("Subdirectory found: " + directory.getName());
//            File[] directoryListing = directory.listFiles();
//            if (directoryListing != null) {
//                for (File subdirectory : directoryListing) {
//                    if (myServer.stop_searching) {
//                        break;
//                    }
//                    if (subdirectory.isDirectory()) {   // directory found
//                        indentation2 += "\t";
//                        this.readDirectory(subdirectory);
//                    } else {    // file found
////                        System.out.println("Sub file found");
//                        System.out.println(indentation2 + subdirectory.getName());
//                        if (subdirectory.getName().equals(query_filename)) {
//                            myServer.stop_searching = true;
//                            System.out.println("File found by: " + Thread.currentThread().getName());
//                        }
//                    }
//                }
//            }
//        } else {
//            indentation1 = indentation2;
//            if (directory.getName().equals(query_filename)) {
//                myServer.stop_searching = true;
//                System.out.println("File found by: " + Thread.currentThread().getName());
//            } else {
//                ;   // System.out.println("Invalid Directory?! : " + directory);
//            }
//        }
//        indentation2 = indentation1;
//    }

    public static void SearchIn(Path path) {
        try {
//            System.out.println("#DEBUG PATH: " + path);
            String text = main.searchstring;    // create a deepcopy
            List<String> texts = Files.readAllLines(path);
            foundstringflag = false;
            for (int i = 0; i < texts.size(); i++) {
                String str = texts.get(i);
                if (str.contains(text)) {
                    System.out.println("Found \"" + text + "\" in " + path.getFileName() + " at line : " + (i + 1) + " from thread : " + Thread.currentThread().getName());
                    foundstringflag = true;
                }
            }
            if (!foundstringflag) {
                System.out.println("\"" + text + "\" not found in " + path.getFileName() + " through thread : " + Thread.currentThread().getName());
            }
        } catch (IOException e) {
            System.out.println("Error while reading " + path.getFileName());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter string to search: ");
        searchstring = scan.nextLine();

        //creating object of our thread class
        SearchBot searchBot = new SearchBot();

        //getting the number of files in the folder
        int numberOfFiles = searchBot.listOfFiles.size() - 1;

        //if the folder doesn't contain any file at all
        if (numberOfFiles == 0) {
            System.out.println("No file found in the folder");
            return;     // System.exit(0);
        }

        List<Thread> listOfThreads = new ArrayList<>();
        // get the no. of available processors
        int coreCount = Runtime.getRuntime().availableProcessors();
//        System.out.println("Cores: " + coreCount);  // 8
        final ExecutorService service = Executors.newFixedThreadPool(coreCount);

        for (int i = 0; i < numberOfFiles; i++) {
//            Thread bot = new Thread(searchBot);
//            bot.start();
            service.execute(searchBot);
        }

        service.shutdown();     // stop all threads once tasks done

    }

}