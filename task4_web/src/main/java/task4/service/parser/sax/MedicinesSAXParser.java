/*
 * class: MedicinesSAXParser
 */

package main.java.task4.service.parser.sax;

import java.io.*;


import main.java.task4.service.factory.MedicinesAbstractParser;
import main.java.task4.service.validator.XMLValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * Class MedicinesDOMParser extends abstract class.
 * {@link MedicinesAbstractParser}, serves for building set of Medicine objects.
 * based on XML-document by parser it using SAX-parser for XML.
 * @author AlesyaHlushakova
 */
public class MedicinesSAXParser extends MedicinesAbstractParser {
    /**
     * logger intro.
     */
    private static final Logger LOG = LogManager.
            getLogger(MedicinesSAXParser.class);
    /**
     * handler.
     */
    private SAXHandler handler;
    /**
     * reader.
     */
    private XMLReader reader;

    /**
     * constructor.
     */
    public MedicinesSAXParser() {
        handler = new SAXHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOG.error("SAX parser exception " + e.getMessage());
        }
    }

    /**
     * Parses XML-document using SAX-parser, gets set of Medicine objects built.
     * @param xml - path to XML-document to parse
     * @return true - if parser was successful; false - if there occurred any
     * kind of exception during XML-document parser.
     */
    @Override
    public boolean buildSetMedicines(final String xml, final String xsd)
            throws IOException, SAXException {
        if (XMLValidator.validate(xml, xsd)) {
            InputSource source = new InputSource(
                    new InputStreamReader(new FileInputStream(xml), "UTF-8"));
            reader.parse(source);
            medicins = handler.getMedicines();
            return true;
        }
        return false;
    }
}


