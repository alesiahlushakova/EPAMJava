/*
 * class: XMLVelidationException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class XMLValidationException extends Exception {

    private static final long serialVersionUID = -4249213355583170171L;

    /**
     * constructor.
     */
    public XMLValidationException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public XMLValidationException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public XMLValidationException(final String message,
                                  final Throwable cause) {
        super(message, cause);
    }
}

