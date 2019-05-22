package by.training.task02.restorer;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 * lexeme restorer.
 */
public class LexemeRestorer extends AbstractRestorer {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.getLogger(TextRestorer.class);
    /**
     * method restores lexeme.
     * @param element element
     * @return restored lexeme
     */
    @Override
    public String restore(Component element) {
        Particle lexeme = (Particle) element;
        String restoredLexeme;

        restoredLexeme = lexeme.getValue();

        LOGGER.info(String.format("Lexeme was restored successfully:\n%s", restoredLexeme));
        return restoredLexeme;
    }
}
