package advanced.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            System.out.println(new BigInteger(1, m.digest()).toString(16));
        }
    }
}