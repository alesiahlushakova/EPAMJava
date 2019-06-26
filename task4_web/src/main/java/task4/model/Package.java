/*
 * class: Package
 */

package main.java.task4.model;

/**
 * Represents package form, size and price for concrete medicine version.
 * @author AlesyaHlushakova
 */
public class Package {
    /**
     * quantity.
     */
    private int quantity;
    /**
     * price.
     */
    private double price;
    /**
     * size.
     */
    private String size;

    /**
     * getter for quantity.
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * setter for quantity.
     * @param newQuantity quantity
     */
    public void setQuantity(final int newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * getter for price.
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * setter for price.
     * @param newPrice price
     */
    public void setPrice(final double newPrice) {
        this.price = newPrice;
    }

    /**
     * getter for size.
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * setter for size.
     * @param newSize size
     */
    public void setSize(final String newSize) {
        this.size = newSize;
    }

    /**
     * overrides equals.
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
        Package pack = (Package) obj;
        if (quantity != pack.quantity) {
            return false;
        }
        if (price != pack.price) {
            return false;
        }
        if (size == null) {
            if (pack.size != null) {
                return false;
            }
        } else if (!size.equals(pack.size)) {
            return false;
        }
        return true;
    }

    /**
     * overrides hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (int) (31 * (quantity + price));
        hashCode += size == null ? 0 : size.hashCode();
        return hashCode;
    }

    /**
     * overrides to string.
     * @return string
     */
    @Override
    public String toString() {
        return "\n        " + getClass().getSimpleName() + ":"
                + " size='" + size + "'"
                + "\n            quantity: " + quantity
                + "\n            price:    " + price;
    }
}


