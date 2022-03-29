package strings;

public class SubstringComparisons {

    // https://www.hackerrank.com/challenges/java-string-compare/problem
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        String substring = "";
        for (int i = 0; i + k <= s.length(); i++) {
            substring = s.substring(i, i + k);
            if (smallest.equals("") || smallest.compareTo(substring) >= 0)
                smallest = substring;
            if (largest.compareTo(substring) <= 0)
                largest = substring;
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 1));
    }
}
