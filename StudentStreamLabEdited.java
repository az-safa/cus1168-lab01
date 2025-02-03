package cus1168;

import java.util.*;
import java.util.stream.*;


public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TASK 1: Filtering: Students with GPA > 3.0
        List<Student> highGpaStudents = students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0:");
        highGpaStudents.forEach(System.out::println);

        // TASK 2: Mapping: Extract names of students with GPA > 3.0
        List<String> highGpaNames = highGpaStudents.stream()
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("\nHigh GPA student names:");
        highGpaNames.forEach(System.out::println);

        // TASK 3: Reducing: Calculate the average GPA of all students
        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage GPA: %.2f\n", averageGpa);

        // TASK 4Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
                .filter(s -> s.getCollegeYear().equals("Junior"))
                .collect(Collectors.toList());

        System.out.println("\nJuniors:");
        juniors.forEach(System.out::println);
    }
}
