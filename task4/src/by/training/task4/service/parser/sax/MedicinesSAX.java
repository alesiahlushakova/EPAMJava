package by.training.task4.service.parser.sax;
import java.io.*;

import by.training.task4.service.factory.MedicinesAbstractBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
/**
 * Class MedicinsDOMBuilder extends abstract class
 * , serves for building set of Medicine objects
 * based on XML-document by parsing it using SAX-parser for XML
 */
public class MedicinesSAX extends MedicinesAbstractBuilder {



    private SAXParser handler;
    private XMLReader reader;

    public MedicinesSAX() {
        handler = new SAXParser();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
          //  LOG.error("SAX parser error: ", e);
        }
    }

    /**
     * Parses XML-document using SAX-parser, gets set of Medicine objects built
     * @param xml - path to XML-document to parse
     * @return true - if parsing was successful; false - if there occurred any
     * kind of exception during XML-document parsing
     */
    @Override
    public boolean buildSetMedicines(String xml, String xsd)
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
