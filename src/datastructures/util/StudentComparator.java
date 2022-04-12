package datastructures.util;

public class StudentComparator {
    private StudentComparator() { }

    public static int compareStudents(Student s1, Student s2) {
        if (s1.getCgpa() != s2.getCgpa()) return Double.compare(s2.getCgpa(), s1.getCgpa());
        else if (!s1.getName().equals(s2.getName())) return s1.getName().compareTo(s2.getName());
        else return Integer.compare(s1.getId(), s2.getId());
    }
}
