package by.traning.task1.exceptions;

public class NonValidValueException extends Exception {

    public NonValidValueException() {
    }

    public NonValidValueException(String message) {
        super(message);
    }

    public NonValidValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonValidValueException(Throwable cause) {
        super(cause);
    }
}
