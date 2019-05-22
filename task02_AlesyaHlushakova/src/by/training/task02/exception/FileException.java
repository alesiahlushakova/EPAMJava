package by.training.task02.exception;

/**
 * @author AlesyaHluhakova
 * exception class.
 */
public class FileException extends Exception{
    /**
     * empty constructor.
     */
    public FileException() {

    }

    /**
     * file exception constructor.
     * @param message exception message
     */
    public  FileException(String message) {
        super(message);
    }

    /**
     * file exception constructor.
     * @param message message
     * @param cause cause
     */
    public  FileException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * file exception constructor.
     * @param cause cause
     */
    public  FileException(Throwable cause) {
        super(cause);
    }
}
