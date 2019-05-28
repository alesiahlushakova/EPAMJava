package by.training.task02.parser;

import by.training.task02.composite.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

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
    private static final
    String LEXEME_DELIMITER = ",? ";

    /**
     * method parses sentences.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(final String text) {
        Pattern pattern = Pattern.compile(LEXEME_DELIMITER);
        String[] lexemes = pattern.split(text);
        LOGGER.info("Sentence was parsed");
        return parseEach(lexemes);
    }
}
