package project;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Grade_trakers {
    public static void main(String[] args) {
        // Create an ArrayList to store student grades
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        // Loop to get student grades from the user
        System.out.println("Enter student grades. Type 'yes' to finis ");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
            }
        }

        // Check if grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            // Calculate the average, highest, and lowest grades
            int total = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                total += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = total / (double) grades.size();

            // Output the results
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }
}