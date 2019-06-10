package by.training.task03.controller;

import by.training.task03.exception.MatrixException;

import by.training.task03.service.thread.FillDiagonalThread;
import by.training.task03.service.reader.ThreadReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alesyahlushakova
 */
public class FillDiagonal implements Command {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FillDiagonal.class);
    /**
     * fills diagonal.
     * @param request request
     */
    @Override
    public void execute(final String request) {
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


}
