/*
 * class: Vitamin
 */

package main.java.task4.model;

/**
 * Concrete class that represents vitamin-type medicine.
 * @author AlesyaHlushakova
 */
public class Vitamin extends Medicine {
    /**
     * solution.
     */
    private String solution;

    /**
     * getter for solution.
     * @return solution
     */
    public String getSolution() {
        return solution;
    }

    /**
     * setter for solution.
     * @param newSolution solution
     */
    public void setSolution(final String newSolution) {
        this.solution = newSolution;
    }

    /**
     * overrides equals.
     * @param obj comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Vitamin vitamin = (Vitamin) obj;
        if (solution == null) {
            if (vitamin.solution != null) {
                return false;
            }
        } else if (!solution.equals(vitamin.solution)) {
            return false;
        }
        return true;
    }

    /**
     * overrides hash.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += super.hashCode();
        hashCode += solution == null ? 0 : solution.hashCode();
        return hashCode;
    }

    /**
     * overrides to string.
     * @return string
     */
    @Override
    public String toString() {
        return super.toString()
                + ", solution: " + solution + "\n";
    }
}


