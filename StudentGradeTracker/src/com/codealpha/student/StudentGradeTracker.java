package com.codealpha.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                System.out.print("Enter marks: ");
                int marks = scanner.nextInt();

                students.add(new Student(name, marks));
                System.out.println("Student added successfully!");

            } else if (choice == 2) {
                if (students.isEmpty()) {
                    System.out.println("No student data available.");
                    continue;
                }

                int total = 0;
                int highest = Integer.MIN_VALUE;
                int lowest = Integer.MAX_VALUE;

                System.out.println("\n--- Student Report ---");
                for (Student s : students) {
                    System.out.println(s.getName() + " : " + s.getMarks());
                    total += s.getMarks();
                    highest = Math.max(highest, s.getMarks());
                    lowest = Math.min(lowest, s.getMarks());
                }

                double average = (double) total / students.size();
                System.out.println("\nAverage Marks: " + average);
                System.out.println("Highest Marks: " + highest);
                System.out.println("Lowest Marks: " + lowest);

            } else if (choice == 3) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
