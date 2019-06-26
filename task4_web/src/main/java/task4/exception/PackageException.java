/*
 * class: PackageException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class PackageException extends Exception {

    private static final long serialVersionUID = -6596694279024538896L;

    /**
     * constructor.
     */
    public PackageException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public PackageException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public PackageException(final String message,
                            final Throwable cause) {
        super(message, cause);
    }
}


