package datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
public class OneDArrayP2 {

    public static boolean canWin(int leap, int[] game) {
        return tryMoves(0, leap, game);
    }

    public static boolean tryMoves(int i, int leap, int[] arr) {
        if (i >= arr.length || (i == (arr.length - 1) && arr[i] == 0))
            return true;
        if (i < 0 || arr[i] != 0)
            return false;

        arr[i] = 1; // marks where it has been at

        return tryMoves(i + leap, leap, arr)
                || tryMoves(i + 1, leap, arr)
                || tryMoves(i - 1, leap, arr);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<int[], String> mapGameResult = new HashMap<>();

        try (Scanner scan = new Scanner(new File("src/_input_files/oneDArrayP2-test"));
             Scanner scanEO = new Scanner(new File("src/_input_files/oneDArrayP2-test-expected-output"))) {

            int q = scan.nextInt();
            while (q-- > 0) {
                int n = scan.nextInt();
                int leap = scan.nextInt();

                int[] game = new int[n];
                for (int i = 0; i < n; i++) {
                    game[i] = scan.nextInt();
                }

                mapGameResult.put(game, scanEO.nextLine());

                System.out.printf("line: %d; expected: %s; got it: %s; %n",
                        (5000 - q) * 2, // line
                        mapGameResult.get(game), // expected output
                        (canWin(leap, game)) ? "YES" : "NO"); // output result

            }
        }

    }

}
