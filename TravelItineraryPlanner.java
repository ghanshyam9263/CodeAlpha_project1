package project;
import java.util.Scanner;

public class TravelItineraryPlanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Inputs
        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter your destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter your start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter your end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter your budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Do you like museums? (yes/no): ");
        boolean likesMuseums = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Do you like historical sites? (yes/no): ");
        boolean likesHistoricalSites = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Do you like local cuisine? (yes/no): ");
        boolean likesLocalCuisine = scanner.nextLine().equalsIgnoreCase("yes");

        // Generate Itinerary
        String itinerary = createItinerary(destination, startDate, endDate, budget, likesMuseums, likesHistoricalSites, likesLocalCuisine);

        // Display Itinerary
        System.out.println("\nYour Travel Itinerary:\n");
        System.out.println(itinerary);
    }

    private static String createItinerary(String destination, String startDate, String endDate, double budget, boolean likesMuseums, boolean likesHistoricalSites, boolean likesLocalCuisine) {
        StringBuilder itinerary = new StringBuilder();

        itinerary.append("Destination: ").append(destination).append("\n");
        itinerary.append("Start Date: ").append(startDate).append("\n");
        itinerary.append("End Date: ").append(endDate).append("\n");
        itinerary.append("Budget: $").append(String.format("%.2f", budget)).append("\n\n");

        itinerary.append("Day 1: Arrival and check-in\n");
        if (likesMuseums) {
            itinerary.append("Visit the local museum\n");
        }
        if (likesHistoricalSites) {
            itinerary.append("Explore historical sites\n");
        }
        if (likesLocalCuisine) {
            itinerary.append("Dine at a local restaurant\n");
        }
        itinerary.append("\nDay 2: Enjoy your time in ").append(destination).append("\n");
        // Continue building the itinerary for more days...

        return itinerary.toString();
    }
}
