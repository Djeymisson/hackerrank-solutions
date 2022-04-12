package datastructures;

import datastructures.util.Student;
import datastructures.util.StudentComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Complete the code
public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(StudentComparator::compareStudents);

        for (Student st : studentList) {
            System.out.println(st.getName());
        }

        in.close();
    }
}



