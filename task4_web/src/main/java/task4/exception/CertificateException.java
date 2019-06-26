/*
 * class: CertificateException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class CertificateException extends Exception {

    private static final long serialVersionUID = -6442723198980701875L;

    /**
     * super class constructor.
     */
    public CertificateException() {
        super();
    }

    /**
     * constructor.
     * @param message exception message
     */
    public CertificateException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message exception message
     * @param cause cause of the exception
     */
    public CertificateException(final String message,
                                final Throwable cause) {
        super(message, cause);
    }
}


