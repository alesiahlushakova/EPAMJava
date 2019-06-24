/*
 * class: Attributes
 */

package by.training.task4.service.parser;

/**
 * Serves as enumeration of possible tag-attributes for XML elements
 *
 *
 * @author AlesyaHlushakova
 */
public enum Attributes {

    NAME("name"),
    CAS("CAS"),
    DRUG_BANK("drug_bank"),
    RECIPE("recipe"),
    SOLUTION("solution"),
    NARCOTIC("narcotic"),
    SIZE("size"),
    ANALOG("analog");
    
    private String value;
    
    private Attributes(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
