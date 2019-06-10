package by.training.task03.service;

import by.training.task03.exception.MatrixException;

import java.io.IOException;

/**
 * @author AlesyaHlushakova
 * matrix service functinal.
 */
public interface MatrixService {
    /**
     * fills matrix.
     * @param f file
     */
    void fillFromFile(String f);

    /**
     * fills diagonal with numbers.
     */
    void fillDiagonal();

    /**
     * writes matrix to file.
     * @param source path
     * @throws IOException exception
     * @throws MatrixException exception
     */
    void writeToFile(String source) throws
            IOException, MatrixException;
}
