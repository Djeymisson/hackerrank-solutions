package datastructures;

import datastructures.util.Student;
import datastructures.util.StudentComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Priorities Class
 *
 * Students will be prioritized as follows:
 *  > The student having the highest Cumulative Grade Point Average (CGPA) is served first.
 *  > Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
 *  > Any students having the same CGPA and name will be served in ascending order of the id.
 *
 */
class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>(StudentComparator::compareStudents);

        events.forEach(e -> {
            String[] event = e.split(" ");

            if (event[0].equals("ENTER"))
                priorityQueue.offer(new Student(Integer.parseInt(event[3]), event[1], Double.parseDouble(event[2])));
            else priorityQueue.poll();
        });

        List<Student> leftovers = new ArrayList<>();
        while (!priorityQueue.isEmpty()) leftovers.add(priorityQueue.poll());
        return leftovers;
    }
}


public class JavaPriorityQueue {
    private static final Scanner scan = new Scanner(System.in);
    private static final Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (datastructures.util.Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}