/*
 * class: VersionException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
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
