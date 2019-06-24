package by.training.task4.service.parser.constants;

/**
 * @author Alesya Hlushakova
 * Serves as enumeration of possible tag-attributes for XML elements.
 */
public enum AttributesEnum {

    NAME("name"),
    CAS("CAS"),
    DRUG_BANK("drug_bank"),
    RECIPE("recipe"),
    SOLUTION("solution"),
    NARCOTIC("narcotic"),
    SIZE("size"),
    ANALOG("analog");

    private String value;

    private AttributesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}