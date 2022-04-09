package thirtydaysofcode;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
 *   Day 26: Nested Logic
 * */
public class TwentySix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> returnedAt = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        List<Integer> dueDate = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());

        System.out.println(calculateFine(returnedAt, dueDate));

        scanner.close();
    }

    private static int calculateFine(List<Integer> returnedAt, List<Integer> dueDate) {

        final LocalDate returned = LocalDate.of(returnedAt.get(2), returnedAt.get(1), returnedAt.get(0));
        final LocalDate due = LocalDate.of(dueDate.get(2), dueDate.get(1), dueDate.get(0));

        if (returnedAt.equals(dueDate) || returned.isBefore(due)) return 0;

        if (returned.getYear() > due.getYear()) return 10000;

        if (returned.getMonthValue() > due.getMonthValue())
            return (returned.getMonthValue() - due.getMonthValue()) * 500;

        return (returned.getDayOfMonth() - due.getDayOfMonth()) * 15;

    }

}
