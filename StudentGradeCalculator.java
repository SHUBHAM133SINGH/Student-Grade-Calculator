import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfSubjects = getNumberOfSubjects();
        int totalMarks = getTotalMarks(numOfSubjects);
        double averagePercentage = calculateAveragePercentage(totalMarks, numOfSubjects);
        char grade = determineGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    private static int getNumberOfSubjects() {
        int numOfSubjects = 0;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            try {
                numOfSubjects = scanner.nextInt();
                if (numOfSubjects > 0) {
                    break;
                } else {
                    System.out.println("The number of subjects must be positive.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return numOfSubjects;
    }

    private static int getTotalMarks(int numOfSubjects) {
        int totalMarks = 0;
        for (int i = 1; i <= numOfSubjects; i++) {
            while (true) {
                System.out.print("Enter marks obtained in subject " + i + ": ");
                try {
                    int marks = scanner.nextInt();
                    if (marks >= 0) {
                        totalMarks += marks;
                        break;
                    } else {
                        System.out.println("Marks cannot be negative. Please enter a valid number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numOfSubjects) {
        return (double) totalMarks / numOfSubjects;
    }

    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}



