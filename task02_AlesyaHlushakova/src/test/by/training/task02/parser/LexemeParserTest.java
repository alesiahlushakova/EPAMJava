package test.by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.parser.LexemeParser;
import by.training.task02.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Alesyahlushakova
 * lexeme parser tests.
 */


public class LexemeParserTest {
    /**
     * word.
     */
    private static final String WORD = "apple";
    /**
     * lexeme parser.
     */
    private final Parser lexemeParser = new LexemeParser();

    /**
     * lexeme parser test.
     */
    @Test(description = "should return word lexeme when word string supplied")
    public void parseShouldReturnWordLexemeWhenWordStringSupplied() {

        Component parsedLexeme = lexemeParser.parse(WORD);
        Assert.assertEquals(parsedLexeme.toString(), WORD);
    }
}
