package by.training.task02.parser;

import by.training.task02.composite.Component;

/**
 * @author Alesuahlushakova
 * parser interface.
 */
public interface Parser {
    /**
     * method parse.
     * @param text text
     * @return component
     */
    Component parse(String text);
}
