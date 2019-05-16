package by.training.task1.exception;

/**
 * @author Alesya Hlushakova
 * class for exceptions while working with storage of toys.
 */
public class StorageException extends Exception {
    /**
     * empty constrictor.
     */
    public StorageException() {
    }

    /**
     * method throws exception.
     * @param message exception message
     */
    public StorageException(final String message) {
        super(message);
    }

    /**
     * method throws exception.
     * @param message message
     * @param cause cause of exception
     */
    public StorageException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * method throws exception.
     * @param cause cause
     */
    public StorageException(final Throwable cause) {
        super(cause);
    }
}
