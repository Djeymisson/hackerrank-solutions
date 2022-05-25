package advanced.sha256;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            m.update(s.getBytes(), 0, s.length());
            System.out.printf("%064x%n", new BigInteger(1, m.digest()));
        }
    }
}
