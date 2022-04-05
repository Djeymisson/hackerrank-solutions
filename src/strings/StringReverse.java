package strings;

import java.util.Scanner;

public class StringReverse {

    public static String checkIfPalindrome(String a) {
        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                return "No";
            }
        }
        return "Yes";
    }

    public static String checkIfPalindrome2(String a) {
        return a.equals(new StringBuilder(a).reverse().toString()) ? "Yes" : "No";
    }

    // Checks if is palindrome
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        /* Enter your code here. Print output to STDOUT. */
        long start = System.nanoTime();
        System.out.println(checkIfPalindrome(a));
        long end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end - start));

        start = System.nanoTime();
        System.out.println(checkIfPalindrome2(a));
        end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end - start));

    }
}
