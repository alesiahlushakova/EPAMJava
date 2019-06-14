package by.training.task4.exception;

/**
 * @author AlesyaHlushakova
 * @version 1.0
 */
public class DosageException extends Exception {

    private static final long serialVersionUID = 3731630959386551415L;

    public DosageException() {
        super();
    }

    public DosageException(String message) {
        super(message);
    }

    public DosageException(String message, Throwable cause) {
        super(message, cause);
    }
}
