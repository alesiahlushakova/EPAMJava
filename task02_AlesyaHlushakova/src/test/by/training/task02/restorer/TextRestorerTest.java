package test.by.training.task02.restorer;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.restorer.AbstractRestorer;
import by.training.task02.restorer.TextRestorer;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * @author Alesyahlushakova
 * text restorer tests.
 */
public class TextRestorerTest {
    /**
     * text.
     */
    private static final String TEXT_STRING = "There are many.\n"
            + "But the majority.";

    /**
     * text restorer test.
     */
    @Test (description = "should return paragraph split by "
            + "new line symbol when paragraph component supplied")
    public void restoreShouldReturnParagraphsSpiltByNewLineSymbolWhenParagraphComponentSupplied() {
        AbstractRestorer paragraphRestorer = mock(AbstractRestorer.class);
        Component firstParagraph = new Composite();
        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("There"));
        firstSentence.add(Particle.word("are"));
        firstSentence.add(Particle.word("many"));
        firstParagraph.add(firstSentence);
        when(paragraphRestorer.restore(firstParagraph)).
                thenReturn("There are many.");
        Component secondParagraph = new Composite();
        Component secondSentence = new Composite();
        secondSentence.add(Particle.word("But"));
        secondSentence.add(Particle.word("the"));
        secondSentence.add(Particle.word("majority"));
        secondParagraph.add(secondSentence);
        when(paragraphRestorer.restore(secondParagraph)).
                thenReturn("But the majority.");

        Component text = new Composite();
        text.add(firstParagraph);
        text.add(secondParagraph);

        AbstractRestorer textRestorer = new TextRestorer();
        textRestorer.setSuccessor(paragraphRestorer);
        String restoredText = textRestorer.restore(text);

        Assert.assertEquals(restoredText, TEXT_STRING);
        verify(paragraphRestorer).restore(firstParagraph);
        verify(paragraphRestorer).restore(secondParagraph);
        verifyNoMoreInteractions(paragraphRestorer);
    }
}
