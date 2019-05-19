package by.training.task02.builder;

import by.training.task02.parser.*;

public class ChainBuilder {
    public AbstractParser build() {
        AbstractParser lexemeParser = new LexemeParser();
        AbstractParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);

        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);

        return textParser;
    }
}
