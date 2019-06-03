package by.training.task02.composite;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 * class with text components.
 */
public class Particle implements  Component {
    /**
     * value.
     */
    private String value;


    /**
     * constructor.
     * @param value value
     */
    private Particle(final String value) {
        this.value = value;
    }

    /**
     * word.
     * @param value value
     * @return particle
     */
    public static Particle word(final String value) {
        return new Particle(value);
    }


    /**
     * method overrides removing of component.
     * @param component component
     */
    @Override
    public void remove(final Component component) {
    }

    /**
     * method overrides add component.
     * @param component component
     */
    @Override
    public void add(final Component component) {
    }

    /**
     * gets children.
     * @return list
     */
    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    /**
     * gets value of string.
     * @return value
     */
    public String getValue() {
        return value;
    }



    /**
     * method overrides equals.
     * @param o comparable object
     * @return is equal
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Particle lexeme = (Particle) o;
        return Objects.equals(value, lexeme.value);
    }

    /**
     * method overrides hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * overrides toString.
     * @return value
     */
    @Override
    public String toString() {
        return value;
    }
}


