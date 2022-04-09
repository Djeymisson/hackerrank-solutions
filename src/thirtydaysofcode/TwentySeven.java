package thirtydaysofcode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Day 27: Testing
 *
 * Complete the following methods.
 * In the class TestDataEmptyArray:
 * > get_array() returns an empty array
 *
 * In the class TestDataUniqueValues:
 * > get_array() returns an array of size at least 2 with all unique elements
 * > get_expected_result() returns the expected minimum value index for this array
 *
 * In the class TestDataExactlyTwoDifferentMinimums:
 * > get_array() returns an array where the minimum value occurs at exactly 2 indices
 * > get_expected_result() returns the expected index
 *
 * Take a look at the code template to see the exact implementation of functions that your colleague already implemented.
 *
 * */
public class TwentySeven {

    public static int minimumIndex(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int minIdx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void testWithEmptyArray() {
        try {
            int[] seq = TestDataEmptyArray.getArray();
            minimumIndex(seq);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Exception wasn't thrown as expected");
    }

    public static void testWithUniqueValues() {
        int[] seq = TestDataUniqueValues.getArray();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        final List<Integer> tmp = Arrays.stream(seq).boxed().collect(Collectors.toList());

        if ((new LinkedHashSet<Integer>(tmp)).size() != seq.length) {
            throw new AssertionError("not all values are unique");
        }

        int expectedResult = TestDataUniqueValues.getExpectedResult();
        int result = minimumIndex(seq);
        if (result != expectedResult) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void testWithExactlyTwoDifferentMinimums() {
        int[] seq = TestDataExactlyTwoDifferentMinimums.getArray();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        int[] tmp = seq.clone();
        Arrays.sort(tmp);
        if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
            throw new AssertionError("there are not exactly two minimums in the array");
        }

        int expectedResult = TestDataExactlyTwoDifferentMinimums.getExpectedResult();
        int result = minimumIndex(seq);
        if (result != expectedResult) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void main(String[] args) {
        testWithEmptyArray();
        testWithUniqueValues();
        testWithExactlyTwoDifferentMinimums();
        System.out.println("OK");
    }

    static class TestDataEmptyArray {
        public static int[] getArray() {
            return new int[0];
        }
    }

    static class TestDataUniqueValues {
        static final int MIN_INDEX = 1;
        static int[] arr = {49, 13, 26};

        public static int[] getArray() {
            return arr;
        }

        public static int getExpectedResult() {
            return MIN_INDEX;
        }
    }

    static class TestDataExactlyTwoDifferentMinimums {
        static final int MIN_INDEX = 1;
        static int[] arr = {49, 7, 7};

        public static int[] getArray() {
            return arr;
        }

        public static int getExpectedResult() {
            return MIN_INDEX;
        }
    }
}
