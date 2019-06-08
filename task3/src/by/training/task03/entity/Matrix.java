package by.training.task03.entity;

import by.training.task03.exception.MatrixException;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AlesyaHlushakova
 * class - matrix model.
 */
public class Matrix {
    /**
     * singleton.
     */
    private  static Matrix instance;
    /**
     * locker.
     */
    private static ReentrantLock locker;

    /**
     * private constructor.
     */
    private Matrix() {}

    /**
     * constructor.
     * @param matrixSize size
     */
    private  Matrix(int matrixSize) {
        a = new int[matrixSize][matrixSize];
    }

    /**
     * sets size of matrix.
     * @param matrixSize size
     * @return matrix
     */
    public static Matrix setInstance(int matrixSize) {
                    locker = new ReentrantLock();
                    instance = new Matrix(matrixSize);

        return instance;
    }

    /**
     * gets instance of matrix singleton.
     * @return matrix
     */
    public static Matrix getInstance() {
        locker.lock();
        try {
            if (instance == null) {
                synchronized (Matrix.class) {
                    if (instance == null) {
                        instance = new Matrix();
                    }
                }
            }
            return instance;
        } finally {
            locker.unlock();
        }

    }

    /**
     * matrix.
     */
    private int[ ][ ] a;

    /**
     * constructor.
     * @param n n
     * @param m m
     * @throws MatrixException exception
     */
    public Matrix(int n, int m) throws MatrixException {
        if ((n < 1) || (m < 1)) {
            throw new MatrixException();
        }
        a = new int[n][m];
    }

    /**
     * gets vertical matrix size.
     * @return size
     */
    public int getVerticalSize() {
        locker.lock();
        try {
            return a.length;
        } finally {
            locker.unlock();
        }

    }

    /**
     * gets horizontal matrix size.
     * @return size
     */
    public int getHorizontalSize() {
        locker.lock();
        try {
            return a[0].length;
        } finally {
            locker.unlock();
        }

    }

    /**
     * gets matrix element.
     * @param i i
     * @param j j
     * @return element
     * @throws MatrixException exception
     */
    public int getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return a[i][j];
        }
        throw new MatrixException();
    }

    /**
     * sets matrix element.
     * @param i i
     * @param j j
     * @param value implemented value
     * @throws MatrixException exception
     */
    public void setElement(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            a[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }

    /**
     * method writes matrix.
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nMatrix : " + a.length + "x" + a[0].length + "\n");
        for (int[] row : a) {
            for (int value : row) {
                s.append(value + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * method checks range.
     * @param i i
     * @param j j
     * @return is valid
     */
    private boolean checkRange(int i, int j) {
        if ( i < 0 || i > a.length - 1 || j < 0 || j > a[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }
}
