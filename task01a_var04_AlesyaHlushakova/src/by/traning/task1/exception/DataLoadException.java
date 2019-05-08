package by.traning.task1.exception;

/**
 * @author AlesuaHlushakova
 * class for exception while loading data.
 */
public class DataLoadException extends Exception {
    /**
     * empty constructor.
     */
    public DataLoadException() {
    }

    /**
     *
     * @param message about exception
     */
    public DataLoadException(String message) {
        super(message);
    }

    /**
     * constructor for data load exception.
     * @param message exception message
     * @param cause of exception
     */
    public DataLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * constructor for exception.
     * @param cause of exception
     */
    public DataLoadException(Throwable cause) {
        super(cause);
    }
}