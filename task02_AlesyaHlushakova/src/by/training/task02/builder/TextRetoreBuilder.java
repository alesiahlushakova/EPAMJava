package by.training.task02.builder;

import by.training.task02.restorer.*;

public class TextRetoreBuilder {
    public Restorer build() {
        AbstractRestorer lexemeRestorer = new LexemeRestorer();
        AbstractRestorer sentenceRestorer = new SentenceRestorer();
        sentenceRestorer.setSuccessor(lexemeRestorer);

        AbstractRestorer paragraphRestorer = new ParagraphRestorer();
        paragraphRestorer.setSuccessor(sentenceRestorer);

        AbstractRestorer textRestorer = new TextRestorer();
        textRestorer.setSuccessor(paragraphRestorer);

        return textRestorer;
    }
}
