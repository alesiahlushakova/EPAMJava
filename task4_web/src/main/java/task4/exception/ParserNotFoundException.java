/*
 * class: ParserNotFoundException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class ParserNotFoundException extends Exception {

    private static final long serialVersionUID = 3488687349870618790L;

    /**
     * constructor.
     */
    public ParserNotFoundException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public ParserNotFoundException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public ParserNotFoundException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }
}


