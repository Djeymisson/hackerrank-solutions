package strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegexIPAdress {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/_input_files/ip-tests"));
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in.close();
    }

}

class MyRegex {
    public final String pattern = "^((2(5[0-5]|[0-4]\\d)|[01]?\\d{1,2})\\.){3}(2(5[0-5]|[0-4]\\d)|[01]?\\d{1,2})$";
}