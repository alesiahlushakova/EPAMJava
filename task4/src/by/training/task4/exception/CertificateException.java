package by.training.task4.exception;
/**
 * @author AlesyaHluahakova
 * @version 1.0
 */
public class CertificateException extends Exception {

    private static final long serialVersionUID = -6442723198980701875L;

    public CertificateException() {
        super();
    }

    public CertificateException(String message) {
        super(message);
    }

    public CertificateException(String message, Throwable cause) {
        super(message, cause);
    }
}
