package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
public class Subarrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = scanner.nextInt();

        while (n > 0) {
            arr.add(scanner.nextInt());
            n--;
        }

        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size()+1; j++) {
                if (arr.subList(i, j).stream().reduce(0, (prev, curr) -> prev + curr) < 0)
                    count++;
            }
        }

        System.out.println(count);
    }
}