/*
 * class: MedicineNotFoundException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class MedicineNotFoundException extends Exception {

    private static final long serialVersionUID = -1364027759215712943L;

    /**
     * constructor.
     */
    public MedicineNotFoundException() {
        super();
    }

    /**
     * constructor.
     * @param message message.
     */
    public MedicineNotFoundException(final String message) {
        super(message);
    }

    /**
     * constructor.
     * @param message message
     * @param cause cause
     */
    public MedicineNotFoundException(final String message,
                                     final Throwable cause) {
        super(message, cause);
    }
}


