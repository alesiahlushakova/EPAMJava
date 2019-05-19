package by.training.task02.composite;

import java.util.List;

public interface Component {
    void add(Component component);

    List<Component> getChildren();
}
