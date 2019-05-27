package test.by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.sorter.Sorter;
import by.training.task02.sorter.WordsByLengthSorter;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author AlesyaHlushakova
 * sorter by word length test.
 */
public class WordsByLengthSorterTest {
    /**
     * words by length sorter test.
     */
    @Test (description = "should sort words by length"
            + " when text composite supplied")
    public void sortShouldSortWordsByLengthWhenTextCompositeSupplied() {
        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("Hydrogen"));
        firstSentence.add(Particle.word("two"));
        firstSentence.add(Particle.word("plain"));
        Component secondSentence = new Composite();
        secondSentence.add(Particle.word("Sorted"));
        secondSentence.add(Particle.word("sentence"));
        secondSentence.add(Particle.word("not"));
        Component firstParagraph = new Composite();
        firstParagraph.add(firstSentence);
        Component secondParagraph = new Composite();
        secondParagraph.add(secondSentence);
        Component text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);

        Component firstExpectedSentence = new Composite();
        firstExpectedSentence.add(Particle.word("two"));
        firstExpectedSentence.add(Particle.word("plain"));
        firstExpectedSentence.add(Particle.word("Hydrogen"));
        Component secondExpectedSentence = new Composite();
        secondExpectedSentence.add(Particle.word("not"));
        secondExpectedSentence.add(Particle.word("Sorted"));
        secondExpectedSentence.add(Particle.word("sentence"));
        Component firstExpectedParagraph = new Composite();
        firstExpectedParagraph.add(firstExpectedSentence);
        Component secondExpectedParagraph = new Composite();
        secondExpectedParagraph.add(secondExpectedSentence);
        Component expectedText = new Composite();
        expectedText.add(firstExpectedParagraph);
        expectedText.add(secondExpectedParagraph);

        Sorter sorter = new WordsByLengthSorter();
        Component sortedText = sorter.sort(text);

        Assert.assertEquals(sortedText, expectedText);
    }
}
