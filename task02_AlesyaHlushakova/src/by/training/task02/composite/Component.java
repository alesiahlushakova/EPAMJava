package by.training.task02.composite;

import java.util.List;

/**
 * @author Alesyahlushakova
 * interface for composite.
 */
public interface Component {
    /**
     * method adds components.
     * @param component
     */
    void add(Component component);

    /**
     * method gets children.
     * @return list of children
     */
    List<Component> getChildren();
}
