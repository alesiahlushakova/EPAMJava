package by.training.task4.exception;
/**
 * @author Alesya Hulshakova
 * @version 1.0
 */
public class XMLException extends Exception {

    private static final long serialVersionUID = -4249213355583170171L;

    public XMLException() {
        super();
    }

    public XMLException(String message) {
        super(message);
    }

    public XMLException(String message, Throwable cause) {
        super(message, cause);
    }
}
