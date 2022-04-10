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

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> gmailUsers = new ArrayList<>();

        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];

                if (emailID.matches("^[a-z.]+@gmail.com$")) {
                    gmailUsers.add(firstName);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Collections.sort(gmailUsers);
        gmailUsers.forEach(System.out::println);

        bufferedReader.close();
    }
}
