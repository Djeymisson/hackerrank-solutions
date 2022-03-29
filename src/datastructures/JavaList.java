package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<Integer> l = new ArrayList<>();
        while (n-- > 0) {
            l.add(scan.nextInt());
        }

        int q = scan.nextInt();
        while (q-- > 0) {
            String op = scan.next();
            int x = scan.nextInt();
            int y;
            if (op.equals("Insert")) {
                y = scan.nextInt();
                l.add(x, y);
            } else if (op.equals("Delete")) {
                l.remove(x);
            }
        }

        scan.close();

        for (Integer i : l) {
            System.out.printf("%d ", i);
        }
    }
}
