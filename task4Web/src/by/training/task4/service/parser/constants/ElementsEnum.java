package by.training.task4.service.parser.constants;

/**
 * Serves as enumeration of possible XML elements and their String values.
 * @author Alesyahulshakova
 */
public enum ElementsEnum {

    MEDICINES("Medicines"),
    ANTIBIOTIC("Antibiotic"),
    VITAMIN("Vitamin"),
    ANALGETIC("Analgetic"),
    VERSION("Version"),
    CERTIFICATE("Certificate"),
    PACKAGE("Package"),
    DOSAGE("Dosage"),
    PHARM("Pharm"),
    PRODUCER("Producer"),
    FORM("Form"),
    REGISTRED_BY("Registered_by"),
    REGISTRATION_DATE("Registration_date"),
    EXPIRATION_DATE("Expiration_date"),
    QUANTITY("Quantity"),
    PRICE("Price"),
    AMOUNT("Amount"),
    FREQUENCY("Frequency");

    private String value;

    ElementsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
