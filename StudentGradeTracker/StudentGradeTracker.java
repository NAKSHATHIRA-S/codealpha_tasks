package codealpha;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        students.add(new Student(name, marks));

        System.out.println("Student Added Successfully!");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n------ Student Report ------");
        System.out.printf("%-20s %-10s %-10s\n",
                "Name", "Marks", "Grade");

        for (Student s : students) {
            System.out.printf("%-20s %-10d %-10s\n",
                    s.getName(),
                    s.getMarks(),
                    s.getGrade());
        }
    }

    public static void showStatistics() {

        if (students.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int total = 0;
        int highest = students.get(0).getMarks();
        int lowest = students.get(0).getMarks();

        for (Student s : students) {

            total += s.getMarks();

            if (s.getMarks() > highest)
                highest = s.getMarks();

            if (s.getMarks() < lowest)
                lowest = s.getMarks();
        }

        double average = (double) total / students.size();

        System.out.println("\n------ Statistics ------");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Marks  : " + highest);
        System.out.println("Lowest Marks   : " + lowest);
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. View Statistics");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    showStatistics();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}