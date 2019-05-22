package by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;

import java.util.Comparator;

public class SymbolEntrySorter extends AbstractSorter {
    private final char symbol;

    public SymbolEntrySorter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public Component sort(Component sentence) {
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
    private long countNumberOfEntries(Particle lexeme) {
        String value = lexeme.getValue();
        return value
                .chars()
                .map(character -> (char) character)
                .filter(character -> character == symbol)
                .count();
    }
}
