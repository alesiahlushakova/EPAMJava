package by.training.task03.service;
import by.training.task03.entity.Matrix;
import by.training.task03.exception.MatrixException;
import by.training.task03.service.reader.ThreadReader;
import by.training.task03.service.thread.FillDiagonalThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author AlesyaHlushakova
 * matrix service implementation class
 */
public class MatrixServiceImpl implements MatrixService {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(MatrixServiceImpl.class);

    /**
     * fill matrix data from file.
     * @param f file
     */
    @Override
    public void fillFromFile(final String f) {
        File file = new File(f);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            Matrix t = Matrix.setInstance(scanner.nextInt());
            int v = t.getVerticalSize();
            int h = t.getHorizontalSize();
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < v; col++) {
                    int number = scanner.nextInt();
                    if (row == col && number != 0) {
                        throw new MatrixException(
                                "Zero should be on diagonal. ");
                    }
                    t.setElement(row, col, number);
                }
            }
        } catch (FileNotFoundException | InputMismatchException ex) {
            LOGGER.error("Error reading from file");
        }  catch (MatrixException e) {
            LOGGER.error("Error");
        }
    }

    /**
     * method where threads fill the diagonal.
     */
    @Override
    public void fillDiagonal() {
        try {
            ThreadReader threadReader = new ThreadReader();
            String source = threadReader.read("data\\numbers.txt");
            Scanner scanner = new Scanner(source);
            int threadNumber = scanner.nextInt();
            ReentrantLock locker = new ReentrantLock();
            for (int i = 0; i < threadNumber; i++) {
                Thread thread = new Thread(
                        new FillDiagonalThread(locker, scanner.nextInt()));
                thread.setName("Thread" + i);
                thread.start();
            }
            scanner.close();
        } catch (MatrixException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info("Matrix diagonal filled");

    }

    /**
     * writes data to file.
     * @param filePathName file path
     * @throws IOException writing exception
     * @throws MatrixException matrix exception
     */
    @Override
    public  void writeToFile(final String filePathName)
            throws IOException, MatrixException {
        Matrix array = Matrix.getInstance();
        BufferedWriter writer = new BufferedWriter(
                new FileWriter(new File(filePathName)));
        writer.write(Matrix.getInstance().getHorizontalSize() + "\n");
        for (int i = 0; i < array.getHorizontalSize(); i++) {
            for (int j = 0; j < array.getVerticalSize(); j++) {
                writer.write(String.valueOf(array.getElement(i, j)));
                writer.write(" ");
            }
            writer.write("\r\n");
        }
        writer.flush();
    }
}
