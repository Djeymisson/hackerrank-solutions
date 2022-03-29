package strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/_input_files/tags-tests"));
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            boolean anyMatch = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)<\\/\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                anyMatch = true;
            }

            if(!anyMatch)
                System.out.println("None");

            testCases--;
        }
        in.close();
    }
}
