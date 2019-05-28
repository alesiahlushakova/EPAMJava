package by.training.task02.parser;

import by.training.task02.composite.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * @author AlesyaHlushakova
 * text parser class.
 */
public class TextParser extends AbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.getLogger(TextParser.class);
    /**
     * paragraph delimiter.
     */
    private static final String PARAGRAPH_DELIMITER = "\n";

    /**
     * method parses text.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(final String text) {
        Pattern pattern = Pattern.compile(PARAGRAPH_DELIMITER);
        String[] paragraphs = pattern.split(text);
        LOGGER.info("Text was parsed" + parseEach(paragraphs));
        return parseEach(paragraphs);
    }
}
