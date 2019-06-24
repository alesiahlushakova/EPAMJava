package test.by.training.task4service.validation;

import by.training.task4.service.validator.XMLValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class XMLValidatorTest {
    
    public static final String VALID_XML = "validTest.xml";
    public static final String INVALID_XML = "invalidTest.xml";

    @Test
    public void validatePositiveTest() {
        boolean actual = XMLValidator.validate(VALID_XML,"Medicins.xsd");
        Assert.assertTrue(actual);
    }

    @Test
    public void validateNegativeTest() {
        boolean actual = XMLValidator.validate(INVALID_XML, "Medicins.xsd");
        Assert.assertFalse(actual);
    }
}
