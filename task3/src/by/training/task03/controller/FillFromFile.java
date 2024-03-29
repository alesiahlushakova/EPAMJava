package by.training.task03.controller;

import by.training.task03.service.MatrixServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 */
public class FillFromFile implements Command {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FillFromFile.class);
    /**
     * fills matrix from file.
     * @param request request
     */
    @Override
    public void execute(final String request) {

        MatrixServiceImpl matrixService = new MatrixServiceImpl();
        matrixService.fillFromFile("data\\data.txt");
        LOGGER.info("Matrix filled");
    }
}
