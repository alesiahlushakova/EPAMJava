package by.training.task4.service.validation;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Utility class gives simplified way to get Schema object for XSD document
 *
 * @author AlesyaHulshakova
 */
public abstract class SchemaReader {

    /**
     * @param xsd - path to XSD file
     * @return  object builded by parsing passed XSD file
     * @throws SAXException
     */
    public static Schema getSchema(String xsd) throws SAXException {
        Schema schema = null;
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory sf = SchemaFactory.newInstance(lang);
        schema = sf.newSchema(new File(xsd));
        return schema;
    }
}