package Proj11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) throws PatternSyntaxException {
        /*
        X* -    count(X) >= 0
        X+ -    count(X) >= 1
        X? -    count(X) = 0/1
         */

//        Pattern pattern = Pattern.compile("c*k+i?d");
        Pattern pattern = Pattern.compile(".ki.");
        System.out.println(pattern);

//        String txt = "ckidcckidkckidickiddckid";
        String txt = "Ackidle Potackidto";
        Matcher x = pattern.matcher(txt);
//        txt = x.replaceAll("x");
        System.out.println(txt);
        int count = 0;
        ArrayList arr = new ArrayList();
        while (x.find()) {
            count += 1;
            String subs = txt.substring(x.start(), x.end());
            arr.add(subs);
            txt = x.replaceFirst("x");
            x = pattern.matcher(txt);
        }

        System.out.println(count + ": " + arr);

    }
}
