package datastructures;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/*
* Given 2 BitSets, b1 and b2, of size N where all bits in both BitSets are initialized to 0, perform a series of M operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.
* */
public class JavaBitSet {

    private static void doOp(String op, int m1, int m2, List<BitSet> bitSets) {
        if (op.equals("SET")) {
            bitSets.get(m1 - 1).set(m2);
            return;
        }

        if (op.equals("FLIP")) {
            bitSets.get(m1 - 1).flip(m2);
            return;
        }

        doSetToSetOp(bitSets.get(m1 - 1), bitSets.get(m2 - 1), op);
    }

    private static void doSetToSetOp(BitSet left, BitSet right, String op) {
        switch (op) {
            case "AND":
                left.and(right);
                return;
            case "OR":
                left.or(right);
                return;
            case "XOR":
                left.xor(right);
                return;
            default:
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        List<BitSet> bitSets = Arrays.asList(new BitSet(n), new BitSet(n));

        while (m-- > 0) {
            String op = scan.next();
            int m1 = scan.nextInt();
            int m2 = scan.nextInt();

            doOp(op, m1, m2, bitSets);

            System.out.printf("%d %d%n", bitSets.get(0).cardinality(), bitSets.get(1).cardinality());
        }

        scan.close();
    }

}
