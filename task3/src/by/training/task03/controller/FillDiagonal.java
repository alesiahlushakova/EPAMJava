package by.training.task03.controller;

import by.training.task03.exception.MatrixException;

import by.training.task03.service.MatrixServiceImpl;
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

        MatrixServiceImpl matrixService = new MatrixServiceImpl();
        matrixService.fillDiagonal();
    }


}
