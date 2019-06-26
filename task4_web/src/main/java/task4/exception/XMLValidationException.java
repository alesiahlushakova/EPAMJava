/*
 * class: XMLVelidationException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class XMLValidationException extends Exception {

    private static final long serialVersionUID = -4249213355583170171L;

    public XMLValidationException() {
        super();
    }
    
    public XMLValidationException(String message) {
        super(message);
    }
    
    public XMLValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
