package Proj7;

import java.io.File;
import java.lang.Thread;

class Session implements Runnable {
    String current_directory = null;
    String indentation2 = "";
    String indentation1 = "";
    String query_filename = "";

    Session() {
        String current_search_state = (!myServer.stop_searching) ? "Searching" : "Not Searching";
//        System.out.println(Thread.currentThread().getName() + " thread created!");
        System.out.println("Current Search State: " + current_search_state);
    }

    private void readDirectory(File directory) {    // recursive DFS
        if (myServer.stop_searching) {
            return;
        }
        if (directory.isDirectory()) {
            System.out.println("Subdirectory found: " + directory.getName());
            File[] directoryListing = directory.listFiles();
            if (directoryListing != null) {
                for (File subdirectory : directoryListing) {
                    if (myServer.stop_searching) {
                        break;
                    }
                    if (subdirectory.isDirectory()) {   // directory found
                        indentation2 += "\t";
                        this.readDirectory(subdirectory);
                    } else {    // file found
//                        System.out.println("Sub file found");
                        System.out.println(indentation2 + subdirectory.getName());
                        if (subdirectory.getName().equals(query_filename)) {
                            myServer.stop_searching = true;
                            System.out.println("File found by: " + Thread.currentThread().getName());
                        }
                    }
                }
            }
        } else {
            indentation1 = indentation2;
            if (directory.getName().equals(query_filename)) {
                myServer.stop_searching = true;
                System.out.println("File found by: " + Thread.currentThread().getName());
            } else {
                ;   // System.out.println("Invalid Directory?! : " + directory);
            }
        }
        indentation2 = indentation1;
    }

    public void run() {
        this.query_filename = myServer.userfilename;

//        System.out.println("Directory: " + current_directory);

        File curr_dir = new File(current_directory);
//        readDirectory(curr_dir);
        File[] curr_dir_list = curr_dir.listFiles();
        if (curr_dir_list != null) {
            for (File curr_dir_file : curr_dir_list) {
                readDirectory(curr_dir_file);   // TODO: make this for loop as a thread
            }
        } else {
            return;
        }
    }
}
//thread creation using extends: Session t1=new Session(threadname);

//thread creation using runnable: Thread t1 = new Thread(new Session(threadname));
