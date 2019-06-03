package by.training.task02.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 * class composite.
 */
public class Composite implements Component {
    /**
     * component list.
     */
    private List<Component> components;

    /**
     * empty constructor.
     */
    public Composite() {
        components = new ArrayList<>();
    }

    /**
     * removes component.
     * @param component component
     */
    @Override
    public void remove(final Component component) {
        components.remove(component);
    }

    /**
     * adds component.
     * @param component component
     */
    @Override
    public void add(final Component component) {
        components.add(component);
    }

    /**
     * gets children.
     * @return children
     */
    @Override
    public List<Component> getChildren() {
        return components;
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
        if (o == null || getClass()
                != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components,
                composite.components);
    }

    /**
     * method overrides hash code.
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    /**
     * method overrides toString.
     * @return component
     */
    @Override
    public String toString() {
        return components.toString();
    }
}
