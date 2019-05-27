package test.by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;
import by.training.task02.composite.Particle;
import by.training.task02.parser.AbstractParser;
import by.training.task02.parser.ParagraphParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Alesyahlushakova
 * paragraph parser tests.
 */
public class ParagraphParserTest {
    /**
     * paragraph.
     */
    private static final String PARAGRAPH = "Nam, gam. "
            + "Sed li? "
            + "Quisque... "
            + "Phasellus!";

    /**
     * paragraph parser test.
     */
    @Test (description = "should return paragraph composite"
            + " when correct paragraph supplied")
    public void parseShouldReturnParagraphCompositeWhenCorrectParagraphSupplied() {
        AbstractParser sentenceParser = mock(AbstractParser.class);

        Component firstSentence = new Composite();
        firstSentence.add(Particle.word("Nam"));
        firstSentence.add(Particle.word("gam"));
        when(sentenceParser.parse("Nam, gam")).thenReturn(firstSentence);

        Component secondSentence = new Composite();
        secondSentence.add(Particle.word("Sed"));
        secondSentence.add(Particle.word("li"));
        when(sentenceParser.parse("Sed li")).thenReturn(secondSentence);

        Component thirdSentence = new Composite();
        thirdSentence.add(Particle.word("Quisque"));
        when(sentenceParser.parse("Quisque")).thenReturn(thirdSentence);

        Component fourthSentence = new Composite();
        fourthSentence.add(Particle.word("Phasellus"));
        when(sentenceParser.parse("Phasellus")).thenReturn(fourthSentence);

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.setSuccessor(sentenceParser);
        Component paragraph = paragraphParser.parse(PARAGRAPH);
        List<Component> sentenceList = paragraph.getChildren();

        List<Component> expectedList = Arrays.asList(
                firstSentence,
                secondSentence,
                thirdSentence,
                fourthSentence
        );

        Assert.assertEquals(sentenceList, expectedList);

    }
}
