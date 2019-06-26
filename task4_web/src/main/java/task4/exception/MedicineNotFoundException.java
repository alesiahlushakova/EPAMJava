/*
 * class: MedicineNotFoundException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class MedicineNotFoundException extends Exception {

    private static final long serialVersionUID = -1364027759215712943L;

    public MedicineNotFoundException() {
        super();
    }
    
    public MedicineNotFoundException(String message) {
        super(message);
    }
    
    public MedicineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
