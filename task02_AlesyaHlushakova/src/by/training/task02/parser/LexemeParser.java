package by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 * lexeme parser class.
 */
public class LexemeParser extends AbstractParser{
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractParser.class);
    private static final String EXPRESSION_PATTERN = "[a-z0-9_-]$";

    /**
     * parses lexeme.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(String text) {
        Component lexeme;
        boolean isExpression = text.matches(EXPRESSION_PATTERN);
        lexeme = Particle.word(text);
        LOGGER.info("Lexeme was parsed" + lexeme);
        return lexeme;
    }
}
