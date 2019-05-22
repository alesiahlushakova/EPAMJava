package by.training.task02.builder;

import by.training.task02.restorer.*;

/**
 * @author AlesyaHlushakova
 * class restores text.
 */
public class TextRestoreBuilder {
    /**
     * restores text.
     * @return text restorer
     */
    public Restorer build() {
        /**
         * lexeme restorer.
         */
        AbstractRestorer lexemeRestorer = new LexemeRestorer();
        /**
         * sentence restorer.
         */
        AbstractRestorer sentenceRestorer = new SentenceRestorer();
        sentenceRestorer.setSuccessor(lexemeRestorer);
/**
 * paragraph restorer.
 */
        AbstractRestorer paragraphRestorer = new ParagraphRestorer();
        paragraphRestorer.setSuccessor(sentenceRestorer);
/**
 * text restorer.
 */
        AbstractRestorer textRestorer = new TextRestorer();
        textRestorer.setSuccessor(paragraphRestorer);

        return textRestorer;
    }
}
