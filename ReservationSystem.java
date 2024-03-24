import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a plumbing service
class PlumbingService {
    private final String serviceName;
    private final double serviceCost;

    public PlumbingService(String name, double cost) {
        this.serviceName = name;
        this.serviceCost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getServiceCost() {
        return serviceCost;
    }
}

// Class to represent a booking
class Booking {
    private final String customerName;
    private final String serviceRequired;
    private final String bookingDate;

    public Booking(String customerName, String serviceRequired, String bookingDate) {
        this.customerName = customerName;
        this.serviceRequired = serviceRequired;
        this.bookingDate = bookingDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceRequired() {
        return serviceRequired;
    }

    public String getBookingDate() {
        return bookingDate;
    }
}

// Class to manage bookings and services
public class ReservationSystem {
    private final ArrayList<PlumbingService> services;
    private final ArrayList<Booking> bookings;

    public ReservationSystem() {
        services = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addService(String name, double cost) {
        PlumbingService service = new PlumbingService(name, cost);
        services.add(service);
    }

    public void displayServices() {
        System.out.println("Available Services:");
        for (PlumbingService service : services) {
            System.out.println(service.getServiceName() + " - $" + service.getServiceCost());
        }
    }

    public void makeBooking(String customerName, String serviceRequired, String bookingDate) {
        Booking booking = new Booking(customerName, serviceRequired, bookingDate);
        bookings.add(booking);
        System.out.println("Booking confirmed for " + customerName + " on " + bookingDate + " for " + serviceRequired);
    }

    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.addService("Pipe Leak Repair", 50.0);
        reservationSystem.addService("Clogged Drain Repair", 80.0);
        // Add more services as needed

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Plumbing Company Reservation System");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display Available Services");
            System.out.println("2. Make a Booking");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    reservationSystem.displayServices();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter service required: ");
                    String serviceRequired = scanner.nextLine();
                    System.out.print("Enter booking date: ");
                    String bookingDate = scanner.nextLine();
                    reservationSystem.makeBooking(customerName, serviceRequired, bookingDate);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
