import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGrading {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("           STUDENT GRADING SYSTEM         ");
        System.out.println("=========================================");
        System.out.println();

        // Input number of students (n)
        System.out.print("Number of students : ");
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Input student names and their scores
        String[] names = new String[n];
        double[] scores = new double[n];

        for (int j = 0; j < n; j++) {
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println(" Student " + (j + 1) + " of " + n);
            System.out.println("-----------------------------------------");
            System.out.print("  Name  : ");
            names[j] = scanner.nextLine().trim();

            System.out.print("  Score : ");
            scores[j] = Double.parseDouble(scanner.nextLine().trim());
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("           PROCESSING RESULTS...          ");
        System.out.println("=========================================");

        // Initialize variables
        double sum = 0;
        int passCount = 0;
        int failCount = 0;
        double highestScore = -1;
        List<String> topStudents = new ArrayList<>();
        String[] grades = new String[n]; // parallel array to store letter grades

        int i = 0;
        while (i < n) {
            String currentName = names[i];
            double currentScore = scores[i];

            // Determine letter grade based on grading scale
            String grade;
            if (currentScore >= 98) {
                grade = "A+";
            } else if (currentScore >= 92) {
                grade = "A";
            } else if (currentScore >= 87) {
                grade = "B+";
            } else if (currentScore >= 81) {
                grade = "B";
            } else if (currentScore >= 77) {
                grade = "C+";
            } else if (currentScore >= 71) {
                grade = "C";
            } else if (currentScore >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            grades[i] = grade; // Store letter grade for this student

            // Track top-performing student(s)
            if (currentScore > highestScore) {
                highestScore = currentScore;
                topStudents.clear();
                topStudents.add(currentName);
            } else if (currentScore == highestScore) {
                topStudents.add(currentName);
            }
            // else: do nothing

            // Update sum and pass/fail counts
            sum = sum + currentScore;
            if (currentScore >= 60) {
                passCount = passCount + 1;
            } else {
                failCount = failCount + 1;
            }

            i = i + 1;
        }

        double classAverage = sum / n;

        boolean below70;
        if (classAverage < 70) {
            below70 = true;
        } else {
            below70 = false;
        }

        // Output
        System.out.println();
        System.out.println("=== Letter Grades ===");
        for (int k = 0; k < n; k++) {
            System.out.println(names[k] + " - Score: " + scores[k] + " - Grade: " + grades[k]);
        }

        System.out.println();
        System.out.println("=== Top-Performing Student(s) ===");
        System.out.println("Score: " + highestScore);
        for (String topStudent : topStudents) {
            System.out.println(topStudent);
        }

        System.out.println();
        System.out.printf("Class Average: %.2f%n", classAverage);
        System.out.println("Number of students who passed (score >= 60): " + passCount);
        System.out.println("Number of students who did not pass (score < 60): " + failCount);
        System.out.println("Is class average below 70? " + below70);

        scanner.close();
    }
}
