package bignumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaBigDecimal {

    public static void main(String[] args) throws FileNotFoundException {
        //Input
        Scanner sc = new Scanner(new File("src/_input_files/bigdecimals-tests"));
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, Collections.reverseOrder((o1, o2) -> {
            if(o1 == null || o2 == null)
                return o1 == null ? -1 : 1;

            return new BigDecimal(o1).compareTo(new BigDecimal(o2));
        }));

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}
