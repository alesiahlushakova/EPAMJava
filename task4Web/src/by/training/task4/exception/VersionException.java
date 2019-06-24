package by.training.task4.exception;

/**
 * @author AlesyaHlushakova
 * @version 1.0
 */
public class VersionException extends Exception {

    private static final long serialVersionUID = 8443593543897671572L;

    public VersionException() {
        super();
    }

    public VersionException(String message) {
        super(message);
    }

    public VersionException(String message, Throwable cause) {
        super(message, cause);
    }
}
