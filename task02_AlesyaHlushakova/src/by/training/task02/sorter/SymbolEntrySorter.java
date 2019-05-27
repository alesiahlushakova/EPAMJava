package by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;

import java.util.Comparator;

/**
 * @author AlesyaHlushakova
 * sorter.
 */
public class SymbolEntrySorter extends AbstractSorter {
    /**
     * sorting symbol.
     */
    private final char symbol;

    /**
     * constructor.
     * @param symbol symbol
     */
    public SymbolEntrySorter(final char symbol) {
        this.symbol = symbol;
    }

    /**
     * sorting method.
     * @param sentence
     * @return
     */
    @Override
    public Component sort(final Component sentence) {
        Comparator<Particle> symbolEntryCountComparator = Comparator
                .comparing(this::countNumberOfEntries)
                .thenComparing(lexeme -> lexeme.getValue().toLowerCase());
        return sortLexemesInSentence(sentence, symbolEntryCountComparator);
    }

    /**
     * method counts number of entries.
     * @param lexeme lexeme
     * @return number
     */
    private long countNumberOfEntries(final Particle lexeme) {
        String value = lexeme.getValue();
        return value
                .chars()
                .map(character -> (char) character)
                .filter(character -> character == symbol)
                .count();
    }
}
