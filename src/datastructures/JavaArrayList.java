package datastructures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-arraylist/problem?isFullScreen=true
public class JavaArrayList {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream("src/_input_files/arrayList-test"));

        List<List<Integer>> multiArr = new ArrayList<>();

        int n = scan.nextInt();
        while (n > 0) {
            int d = scan.nextInt();
            List<Integer> dS = new ArrayList<>();
            while (d > 0) {
                dS.add(scan.nextInt());
                d--;
            }

            multiArr.add(dS);
            n--;
        }

        for (List<Integer> integers : multiArr) {
            System.out.println(integers);
        }

        int q = scan.nextInt();
        while (q > 0) {
            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;

            if (x >= multiArr.size() || y >= multiArr.get(x).size() || multiArr.get(x).isEmpty())
                System.out.println("ERROR!");
            else
                try {
                    System.out.println(multiArr.get(x).get(y));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(x + " " + y);
                }

            q--;
        }

        scan.close();
    }
}
