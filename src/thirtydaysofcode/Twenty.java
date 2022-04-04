package thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
 *   Day 20: Sorting (Bubble Sort)
 * */
public class Twenty {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.printf("Array is sorted in %d swaps.%n", bubbleSort(a, n));
        System.out.printf("First Element: %d%n", a.get(0));
        System.out.printf("Last Element: %d%n", a.get(n - 1));

        bufferedReader.close();
    }

    public static int bubbleSort(List<Integer> arr, int size) {
        int totalNumOfSwaps = 0;

        for (int i = 0; i < size; i++) {
            int numOfSwaps = 0;

            for (int j = 0; j < size - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(j, j + 1, arr);
                    numOfSwaps++;
                }
            }

            if (numOfSwaps == 0) break;
            totalNumOfSwaps += numOfSwaps;
        }

        return totalNumOfSwaps;
    }

    public static void swap(int i, int j, List<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
