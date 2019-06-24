package by.training.task4.exception;

/**
 * @author AlesyaHulshakova
 * @version 1.0
 */
public class PackageException extends Exception {

    private static final long serialVersionUID = -6596694279024538896L;

    public PackageException() {
        super();
    }

    public PackageException(String message) {
        super(message);
    }

    public PackageException(String message, Throwable cause) {
        super(message, cause);
    }
}