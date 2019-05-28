package test.by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.parser.AbstractParser;
import by.training.task02.parser.TextParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Alesyahlushakova
 * text parser tests.
 */
public class TextParserTest {
    /**
     * text.
     */
    private static final String TEXT = "There are many.\n"
            + "But the majority?";

    /**
     * text parser test.
     */
    @Test (description = "should return text composite correct text supplied")
    public void textParser() {
        AbstractParser paragraphParser = mock(AbstractParser.class);
        Component firstParagraph = new Composite();
        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("There"));
        firstSentence.add(Particle.word("are"));
        firstSentence.add(Particle.word("many"));
        firstParagraph.add(firstSentence);
        when(paragraphParser.parse("There are many.")).
                thenReturn(firstParagraph);
        Component secondParagraph = new Composite();
        Component secondSentence = new Composite();
        secondSentence.add(Particle.word("But"));
        secondSentence.add(Particle.word("the"));
        secondSentence.add(Particle.word("majority"));
        secondParagraph.add(secondSentence);
        when(paragraphParser.parse("But the majority?")).
                thenReturn(secondParagraph);

        AbstractParser textParser = new TextParser();
        textParser.setSuccessor(paragraphParser);
        Component parsedText = textParser.parse(TEXT);
        List<Component> paragraphList = parsedText.getChildren();

        List<Component> expectedList = Arrays.asList(
                firstParagraph,
                secondParagraph
        );

        Assert.assertEquals(paragraphList, expectedList);


    }
}
