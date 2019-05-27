package by.training.task02.parser;

import by.training.task02.composite.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 * sentence parser.
 */
public class SentenceParser extends AbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(SentenceParser.class);
    /**
     * lexeme delimiter.
     */
    private static String LEXEME_DELIMITER = ",? ";

    /**
     * method parses sentences.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(final String text) {
        String[] lexemes = text.split(LEXEME_DELIMITER);
        LOGGER.info("Sentence was parsed");
        return parseEach(lexemes);
    }
}
