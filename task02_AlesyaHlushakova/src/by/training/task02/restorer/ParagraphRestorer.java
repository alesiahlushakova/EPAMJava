package by.training.task02.restorer;

import by.training.task02.composite.Component;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Alesyahlushakova
 * paragraph restorer.
 */
public class ParagraphRestorer extends AbstractRestorer {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(ParagraphRestorer.class);
    /**
     * sentence delimiter.
     */
    private static final String SENTENCE_DELIMITER = ". ";
    /**
     * terminal paragraph element.
     */
    private static final String PARAGRAPH_TERMINAL_ELEMENT = ".";

    /**
     * method restores paragraph.
     * @param element element
     * @return restored paragraph
     */
    @Override
    public String restore(final Component element) {
        StringJoiner stringJoiner = new StringJoiner(SENTENCE_DELIMITER);
        List<String> restoredParagraphs = restoreEachChild(element);
        restoredParagraphs.forEach(stringJoiner::add);

        LOGGER.info(String.format("Paragraph was restored successfully:\n%s",
                stringJoiner.toString() + PARAGRAPH_TERMINAL_ELEMENT));
        return stringJoiner.toString() + PARAGRAPH_TERMINAL_ELEMENT;
    }
}
