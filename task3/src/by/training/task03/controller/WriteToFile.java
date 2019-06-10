package by.training.task03.controller;

import by.training.task03.exception.MatrixException;
import by.training.task03.service.MatrixServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;

/**
 * @author AlesyaHlushakova
 */
public class WriteToFile implements Command {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(WriteToFile.class);
    /**
     * writes to file.
     * @param request request
     */
    @Override
    public void execute(final String request) {
        try {
            MatrixServiceImpl matrixService = new MatrixServiceImpl();
            matrixService.writeToFile("data\\writtenMatrix.txt");
            LOGGER.info("Matrix written to file");
        } catch (MatrixException | IOException e) {
        LOGGER.error(e.getMessage());
        }
    }
}
