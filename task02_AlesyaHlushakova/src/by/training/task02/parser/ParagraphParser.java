package by.training.task02.parser;

import by.training.task02.composite.Component;

/**
 * @author AlesyaHlushakova
 * paragraph parser.
 */
public class ParagraphParser extends AbstractParser {
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
    public Component parse(String text) {
        String[] sentences = text.split(SENTENCE_DELIMITER);

        return parseEach(sentences);
    }
}
