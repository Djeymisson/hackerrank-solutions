package thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Result {
    private Result() { }

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */

    public static int bitwiseAnd(int n, int k) {
        int endSet = n + 1;
        return IntStream.range(1, endSet).reduce(0, (p, c) -> IntStream.range(c + 1, endSet).reduce(p, (p1, c1) -> ((c & c1) < k) ? Math.max((c & c1), p1) : p1));
    }

}

public class TwentyNine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int count = Integer.parseInt(firstMultipleInput[0]);

                int lim = Integer.parseInt(firstMultipleInput[1]);

                int res = Result.bitwiseAnd(count, lim);

                System.out.println(res);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        bufferedReader.close();
    }
}

