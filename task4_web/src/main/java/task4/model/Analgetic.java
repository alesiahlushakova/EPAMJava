/*
 * class: Analgetic
 */

package main.java.task4.model;

/**
 * Concrete class that represents analgetic-type medicine.
 * @author AlesyaHlushakova
 */
public class Analgetic extends Medicine {
    /**
     * narcotic medicine.
     */
    private boolean narcotic;

    /**
     * method detects if medicine is narcotic.
     * @return narcotic
     */
    public boolean isNarcotic() {
        return narcotic;
    }

    /**
     * setter for narcotic.
     * @param newNarcotic narcotic
     */
    public void setNarcotic(final boolean newNarcotic) {
        this.narcotic = newNarcotic;
    }

    /**
     * method overrides equals.
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Analgetic analgetic = (Analgetic) obj;
        if (narcotic != analgetic.narcotic) {
            return false;
        }
        return true;
    }

    /**
     * method overrides hash code.
     * @return
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += super.hashCode();
        hashCode += narcotic ? 1 : 0;
        return hashCode;
    }

    /**
     * method overrides to string.
     * @return
     */
    @Override
    public String toString() {
        return super.toString()
                + ", narcotic: " + narcotic + "\n";
    }
}


