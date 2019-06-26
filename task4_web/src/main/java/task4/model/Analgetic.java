/*
 * class: Analgetic
 */

package main.java.task4.model;

/**
 * Concrete class that represents analgetic-type medicine
 *
 *
 * @author AlesyaHlushakova
 */
public class Analgetic extends Medicine {

    private boolean narcotic;

    public boolean isNarcotic() {
        return narcotic;
    }

    public void setNarcotic(boolean narcotic) {
        this.narcotic = narcotic;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) { return false; }
        Analgetic analgetic = (Analgetic) obj;
        if (narcotic != analgetic.narcotic) { return false; }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += super.hashCode();
        hashCode += narcotic ? 1 : 0;
        return hashCode;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + ", narcotic: " + narcotic + "\n";
    }
}