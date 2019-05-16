package by.training.task1.exception;

/**
 * @author AlesyaHlushakova
 * class for non valid values exception.
 */
public class NonValidValueException extends Exception {
    /**
     * empty constructor.
     */
    public NonValidValueException() {
    }

    /**
     * method throws exception.
     * @param message exception message
     */
    public NonValidValueException(final String message) {
        super(message);
    }
}
