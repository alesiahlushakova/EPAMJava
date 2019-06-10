package by.training.task03.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alesyahlushakova
 * wrong command.
 */
public class WrongInput implements Command {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FillFromFile.class);
    /**
     * @param request request
     */
    @Override
    public void execute(final String request) {
        LOGGER.info("Wrong command!");
    }
}
