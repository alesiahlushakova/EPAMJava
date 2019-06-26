/*
 * class: VersionException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class VersionException extends Exception {

    private static final long serialVersionUID = 8443593543897671572L;

    /**
     * constructor.
     */
    public VersionException() {
        super();
    }

    /**
     * constructor.
     * @param message message.
     */
    public VersionException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public VersionException(final String message,
                            final Throwable cause) {
        super(message, cause);
    }
}

