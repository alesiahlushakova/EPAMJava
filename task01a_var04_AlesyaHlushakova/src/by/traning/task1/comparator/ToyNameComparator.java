package by.traning.task1.comparator;

import by.traning.task1.entity.Toy;

import java.util.Comparator;

/**
 * @author  AlesyaHlushakova
 * class comparator by toy name
 */
public class ToyNameComparator implements Comparator<Toy> {
    @Override
    public int compare(final Toy o1, final Toy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
