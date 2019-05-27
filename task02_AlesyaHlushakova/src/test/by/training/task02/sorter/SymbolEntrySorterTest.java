package test.by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.sorter.Sorter;
import by.training.task02.sorter.SymbolEntrySorter;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author AlesyaHlushakova
 * sorter by symbol entry test.
 */
public class SymbolEntrySorterTest {
    /**
     * expected symbol.
     */
    private static final char DESIRED_SYMBOL = 'a';

    /**
     * symbol entry sorter test.
     */
    @Test (description = "should sort lexemes in "
            + "natural order when sentence supplied")
    public void sortShouldSortLexemesInNaturalOrderWhenSentenceSupplied() {
        Component sentence = new Composite();
        sentence.add(Particle.word("bbaaaa"));
        sentence.add(Particle.word("cdb"));
        sentence.add(Particle.word("caaaaaaa"));
        sentence.add(Particle.word("aaaa"));

        Component expectedSentence = new Composite();
        expectedSentence.add(Particle.word("cdb"));
        expectedSentence.add(Particle.word("aaaa"));
        expectedSentence.add(Particle.word("bbaaaa"));
        expectedSentence.add(Particle.word("caaaaaaa"));

        Sorter sorter = new SymbolEntrySorter(DESIRED_SYMBOL);
        Component sortedSentence = sorter.sort(sentence);

        Assert.assertEquals(sortedSentence, expectedSentence);
    }
}
