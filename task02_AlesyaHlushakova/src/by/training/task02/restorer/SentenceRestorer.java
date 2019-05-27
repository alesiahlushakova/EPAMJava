package by.training.task02.restorer;

import by.training.task02.composite.Component;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Alesyahlushakova
 * sentence restorer.
 */
public class SentenceRestorer extends AbstractRestorer {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(SentenceRestorer.class);
    /**
     * lexeme delimiter.
     */
    private static final String LEXEME_DELIMITER = " ";

    /**
     * restores sentence.
     * @param element element
     * @return sentence
     */
    @Override
    public String restore(final Component element) {
        StringJoiner stringJoiner = new StringJoiner(LEXEME_DELIMITER);
        List<String> restoredParagraphs = restoreEachChild(element);
        restoredParagraphs.forEach(stringJoiner::add);
        LOGGER.info(String.format("Sentence was restored successfully:\n%s",
                stringJoiner.toString()));
        return stringJoiner.toString();
    }
}
