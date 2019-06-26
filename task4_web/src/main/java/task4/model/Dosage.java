/*
 * class: Dosage
 */

package main.java.task4.model;

/**
 * Represents dosage of concrete medicine version.
 * @author AlesyaHlushakova
 */
public class Dosage {
    /**
     * amount.
     */
    private String amount;
    /**
     * frequency.
     */
    private String frequency;

    /**
     * getter for amount.
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * setter for amount.
     * @param newAmount amount
     */
    public void setAmount(final String newAmount) {
        this.amount = newAmount;
    }

    /**
     * getter for frequency.
     * @return frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * setter for frequency.
     * @param newFrequency frequency
     */
    public void setFrequency(final String newFrequency) {
        this.frequency = newFrequency;
    }

    /**
     * method overrides equals.
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Dosage dosage = (Dosage) obj;
        if (amount == null) {
            if (dosage.amount != null) {
                return false;
            }
        } else if (!amount.equals(dosage.amount)) {
            return false;
        }
        if (frequency == null) {
            if (dosage.frequency != null) {
                return false;
            }
        } else if (!frequency.equals(dosage.frequency)) {
            return false;
        }
        return true;
    }

    /**
     * method overrides hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += amount == null ? 0 : amount.hashCode();
        hashCode += frequency == null ? 0 : frequency.hashCode();
        return hashCode;
    }

    /**
     * overrides to string.
     * @return string
     */
    @Override
    public String toString() {
        return "\n        " + getClass().getSimpleName() + ":"
                + "\n            amount:    " + amount
                + "\n            frequency: " + frequency;
    }
}


