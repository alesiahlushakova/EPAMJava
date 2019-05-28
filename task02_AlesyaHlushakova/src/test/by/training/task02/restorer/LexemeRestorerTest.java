package test.by.training.task02.restorer;

import by.training.task02.composite.Particle;
import by.training.task02.restorer.AbstractRestorer;
import by.training.task02.restorer.LexemeRestorer;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * @author Alesyahlushakova
 * lexeme restorer tests.
 */
public class LexemeRestorerTest {
    /**
     * word.
     */
    private static final String WORD_STRING = "word";
    /**
     * lexeme.
     */
    private static final Particle WORD = Particle.word("word");
    /**
     * restorer.
     */
    private final AbstractRestorer restorer = new LexemeRestorer();


    /**
     * tests restorer.
     */
    @Test (description = "should return word value when word supplied")
    public void lexemeRestorer() {
        String restoredWord = restorer.restore(WORD);
        Assert.assertEquals(restoredWord, WORD_STRING);
    }
}
