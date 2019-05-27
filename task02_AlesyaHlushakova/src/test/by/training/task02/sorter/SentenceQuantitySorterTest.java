package test.by.training.task02.sorter;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.sorter.SentenceQuantitySorter;
import by.training.task02.sorter.Sorter;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author AlesyaHlushakova
 * sorter by sentence quantity test.
 */
public class SentenceQuantitySorterTest {
    /**
     * sentence quantity sorter test.
     */
    @Test (description = "should sort in natural order correct text supplied")
    public void sortShouldSortInNaturalOrderWhenCorrectTextSupplied() {
        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("One"));
        firstSentence.add(Particle.word("two"));
        firstSentence.add(Particle.word("three"));
        Component secondSentence = new Composite();
        firstSentence.add(Particle.word("Four"));
        firstSentence.add(Particle.word("five"));
        firstSentence.add(Particle.word("six"));
        Component thirdSentence = new Composite();
        firstSentence.add(Particle.word("Seven"));
        firstSentence.add(Particle.word("eight"));
        firstSentence.add(Particle.word("nine"));

        Component firstParagraph = new Composite();
        firstParagraph.add(firstSentence);
        firstParagraph.add(secondSentence);
        Component secondParagraph = new Composite();
        secondParagraph.add(thirdSentence);

        Component text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);

        Sorter paragraphsSorter = new SentenceQuantitySorter();
        Component sortedText = paragraphsSorter.sort(text);

        Component expectedText = new Composite();
        expectedText.add(secondParagraph);
        expectedText.add(firstParagraph);

        Assert.assertEquals(sortedText, expectedText);
    }
}
