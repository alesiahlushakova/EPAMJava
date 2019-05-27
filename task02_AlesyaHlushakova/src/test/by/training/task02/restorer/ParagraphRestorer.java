package test.by.training.task02.restorer;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.restorer.AbstractRestorer;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * @author Alesyahlushakova
 * paragraph restorer tests.
 */
public class ParagraphRestorer {
    /**
     * paragraph string.
     */
    private static final String PARAGRAPH_STRING = "Nam gam. "
            + "Sed li.";

    /**
     * paragraph restorer test.
     */
    @Test (description = "should return sentences split"
            + " by dot when different sentences supplied")
    public void restoreShouldReturnSentencesSplitByDotWhenDifferentSentencesSupplied() {
        AbstractRestorer sentenceRestorer = mock(AbstractRestorer.class);
        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("Nam"));
        firstSentence.add(Particle.word("gam"));
        when(sentenceRestorer.restore(firstSentence)).thenReturn("Nam gam");
        Component secondSentence = new Composite();
        secondSentence.add(Particle.word("Sed"));
        secondSentence.add(Particle.word("li"));
        when(sentenceRestorer.restore(secondSentence)).thenReturn("Sed li");

        Component paragraph = new Composite();
        paragraph.add(firstSentence);
        paragraph.add(secondSentence);

        AbstractRestorer paragraphRestorer =
                new by.training.task02.restorer.ParagraphRestorer();
        paragraphRestorer.setSuccessor(sentenceRestorer);
        String restoredParagraph = paragraphRestorer.restore(paragraph);

        Assert.assertEquals(restoredParagraph, PARAGRAPH_STRING);
        verify(sentenceRestorer).restore(firstSentence);
        verify(sentenceRestorer).restore(secondSentence);
        verifyNoMoreInteractions(sentenceRestorer);
    }
}
