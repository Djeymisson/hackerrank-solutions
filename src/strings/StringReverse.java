package strings;

import java.time.LocalDate;
import java.util.Scanner;

public class StringReverse {

    public static String checkIfPalindrome(String A){
        for (int i = 0; i < A.length() / 2; i++) {
            if(A.charAt(i) != A.charAt(A.length()-1-i)){
                return "No";
            }
        }
        return "Yes";
    }

    public static String checkIfPalindrome2(String A){
        String result = "Yes";
        for (int i = 0; i < A.length() / 2; i++) { // needs to iterate only till half string
            if(A.charAt(i) != A.charAt(A.length()-1-i)){
                result = "No";
                break;
            }
        }
        return result;
    }

    public static String checkIfPalindrome3(String A){
        return A.equals(new StringBuilder(A).reverse().toString()) ? "Yes" : "No";
    }

    // Checks if is palindrome
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        /* Enter your code here. Print output to STDOUT. */
        long start = System.nanoTime();
        System.out.println(checkIfPalindrome(A));
        long end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end-start));

        start = System.nanoTime();
        System.out.println(checkIfPalindrome2(A));
        end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end-start));

        start = System.nanoTime();
        System.out.println(checkIfPalindrome3(A));
        end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end-start));


    }
}
