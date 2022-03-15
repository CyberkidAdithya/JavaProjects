package Proj8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//class used for thread
public class SearchBot implements Runnable {

    int file_index = 0;
    static String file_path = "E:\\MyMedia\\MyDocuments\\testing\\dir1\\subdir1b";
    Stream<Path> streamOfFiles = Files.walk(Paths.get(file_path));
    List<Path> listOfFiles = streamOfFiles.collect(Collectors.toList());

    public SearchBot() throws IOException {
//        System.out.println("DEBUG FILE LIST: " + listOfFiles);
        ;   // System.out.println("Invalid Directory Given!");
    }

    @Override
    public void run() {
        file_index++;  // to access indexes of list
        // file[counter].find(searchstring)
        main.SearchIn(listOfFiles.get(file_index));
    }
}
