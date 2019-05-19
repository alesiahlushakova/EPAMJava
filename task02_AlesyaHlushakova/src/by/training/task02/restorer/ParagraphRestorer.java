package by.training.task02.restorer;

import by.training.task02.composite.Component;

import java.util.List;
import java.util.StringJoiner;

public class ParagraphRestorer extends AbstractRestorer {
    private static final String SENTENCE_DELIMITER = ". ";
    private static final String PARAGRAPH_TERMINAL_ELEMENT = ".";

    @Override
    public String restore(Component element) {
        StringJoiner stringJoiner = new StringJoiner(SENTENCE_DELIMITER);
        List<String> restoredParagraphs = restoreEachChild(element);
        restoredParagraphs.forEach(stringJoiner::add);
        return stringJoiner.toString() + PARAGRAPH_TERMINAL_ELEMENT;
    }
}
