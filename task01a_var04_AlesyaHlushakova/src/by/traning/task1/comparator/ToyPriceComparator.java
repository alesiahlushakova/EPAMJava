package by.traning.task1.comparator;

import by.traning.task1.entity.Toy;

import java.util.Comparator;
/**
 * @author  AlesyaHlushakova
 * class comparator by toy price
 */
public class ToyPriceComparator implements Comparator<Toy> {
    /**
     * method overrides comparator by price.
     * @param o1  first toy
     * @param o2 second toy
     * @return difference between 2 prices
     */
    @Override
    public int compare(final Toy o1, final Toy o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

}
