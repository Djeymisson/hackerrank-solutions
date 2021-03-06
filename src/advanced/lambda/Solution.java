package advanced.lambda;

import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return n -> (n & 1) != 0;
    }

    public PerformOperation isPrime() {
        return n -> {
            if (n == 2) return true;
            if (n == 1 || (n & 1) == 0) return false;

            int i = 3;
            while (i <= Math.sqrt(n)) {
                if ((n % i) == 0) return false;
                i += 2;
            }

            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return n -> {
            String a = String.valueOf(n);
            for (int i = 0; i < a.length() / 2; i++)
                if (a.charAt(i) != a.charAt(a.length() - 1 - i)) return false;

            return true;
        };
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (t-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

