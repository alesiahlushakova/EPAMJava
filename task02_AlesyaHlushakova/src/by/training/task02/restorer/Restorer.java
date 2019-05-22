package by.training.task02.restorer;

import by.training.task02.composite.Component;

/**
 * @author Alesyahlushakova
 * restorer interface
 */
public interface Restorer {
    /**
     * restoration method.
     * @param element element
     * @return string
     */
    String restore(Component element);
}
