package kz.epam.electricalappliance.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException() {
        System.out.println("Invalid Input was entered");
    }
    public InvalidInputException(String message) {
        super(message);
    }
    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
