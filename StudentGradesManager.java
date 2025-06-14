import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

   Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0.0;
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return grades.size() > 0 ? max : 0;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int grade : grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return grades.size() > 0 ? min : 0;
    }
}

public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("\nEnter name of student #" + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gradeCount = scanner.nextInt();

            for (int j = 0; j < gradeCount; j++) {
                System.out.print("Enter grade #" + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.grades.add(grade);
            }
            scanner.nextLine(); // consume newline
            students.add(student);
        }

        System.out.println("\n====== Summary Report ======");
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Grades: " + student.grades);
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println("----------------------------");
        }

        scanner.close();
    }
}




    

