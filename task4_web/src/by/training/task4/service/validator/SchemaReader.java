/*
 * class: SchemaReader
 */

package by.training.task4.service.validator;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/**
 * Utility class gives simplified way to get Schema object for XSD document
 *
 *
 * @author AlesyaHlushakova
 */
public abstract class SchemaReader {
    
    /**
     * @param xsd - path to XSD file
     * @return {@link Schema} object builded by parser passed XSD file
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