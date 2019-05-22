package by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alesyahlushakova
 * abstract sorter.
 */
public abstract class AbstractSorter implements Sorter {
    /**
     * sorts words in sentence.
     * @param sentence sentence
     * @param comparator comparator
     * @return component
     */
    protected Component sortLexemesInSentence(Component sentence,
                                              Comparator<Particle> comparator) {
        List<Component> children = sentence.getChildren();
        List<Particle> sortedLexemes = children
                .stream()
                .map(component -> (Particle) component)
                .sorted(comparator)
                .collect(Collectors.toList());
        Component sortedSentence = new Composite();
        sortedLexemes.forEach(sortedSentence::add);
        return sortedSentence;
    }
}
