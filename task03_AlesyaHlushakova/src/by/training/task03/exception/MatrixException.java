package by.training.task03.exception;

import by.training.task03.entity.Matrix;

/**
 * @author AlesyaHlushakova
 * class that handles excpetionns while working
 * with invalid data.
 */
public class MatrixException extends Exception {
    /**
     * empty constructor.
     */
    public MatrixException() {
    }

    /**
     * method throws exception.
     *
     * @param message error message
     */
    public MatrixException(final String message) {
        super(message);
    }

    /**
     * method throws exception.
     *
     * @param message exception message
     * @param cause   exception cause
     */
    public MatrixException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * method throws exception.
     *
     * @param cause cause of exception
     */
    public MatrixException(final Throwable cause) {
        super(cause);
    }

    /**
     * method that throws exception.
     *
     * @param message            message
     * @param cause              cause
     * @param enableSuppression  is suppression enabled
     * @param writableStackTrace stack trace
     */
    public MatrixException(final String message, final Throwable cause,
                           final boolean enableSuppression,
                           final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}