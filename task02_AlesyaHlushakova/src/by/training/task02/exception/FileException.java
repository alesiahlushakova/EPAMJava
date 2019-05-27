package by.training.task02.exception;

/**
 * @author AlesyaHluhakova
 * exception class.
 */
public class FileException extends Exception {
    /**
     * empty constructor.
     */
    public FileException() {

    }

    /**
     * file exception constructor.
     * @param message exception message
     */
    public  FileException(final String message) {
        super(message);
    }

    /**
     * file exception constructor.
     * @param message message
     * @param cause cause
     */
    public  FileException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * file exception constructor.
     * @param cause cause
     */
    public  FileException(final Throwable cause) {
        super(cause);
    }
}
