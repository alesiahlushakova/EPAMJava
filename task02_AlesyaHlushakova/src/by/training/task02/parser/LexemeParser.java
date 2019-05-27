package by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 * lexeme parser class.
 */
public class LexemeParser extends AbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(LexemeParser.class);


    /**
     * parses lexeme.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(final String text) {
        Component lexeme;

        lexeme = Particle.word(text);
        LOGGER.info("Lexeme was parsed" + lexeme);
        return lexeme;
    }
}
