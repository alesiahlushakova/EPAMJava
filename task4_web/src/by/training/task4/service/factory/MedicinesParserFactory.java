/*
 * class: MedicinesParserFactory
 */

package by.training.task4.service.factory;

import by.training.task4.exception.ParserNotFoundException;
import by.training.task4.service.parser.dom.MedicinesDOMParser;
import by.training.task4.service.parser.sax.MedicinesSAXParser;
import by.training.task4.service.parser.stax.MedicinesSTAXParser;

/**
 * Factory class which serves for creation concrete medicines builder depending
 * on passed value
 *
 *
 * @author AlesyaHlushakova
 */
public class MedicinesParserFactory {
        
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
    public MedicinsAbstractParser getParser(String name)
            throws ParserNotFoundException {
        MedicinsAbstractParser parser = null;
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
                throw new ParserNotFoundException(
                        "There is not such parser: " + name);
        }
        return parser;
    }
}
