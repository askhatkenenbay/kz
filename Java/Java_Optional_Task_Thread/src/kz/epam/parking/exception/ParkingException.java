package kz.epam.parking.exception;

public class ParkingException extends Exception {
    public ParkingException() {
        System.out.println("Invalid input for number of parking places");
    }

    public ParkingException(String message) {
        super(message);
    }

    public ParkingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingException(Throwable cause) {
        super(cause);
    }
}
