package by.training.task1.exception;

/**
 * @author AlesyaHlushakova
 * class that handles excpetionns while working
 * with invalid data.
 */
public class InvalidDataException extends Exception {
    /**
     * empty constructor.
     */
    public InvalidDataException() {
    }

    /**
     * method throws exception.
     * @param message error message
     */
    public InvalidDataException(final String message) {
        super(message);
    }

    /**
     * method throws exception.
     * @param message exception message
     * @param cause exception cause
     */
    public InvalidDataException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * method throws exception.
     * @param cause cause of exception
     */
    public InvalidDataException(final Throwable cause) {
        super(cause);
    }

    /**
     * method that throws exception.
     * @param message message
     * @param cause cause
     * @param enableSuppression is suppression enabled
     * @param writableStackTrace stack trace
     */
    public InvalidDataException(final String message, final Throwable cause,
                                final boolean enableSuppression,
                                final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

