/*
 * class: MedicineException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class MedicineException extends Exception {

    private static final long serialVersionUID = -6856437532042142635L;

    /**
     * constructor.
     */
    public MedicineException() {
        super();
    }

    /**
     * constructor.
     * @param message message
     */
    public MedicineException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public MedicineException(final String message,
                             final Throwable cause) {
        super(message, cause);
    }
}


