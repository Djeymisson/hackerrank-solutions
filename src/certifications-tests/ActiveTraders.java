package tests;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class ActiveTradersLogic {

    private ActiveTradersLogic() {
        throw new UnsupportedOperationException();
    }

    public static List<String> mostActive(List<String> customers) {
        Map<String, Integer> customerFrequency = new TreeMap<>();
        List<String> bigCustomers = new ArrayList<>();

        double fivePercent = customers.size() * (5 / 100.0);

        for (String s : customers) {
            if (customerFrequency.containsKey(s)) {
                int count = customerFrequency.get(s);
                customerFrequency.put(s, ++count);
            } else {
                customerFrequency.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : customerFrequency.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= fivePercent)
                bigCustomers.add(key);
        }

        return new ArrayList<>(bigCustomers);

    }
}

public class ActiveTraders {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("src/_input_files/activetraders-test"));

        int customersCount = Integer.parseInt(scan.nextLine().trim());

        List<String> customers = IntStream.range(0, customersCount).mapToObj(i -> scan.nextLine()).collect(toList());

        long start = System.nanoTime();
        List<String> result = ActiveTradersLogic.mostActive(customers);
        long end = System.nanoTime();

        System.out.println(String.join("\n", result) + "\n");
        System.out.printf("Time of execution: %f%n", (double) (end - start) / 1000000);

        scan.close();
    }
}