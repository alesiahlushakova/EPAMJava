package test.by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Particle;
import by.training.task02.parser.AbstractParser;
import by.training.task02.parser.SentenceParser;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alesyahlushakova
 * sentence parser tests.
 */
public class SentenceParserTest {
    /**
     * sentence.
     */
    private static final String SENTENCE = "Lorem sit, ";

    /**
     * sentence parser test.
     */
    @Test (description = "should return sentence component"
            + " when correct sentence supplied")
    public void sentenceParser() {
        AbstractParser lexemeParser = mock(AbstractParser.class);

        when(lexemeParser.parse("Lorem")).thenReturn(Particle.word("Lorem"));

        when(lexemeParser.parse("sit")).thenReturn(Particle.word("sit"));


        AbstractParser sentenceParser = new SentenceParser();
        sentenceParser.setSuccessor(lexemeParser);
        Component sentenceComponent = sentenceParser.parse(SENTENCE);
        List<Component> wordsList = sentenceComponent.getChildren();

        List<Component> expectedList = Arrays.asList(
                Particle.word("Lorem"),
                Particle.word("sit")
        );

        Assert.assertEquals(wordsList, expectedList);
        verify(lexemeParser, times(expectedList.size())).parse(anyString());
        verifyNoMoreInteractions(lexemeParser);
    }
}
