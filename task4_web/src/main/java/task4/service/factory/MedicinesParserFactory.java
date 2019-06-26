/*
 * class: MedicinesParserFactory
 */

package main.java.task4.service.factory;

import main.java.task4.exception.ParserNotFoundException;
import main.java.task4.service.parser.dom.MedicinesDOMParser;
import main.java.task4.service.parser.sax.MedicinesSAXParser;
import main.java.task4.service.parser.stax.MedicinesSTAXParser;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;




/**
 * Factory class which serves for creation concrete medicines builder depending
 * on passed value
 *
 *
 * @author AlesyaHlushakova
 */
public class MedicinesParserFactory {

    private static final Logger LOG = LogManager.
            getLogger(MedicinesParserFactory.class);

    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";

    /**
     * Factory method for creation concrete medicines builder
     * 
     * @param name - name of parser type which will be used to parse XML
     * document and build set of Medicine objects
     * @return concrete medicines builder
     * @throws ParserNotFoundException
     */
    public MedicinesAbstractParser getParser(String name)
            throws ParserNotFoundException {
        MedicinesAbstractParser parser = null;
        switch (name.toUpperCase()) {
            case SAX:

                parser = new MedicinesSAXParser();
                break;
            case DOM:
                parser = new MedicinesDOMParser();
                break;
            case STAX:
                parser = new MedicinesSTAXParser();
                break;
            default:
                LOG.info("gg");
                throw new ParserNotFoundException(
                        "There is not such parser: " + name);
        }
        return parser;
    }
}
