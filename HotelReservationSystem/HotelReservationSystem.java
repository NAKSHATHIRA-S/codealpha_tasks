package codealpha;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private String category;
    private boolean booked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBooked() {
        return booked;
    }

    public void bookRoom() {
        booked = true;
    }

    public void cancelBooking() {
        booked = false;
    }
}

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    public static void viewRooms() {
        System.out.println("\n===== AVAILABLE ROOMS =====");

        for (Room room : rooms) {
            System.out.println(
                "Room No: " + room.getRoomNumber() +
                " | Category: " + room.getCategory() +
                " | Status: " + (room.isBooked() ? "Booked" : "Available")
            );
        }
    }

    public static void bookRoom() {

        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNo) {

                if (!room.isBooked()) {

                    System.out.print("Enter Payment Amount: ₹");
                    double payment = sc.nextDouble();

                    room.bookRoom();

                    System.out.println("Payment Received: ₹" + payment);
                    System.out.println("Room Booked Successfully!");
                } else {
                    System.out.println("Room Already Booked.");
                }
                return;
            }
        }

        System.out.println("Room Not Found.");
    }

    public static void cancelReservation() {

        System.out.print("Enter Room Number to Cancel: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNo) {

                if (room.isBooked()) {
                    room.cancelBooking();
                    System.out.println("Reservation Cancelled Successfully.");
                } else {
                    System.out.println("Room is not booked.");
                }
                return;
            }
        }

        System.out.println("Room Not Found.");
    }

    public static void main(String[] args) {

        initializeRooms();

        int choice;

        do {
            System.out.println("\n========== HOTEL RESERVATION SYSTEM ==========");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    System.out.println("Thank You for Using the System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
