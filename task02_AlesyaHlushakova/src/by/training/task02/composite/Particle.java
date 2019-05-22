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
     * constructor
     * @param value value
     */
    private Particle(String value) {
        this.value = value;
    }

    /**
     * word
     * @param value
     * @return
     */
    public static Particle word(String value) {
        return new Particle(value);
    }


    /**
     * method overrides add component.
     * @param component component
     */
    @Override
    public void add(Component component) {
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
     * method overrides equals
     * @param o comparable object
     * @return is equal
     */
    @Override
    public boolean equals(Object o) {
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
