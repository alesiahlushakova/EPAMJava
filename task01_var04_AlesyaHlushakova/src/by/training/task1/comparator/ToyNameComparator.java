package by.training.task1.comparator;

import by.training.task1.entity.Toy;

import java.util.Comparator;

/**
 * @author  AlesyaHlushakova
 * class comparator by toy name
 */
public class ToyNameComparator implements Comparator<Toy> {
    /**
     * method overrides comparator by name.
     * @param o1  first toy
     * @param o2 second toy
     * @return difference between 2 names
     */
    @Override
    public int compare(final Toy o1, final Toy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
