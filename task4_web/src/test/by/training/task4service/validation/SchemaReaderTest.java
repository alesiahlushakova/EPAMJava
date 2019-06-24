package test.by.training.task4service.validation;


import by.training.task4.service.validator.SchemaReader;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class SchemaReaderTest {

    private static final String FICTIVE_FILE = "fictive_file";

    @Test(expectedExceptions = SAXException.class)
    public void getSchemaTest() throws SAXException {
        String xsd = FICTIVE_FILE;
        SchemaReader.getSchema(xsd);
    }
}