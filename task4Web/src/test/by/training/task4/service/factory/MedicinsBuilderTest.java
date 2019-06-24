package test.by.training.task4.service.factory;

import by.training.task4.exception.ParserException;
import by.training.task4.service.factory.MedicineParserFactory;
import by.training.task4.service.factory.MedicinesAbstractBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedicinsBuilderTest {
    private static final String UNDEFINED_PARSER = "undefined parser";

    private MedicineParserFactory factory;

    @Test(dataProvider = "parsers")
    public void getBuilderTest(String name) throws ParserException {
        MedicinesAbstractBuilder builder = factory.getBuilder(name);
        String actual = builder.getClass()
                .getSimpleName()
                .replaceAll("(Medicins)|(Builder)", "")
                .toUpperCase();
        String expected = name;
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ParserException.class)
    public void getBuilderExceptionTest() throws ParserException {
        factory.getBuilder(UNDEFINED_PARSER);
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
        factory = new MedicineParserFactory();
    }

    @AfterClass
    public void afterClass() {
        factory = null;
    }
}
