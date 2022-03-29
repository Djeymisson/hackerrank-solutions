package strings;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        // Write your code here.
        if (s.isEmpty() || s.isBlank()) {
            System.out.println(0);
        } else if (s.length() <= 400000) {
            s = s.replaceAll("[^\\p{Alpha}]+", " ");
            List<String> matches = Arrays.asList(s.trim().split("\\p{Space}+"));

            System.out.println(matches.size());
            for (String token : matches)
                System.out.println(token);
        }

        scan.close();
    }
}
