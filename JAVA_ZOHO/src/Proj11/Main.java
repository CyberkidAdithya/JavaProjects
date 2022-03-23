 package Proj11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) throws PatternSyntaxException, IOException {

        // Pattern pattern = Pattern.compile("c*k+i?d");
        // (0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.]\\d{4}
        // (?m)^.*?Exception.*(?:\\R+^\\s*at .*)+
        String regex = "(?m)^(?:\\S+?Exception|\\h+at )";
        Pattern pattern = Pattern.compile(regex);
        // System.out.println("DEBUG" + pattern);

        String abs_File_name = "catalina0.txt";
        List<String> texts = Files.readAllLines(Paths.get(abs_File_name));
        // System.out.println("DEBUG" + texts);

        int count = 0;
        for (String text : texts) {
            Matcher x = pattern.matcher(text);
            if (x.find()) {
                System.out.println(count++ + ".\t" + text);
            }
        }

//        String txt = "ckidcckidk 06-12-2021 ckid[06-12-2021]ickiddckid";
//        String txt = "Ackidle Potackidto";
//        txt = x.replaceAll("x");
//        int count = 0;
//        ArrayList arr = new ArrayList();
//        while (x.find()) {
//            count += 1;
//            String subs = txt.substring(x.start(), x.end());
//            arr.add(subs);
//        }


    }
}

