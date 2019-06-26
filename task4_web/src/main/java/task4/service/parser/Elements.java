/*
 * class: Elements
 */

package main.java.task4.service.parser;

/**
 * Serves as enumeration of possible XML elements and their String values
 *
 *
 * @author AlesyaHlushakova
 */
public enum Elements {

    MEDICINS("Medicins"),
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
    REGISTERED_BY("Registered_by"),
    REGISTRATION_DATE("Registration_date"),
    EXPIRATION_DATE("Expiration_date"),
    QUANTITY("Quantity"),
    PRICE("Price"),
    AMOUNT("Amount"),
    FREQUENCY("Frequency");
    
    private String value;
    
    private Elements(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
