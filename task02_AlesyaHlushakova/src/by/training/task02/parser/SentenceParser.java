package by.training.task02.parser;

import by.training.task02.composite.Component;

/**
 * @author AlesyaHlushakova
 * sentence parser.
 */
public class SentenceParser extends AbstractParser {
    /**
     * lexeme delimiter.
     */
    private static String LEXEME_DELIMITER = ",?; ";

    /**
     * method parses sentences
     * @param text text
     * @return component
     */
    @Override
    public Component parse(String text) {
        String[] lexemes = text.split(LEXEME_DELIMITER);

        return parseEach(lexemes);
    }
}
