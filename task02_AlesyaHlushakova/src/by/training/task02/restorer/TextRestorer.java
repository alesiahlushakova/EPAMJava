package by.training.task02.restorer;

import by.training.task02.composite.Component;

import java.util.List;
import java.util.StringJoiner;

import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 * text restorer.
 */
public class TextRestorer extends AbstractRestorer {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(TextRestorer.class);
    /**
     * paragraph delimiter.
     */
    private static final String PARAGRAPH_DELIMITER = "\n";

    /**
     * method restores text.
     * @param component component
     * @return restored text
     */
    @Override
    public String restore(final Component component) {
        StringJoiner stringJoiner = new StringJoiner(PARAGRAPH_DELIMITER);
        List<String> restoredParagraphs = restoreEachChild(component);
        restoredParagraphs.forEach(stringJoiner::add);
        LOGGER.info("Text was restored successfully:\n%s");
        return stringJoiner.toString();

    }
}
