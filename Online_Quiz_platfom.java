package project;
import java.util.Scanner;

public class Online_Quiz_platfom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0.0;
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to the Simple Banking Application");
            System.out.println("Please choose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("You have successfully deposited $" + depositAmount);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("You have successfully withdrawn $" + withdrawAmount);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient funds. Your current balance is $" + balance);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive number.");
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Simple Banking Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 4.");
                    break;
            }

            System.out.println(); // Add an empty line for better readability
        }

        scanner.close();
    }
}
