package strings;

import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] charsMap = new int[256];

        for (char c : a.toLowerCase().toCharArray())
            charsMap[c]++;

        for (char c : b.toLowerCase().toCharArray())
            charsMap[c]--;

        for (int i : charsMap)
            if (i != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        //Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();

        long start = System.nanoTime();
        isAnagram(a, b);
        long end = System.nanoTime();
        System.out.printf("Time of execution: %d%n", (end - start));

        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

}