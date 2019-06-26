/*
 * class: ElementNotPresentedException
 */

package main.java.task4.exception;
/**
 * @author AlesyaHlushakova
 */
public class MedicineAttributeException extends Exception {

    private static final long serialVersionUID = -7616374672947252285L;

    /**
     * constructor.
     */
    public MedicineAttributeException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public MedicineAttributeException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public MedicineAttributeException(final String message,
                                      final Throwable cause) {
        super(message, cause);
    }
}


