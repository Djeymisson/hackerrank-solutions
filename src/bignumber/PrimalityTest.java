package bignumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PrimalityTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger pInteger = new BigInteger(n);

        System.out.println(pInteger.isProbablePrime(1) ? "prime" : "not prime");

        bufferedReader.close();
    }
}
