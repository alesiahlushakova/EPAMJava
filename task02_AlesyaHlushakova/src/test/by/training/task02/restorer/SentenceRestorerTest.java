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
 * sentence restorer tests.
 */
public class SentenceRestorerTest {
    /**
     * sentence.
     */
    private static final String SENTENCE_STRING = "Lorem sit";
    /**
     * quantity of words.
     */
    private static final int NUMBER_OF_WORDS = 2;

    /**
     * sentence restorer test.
     */
    @Test (description = "should return restored sentence")
    public void sentenceRestorer() {
        AbstractRestorer lexemeRestorer = mock(AbstractRestorer.class);

        when(lexemeRestorer.restore(Particle.word("Lorem"))).
                thenReturn("Lorem");
        when(lexemeRestorer.restore(Particle.word("sit"))).
                thenReturn("sit");


        Component sentence = new Composite();
        sentence.add(Particle.word("Lorem"));
        sentence.add(Particle.word("sit"));

        AbstractRestorer restorer = new by.training.task02.restorer.
                SentenceRestorer();
        restorer.setSuccessor(lexemeRestorer);
        String restoredSentence = restorer.restore(sentence);

        Assert.assertEquals(restoredSentence, SENTENCE_STRING);
        verify(lexemeRestorer, times(NUMBER_OF_WORDS)).
                restore(any(Component.class));
        verifyNoMoreInteractions(lexemeRestorer);
    }
}
