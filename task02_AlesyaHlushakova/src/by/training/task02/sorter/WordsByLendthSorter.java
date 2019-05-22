package by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;

import java.util.Comparator;
import java.util.List;

/**
 * @author Alesyahlushakova
 */
public class WordsByLendthSorter extends AbstractSorter {
    /**
     * comparator.
     */
    private static final Comparator<Particle> LEXEME_LENGTH_COMPARATOR = Comparator
            .comparing(lexeme -> lexeme.getValue().length());

    /**
     * sorting method.
     * @param text text
     * @return component
     */
    @Override
    public Component sort(Component text) {
        Component sortedText = new Composite();
        List<Component> paragraphs = text.getChildren();
        for (Component paragraph : paragraphs) {
            Component sortedParagraph = sortSentences(paragraph);
            sortedText.add(sortedParagraph);
        }
        return sortedText;
    }

    /**
     * sort sentences.
     * @param paragraph paragraph
     * @return component
     */
    private Component sortSentences(Component paragraph) {
        List<Component> sentences = paragraph.getChildren();
        Component sortedParagraph = new Composite();
        for (Component sentence : sentences) {
            Component sortedSentence = sortLexemesInSentence(sentence, LEXEME_LENGTH_COMPARATOR);
            sortedParagraph.add(sortedSentence);
        }
        return sortedParagraph;
    }
}
