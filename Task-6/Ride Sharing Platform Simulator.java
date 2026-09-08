// Program
import java.util.*;

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Vehicle {
    String number;

    Vehicle(String number) {
        this.number = number;
    }
}

abstract class Trip {
    double distance;

    Trip(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bike extends Trip {
    Bike(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 5;
    }
}

class Auto extends Trip {
    Auto(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

class Cab extends Trip {
    Cab(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 12;
    }
}

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                if (distance <= 0) {
                    throw new InvalidBookingException("Invalid booking");
                }

                Trip trip;

                if (type.equals("Bike")) {
                    trip = new Bike(distance);
                } else if (type.equals("Auto")) {
                    trip = new Auto(distance);
                } else if (type.equals("Cab")) {
                    trip = new Cab(distance);
                } else {
                    throw new InvalidBookingException("Invalid booking");
                }

                System.out.println((int) trip.calculateFare());

            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
 Input : 
   3 
   Bike 10 
   Cab  15 
   Auto 8
Output : 
  50
  180
  96 
