/*
 * class: Antibiotic
 */

package main.java.task4.model;

/**
 * Concrete class that represents antibiotic-type medicine.
 * @author AlesyaHlushakova
 */
public class Antibiotic extends Medicine {
    /**
     * recipe.
     */
    private boolean recipe;

    /**
     * method checks is recipe determined.
     * @return is recipe
     */
    public boolean isRecipe() {
        return recipe;
    }

    /**
     * setter for recipe.
     * @param newRecipe recipe type
     */
    public void setRecipe(final boolean newRecipe) {
        this.recipe = newRecipe;
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
        Antibiotic antibiotic = (Antibiotic) obj;
        if (recipe != antibiotic.recipe) {
            return false;
        }
        return true;
    }

    /**
     * method overrides hash code.
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += super.hashCode();
        hashCode += recipe ? 1 : 0;
        return hashCode;
    }

    /**
     * method overrides to string.
     * @return
     */
    @Override
    public String toString() {
        return super.toString()
                + ", recipe: " + recipe + "\n";
    }
}


