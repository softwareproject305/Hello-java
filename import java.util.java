import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private String name;
    private String seatNumber;

    public Passenger(String name, String seatNumber) {
        this.name = name;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

public class FlightPassengerDetails {
    private List<Passenger> passengers;

    public FlightPassengerDetails() {
        passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Passenger findPassenger(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        return null;
    }

    public void displayPassengerDetails() {
        System.out.println("Passenger Details:");
        for (Passenger passenger : passengers) {
            System.out.println("Name: " + passenger.getName() + ", Seat Number: " + passenger.getSeatNumber());
        }
    }

    public static void main(String[] args) {
        FlightPassengerDetails flight = new FlightPassengerDetails();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Add Passenger");
            System.out.println("2. Find Passenger");
            System.out.println("3. Display Passenger Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    Passenger passenger = new Passenger(name, seatNumber);
                    flight.addPassenger(passenger);
                    System.out.println("Passenger added successfully!");
                    break;
                case "2":
                    System.out.print("Enter passenger name: ");
                    name = scanner.nextLine();
                    Passenger foundPassenger = flight.findPassenger(name);
                    if (foundPassenger != null) {
                        System.out.println("Passenger found! Seat Number: " + foundPassenger.getSeatNumber());
                    } else {
                        System.out.println("Passenger not found!");
                    }
                    break;
                case "3":
                    flight.displayPassengerDetails();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println();
        } while (!choice.equals("4"));

        scanner.close();
    }
}
