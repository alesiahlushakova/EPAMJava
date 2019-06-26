/*
 * class: ParserNotFoundException
 */

package main.java.task4.exception;

/**
 * @author AlesyaHlushakova
 */
public class ParserNotFoundException extends Exception {

    private static final long serialVersionUID = 3488687349870618790L;

    public ParserNotFoundException() {
        super();
    }
    
    public ParserNotFoundException(String message) {
        super(message);
    }
    
    public ParserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
