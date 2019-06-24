package by.training.task02.parser.builder;

import by.training.task02.parser.SentenceParser;
import by.training.task02.parser.LexemeParser;
import by.training.task02.parser.ParagraphParser;
import by.training.task02.parser.AbstractParser;
import by.training.task02.parser.TextParser;

/**
 * @author AlesyaHlushakova
 * parser.
 */
public class ChainBuilder {
    /**
     * method builds builder.
     * @return parsed text
     */
    public AbstractParser build() {
        /**
         * lexeme parser.
         */
        AbstractParser lexemeParser = new LexemeParser();
        /**
         * sentence parser.
         */
        AbstractParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);
/**
 * paragraph parser.
 */
        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);
/**
 * text parser.
 */
        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        return textParser;
    }
}
