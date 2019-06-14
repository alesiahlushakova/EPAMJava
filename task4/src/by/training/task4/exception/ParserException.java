package by.training.task4.exception;

/**
 * @author Alesya Hlushakova
 * @version 1.0
 */
public class ParserException extends Exception {

    private static final long serialVersionUID = 3488687349870618790L;

    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }
}