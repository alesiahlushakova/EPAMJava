/*
 * class: XMLValidator
 */

package main.java.task4.service.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * Provides easy way to validate XML document by XSD schema.
 * @author AlesyaHlushakova
 */
public class XMLValidator {
/**
 * constructor.
 */
    private static final Logger LOG = LogManager.
            getLogger(XMLValidator.class);

    /**
     * Tries to validate XML document located on the specified path using XSD.
     * @param xml - path to XML document
     * @param xsd schema
     * @return true - if validator was successful, else - returns false;
     */
    public static boolean validate(final String xml,
                                   final String xsd) {
        Schema schema = null;
        try {
            schema = SchemaReader.getSchema(xsd);
            javax.xml.validation.Validator validator = schema.newValidator();
            Source source = new StreamSource(new File(xml));
            validator.validate(source);
            LOG.info(xml + " is valid\n");
            return true;
        } catch (IOException e) {
            LOG.info("I/O exception: ", e);
        } catch (SAXException e) {
            LOG.info("SAX exception: ", e);
        }
            LOG.info(xml + " is invalid\n");
        return false;
    }
}

