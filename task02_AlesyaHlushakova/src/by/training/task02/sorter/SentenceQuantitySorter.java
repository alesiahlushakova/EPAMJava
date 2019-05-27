package by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;

import java.util.Comparator;
import java.util.List;

/**
 * @author Alesyahlushakova
 */
public class SentenceQuantitySorter implements Sorter {
    /**
     * comparator.
     */
    private final Comparator<Component> SENTENCE_QUANTITY_COMPARATOR
            = Comparator
            .comparing(component -> component.getChildren().size());

    /**
     * sorting method.
     * @param text text
     * @return component
     */
    @Override
    public Component sort(final Component text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(SENTENCE_QUANTITY_COMPARATOR);
        Component sortedText = new Composite();
        paragraphs.forEach(sortedText::add);
        return sortedText;
    }
}
