package thirtydaycode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySix {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        StringBuilder evens;
        StringBuilder odds;

        int t = scan.nextInt();
        while (t > 0){
            inputs.add(scan.next());
            t--;
        }

        for (String s : inputs) {
            evens = new StringBuilder("");
            odds = new StringBuilder("");
            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) % 2 == 0)
                    evens.append(s.charAt(i));
                else
                    odds.append(s.charAt(i));
            }
            System.out.printf("%s %s%n", odds, evens);
        }
    }

}
