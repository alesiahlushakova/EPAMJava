package by.training.task02.parser;

import by.training.task02.composite.Component;

/**
 * @author AlesyaHlushakova
 * text parser class.
 */
public class TextParser extends AbstractParser {
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
    public Component parse(String text) {
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);

        return parseEach(paragraphs);
    }
}
