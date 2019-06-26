/*
 * class: Attributes
 */

package main.java.task4.service.parser;

/**
 * Serves as enumeration of possible tag-attributes for XML elements.
 * @author AlesyaHlushakova
 */
public enum Attributes {
    /**
     * name.
     */
    NAME("name"),
    /**
     * id.
     */
    CAS("CAS"),
    /**
     * drug bank.
     */
    DRUG_BANK("drug_bank"),
    /**
     * recipe.
     */
    RECIPE("recipe"),
    /**
     * solution.
     */
    SOLUTION("solution"),
    /**
     * narcotic.
     */
    NARCOTIC("narcotic"),
    /**
     * size.
     */
    SIZE("size"),
    /**
     * analog.
     */
    ANALOG("analog");
    /**
     * value.
     */
    private String value;

    /**
     * private constructor.
     * @param newValue attribute value.
     */
    Attributes(final String newValue) {
        this.value = value;
    }

    /**
     * getter for value.
     * @return attribute
     */
    public String getValue() {
        return value;
    }
}


