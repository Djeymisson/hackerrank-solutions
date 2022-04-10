package thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
 *   Day 28: RegEx, Patterns, and Intro to Databases
 * */
public class TwentyEight {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> gmailUsers = new ArrayList<>();

        IntStream.range(0, n).forEach(nItr -> {
            String[] firstMultipleInput = new String[0];
            try {
                firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            String firstName = firstMultipleInput[0];

            String emailID = firstMultipleInput[1];

            if (emailID.matches("^[a-z.]+@gmail.com$")) gmailUsers.add(firstName);

        });

        Collections.sort(gmailUsers);
        gmailUsers.forEach(System.out::println);

        bufferedReader.close();
    }
}
