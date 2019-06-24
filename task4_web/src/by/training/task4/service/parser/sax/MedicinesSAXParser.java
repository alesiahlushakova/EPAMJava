/*
 * class: MedicinesSAXParser
 */

package by.training.task4.service.parser.sax;

import java.io.*;


import by.training.task4.service.factory.MedicinesAbstractParser;
import by.training.task4.service.validator.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Class MedicinesDOMParser extends abstract class
 * {@link MedicinesAbstractParser}, serves for building set of Medicine objects
 * based on XML-document by parser it using SAX-parser for XML
 *
 *
 * @author AlesyaHlushakova
 */
public class MedicinesSAXParser extends MedicinesAbstractParser {


    private SAXHandler handler;
    private XMLReader reader;
    
    public MedicinesSAXParser() {
        handler = new SAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {

        }
    }

    /**
     * Parses XML-document using SAX-parser, gets set of Medicine objects built
     * by {@link SAXHandler}
     * 
     * @param xml - path to XML-document to parse
     * @return true - if parser was successful; false - if there occurred any
     * kind of exception during XML-document parser
     */
    @Override
    public boolean buildSetMedicins(String xml, String xsd)
            throws IOException, SAXException {
        if (XMLValidator.validate(xml, xsd)) {
            InputSource source = new InputSource(new InputStreamReader(new FileInputStream(xml), "UTF-8"));
            reader.parse(source);
            medicins = handler.getMedicins();
            return true;
        }
        return false;
    }
}
