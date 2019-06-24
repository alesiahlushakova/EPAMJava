package test.by.training.task4service.factory;


import by.training.task4.exception.ParserNotFoundException;
import by.training.task4.service.factory.MedicinesAbstractParser;
import by.training.task4.service.factory.MedicinesParserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedicinesParserFactoryTest {

    private static final String UNDEFINED_PARSER = "undefined parser";

    private MedicinesParserFactory factory;

    @Test(dataProvider = "parsers")
    public void getBuilderTest(String name) throws ParserNotFoundException {
        MedicinesAbstractParser builder = factory.getParser(name);
        String actual = builder.getClass()
                               .getSimpleName()
                               .replaceAll("(Medicines)|(Parser)", "")
                               .toUpperCase();
        String expected = name;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParserNotFoundException.class)
    public void getBuilderExceptionTest() throws ParserNotFoundException {
        factory.getParser(UNDEFINED_PARSER);
    }

    @DataProvider(name = "parsers")
    public Object[][] createParsers() {
        return new Object[][] {
                new Object[] { "SAX" },
                new Object[] { "DOM" },
                new Object[] { "STAX" },
        };
    }

    @BeforeClass
    public void beforeClass() {
        factory = new MedicinesParserFactory();
    }

    @AfterClass
    public void afterClass() {
        factory = null;
    }
}
