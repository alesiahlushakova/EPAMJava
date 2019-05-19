package by.training.task02.parser;

import by.training.task02.composite.Component;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_DELIMITER = "([?!]|(\\.(\\.{2})?)) ?";

    @Override
    public Component parse(String text) {
        String[] sentences = text.split(SENTENCE_DELIMITER);

        return parseEach(sentences);
    }
}
