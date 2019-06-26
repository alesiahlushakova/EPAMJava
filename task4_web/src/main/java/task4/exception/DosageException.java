/*
 * class: DosageException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class DosageException extends Exception {

    private static final long serialVersionUID = 3731630959386551415L;

    /**
     * constructor.
     */
    public DosageException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public DosageException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public DosageException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

