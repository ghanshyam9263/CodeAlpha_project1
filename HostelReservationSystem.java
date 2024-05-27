package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean available;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Reservation {
    private String customerName;
    private Room room;

    public Reservation(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }
}

public class HostelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    private static void displayMenu() {
        System.out.println("\nHostel Reservation System");
        System.out.println("1. Search for available rooms");
        System.out.println("2. Make a reservation");
        System.out.println("3. View booking details");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void searchAvailableRooms() {
        System.out.print("Enter room category (Single/Double/Suite): ");
        String category = scanner.next();
        System.out.println("Available rooms:");
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                System.out.println(room.getRoomNumber() + " (" + room.getCategory() + ")");
            }
        }
    }

    private static void makeReservation() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false);
                reservations.add(new Reservation(name, room));
                System.out.println("Reservation successful!");
                return;
            }
        }
        System.out.println("Room not available or does not exist.");
    }

    private static void viewBookingDetails() {
        System.out.println("Booking Details:");
        for (Reservation reservation : reservations) {
            System.out.println("Customer: " + reservation.getCustomerName() + ", Room: " + reservation.getRoom().getRoomNumber() + " (" + reservation.getRoom().getCategory() + ")");
        }
    }
}