package by.training.task4.exception;

/**
 * @author Alesya Hulshakova
 * @version 1.0
 */
public class MedicineAttributeException extends Exception {

    private static final long serialVersionUID = -7616374672947252285L;

    public MedicineAttributeException() {
        super();
    }

    public MedicineAttributeException(String message) {
        super(message);
    }

    public MedicineAttributeException(String message, Throwable cause) {
        super(message, cause);
    }
}
