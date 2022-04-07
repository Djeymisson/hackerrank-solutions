package thirtydaysofcode;

import java.util.Scanner;

public class TwentyFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            System.out.println(checkPrimality(n) ? "Prime" : "Not prime");
        }
    }

    private static boolean checkPrimality(int n) {
        int i = 2;
        while (i <= Math.sqrt(n))
            if ((n % i++) < 1) return false;
        return n > 1;
    }

}
