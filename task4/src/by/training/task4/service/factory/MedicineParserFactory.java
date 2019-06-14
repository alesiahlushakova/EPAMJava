package by.training.task4.service.factory;

import by.training.task4.exception.ParserException;
import by.training.task4.service.parser.dom.DOMParser;

/**
 * Factory class which serves for creation concrete medicines builder depending
 * on passed value
 *
 * @author AlesyaHulshakova
 */
public class MedicineParserFactory {

    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";

    /**
     * Factory method for creation concrete medicines builder
     *
     * @param name - name of parsing type which will be used to parse XML
     * document and build set of Medicine objects
     * @return concrete medicines builder
     * @throws ParserException
     */
    public MedicinesAbstractBuilder getBuilder(String name)
            throws ParserException {
        MedicinesAbstractBuilder builder = null;
        switch (name.toUpperCase()) {
            case SAX:
                builder = new MedicinesSAXBuilder();
                break;
            case DOM:
                builder = new DOMParser();
                break;
            case STAX:
                builder = new MedicinesStAXBuilder();
                break;
            default:
                throw new ParserException(
                        "There is not such parser: " + name);
        }
        return builder;
    }
}
