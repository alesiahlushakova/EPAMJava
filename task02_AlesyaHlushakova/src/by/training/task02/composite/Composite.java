package by.training.task02.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component{
    private List<Component> components;

    public Composite() {
        components = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
