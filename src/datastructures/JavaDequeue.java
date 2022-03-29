package datastructures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaDequeue {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/_input_files/javaDequeue-test")); // 94531
        long start = System.currentTimeMillis();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> uniques = new HashSet<>(deque);
        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.addFirst(num);
            uniques.add(num);

            if (deque.size() == m) {
                maxUnique = Math.max(uniques.size(), maxUnique);

                int removed = deque.removeLast();

                if (!deque.contains(removed))
                    uniques.remove(removed);
            }
        }

        maxUnique = Math.max(uniques.size(), maxUnique);
        System.out.println(maxUnique);

        long end = System.currentTimeMillis();
        System.out.println("Time passed: " + (end - start) / 1000.0);
        in.close();
    }
}

