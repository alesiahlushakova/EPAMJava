package by.training.task4.exception;

/**
 * @author AlesyaHulshakova
 * @version 1.0
 */
public class MedicineException extends Exception {

    private static final long serialVersionUID = -6856437532042142635L;

    public MedicineException() {
        super();
    }

    public MedicineException(String message) {
        super(message);
    }

    public MedicineException(String message, Throwable cause) {
        super(message, cause);
    }
}
