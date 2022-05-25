package certificationstests.stringdecoder;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Result {
    private Result() {
    }

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */
    public static String decryptMessage(String encryptedMessage) {
        List<String> split = Arrays.asList(encryptedMessage.split(" "));

        for (String s : split) {
            Pattern r = Pattern.compile("[a-z]\\d");
            Matcher m = r.matcher(s);

            String decoded = s;
            while (m.find()) {
                String match = m.group(0);

                StringBuilder expanded = new StringBuilder();
                for (int i = 0; i < Character.getNumericValue(match.charAt(1)); i++)
                    expanded.append(match.charAt(0));

                decoded = decoded.replace(match, expanded.toString());
            }

            int index = split.indexOf(s);
            split.set(index, decoded);
        }

        Collections.reverse(split);
        return String.join(" ", split);
    }

}

// input: a3b4q2i abcd2 abc
// expected output: abc abcdd aaabbbbqqi
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
