package by.training.task4.exception;

/**
 * @author Alesya Hlushakova
 * @version 1.0
 */
public class MedicineNotPresentedException extends Exception {

    private static final long serialVersionUID = -1364027759215712943L;

    public MedicineNotPresentedException() {
        super();
    }

    public MedicineNotPresentedException(String message) {
        super(message);
    }

    public MedicineNotPresentedException(String message, Throwable cause) {
        super(message, cause);
    }
}