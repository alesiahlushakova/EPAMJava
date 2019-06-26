/*
 * class: Elements
 */

package main.java.task4.service.parser;

/**
 * Serves as enumeration of possible XML elements and their String values.
 * @author AlesyaHlushakova
 */
public enum Elements {
    /**
     * medicines.
     */
    MEDICINS("Medicins"),
    /**
     * antibiotic.
     */
    ANTIBIOTIC("Antibiotic"),
    /**
     * vitamin.
     */
    VITAMIN("Vitamin"),
    /**
     * analgetic.
     */
    ANALGETIC("Analgetic"),
    /**
     * version.
     */
    VERSION("Version"),
    /**
     * certificate.
     */
    CERTIFICATE("Certificate"),
    /**
     * package.
     */
    PACKAGE("Package"),
    /**
     * dosage.
     */
    DOSAGE("Dosage"),
    /**
     * pharmacy.
     */
    PHARM("Pharm"),
    /**
     * producer.
     */
    PRODUCER("Producer"),
    /**
     * form.
     */
    FORM("Form"),
    /**
     * registered by.
     */
    REGISTERED_BY("Registered_by"),
    /**
     * registration date.
     */
    REGISTRATION_DATE("Registration_date"),
    /**
     * expiration date.
     */
    EXPIRATION_DATE("Expiration_date"),
    /**
     * quantity.
     */
    QUANTITY("Quantity"),
    /**
     * price.
     */
    PRICE("Price"),
    /**
     * amount.
     */
    AMOUNT("Amount"),
    /**
     * frequency.
     */
    FREQUENCY("Frequency");
    /**
     * value.
     */
    private String value;

    /**
     * constructor.
     * @param newValue element value
     */
    Elements(final String newValue) {
        this.value = newValue;
    }

    /**
     * getter for value.
     * @return value
     */
    public String getValue() {
        return value;
    }
}


