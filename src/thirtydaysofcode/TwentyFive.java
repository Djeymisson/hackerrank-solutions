package thirtydaysofcode;

import java.util.Scanner;

public class TwentyFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            System.out.println(isPrime(n) ? "Prime" : "Not prime");
        }
    }

    private static boolean isPrime(int n) {

        if (n == 2) return true;
        if (n == 1 || (n & 1) == 0) return false;

        int i = 3;
        while (i <= Math.sqrt(n)) {
            if ((n % i) == 0) return false;
            i += 2;
        }

        return true;
    }

}
