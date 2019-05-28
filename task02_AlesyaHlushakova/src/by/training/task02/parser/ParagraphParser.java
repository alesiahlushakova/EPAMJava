package by.training.task02.parser;

import by.training.task02.composite.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

/**
 * @author AlesyaHlushakova
 * paragraph parser.
 */
public class ParagraphParser extends AbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(ParagraphParser.class);
    /**
     * sentence delimiter.
     */
    private static final String SENTENCE_DELIMITER = "([?!]|(\\.(\\.{2})?)) ?";

    /**
     * method parses paragraphs.
     * @param text text
     * @return component
     */
    @Override
    public Component parse(final String text) {
        Pattern pattern = Pattern.compile(SENTENCE_DELIMITER);
        String[] sentences = pattern.split(text);
        LOGGER.info("Paragraph was parsed" + parseEach(sentences));
        return parseEach(sentences);
    }
}
