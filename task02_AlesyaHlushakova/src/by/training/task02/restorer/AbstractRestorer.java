package by.training.task02.restorer;

import by.training.task02.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alesyahlushakova
 * abstract text restorer.
 */
public abstract class AbstractRestorer implements Restorer {
    /**
     * successor.
     */
    private Restorer successor;

    /**
     * method restores each child.
     * @param component component
     * @return text
     */
    protected List<String> restoreEachChild(final Component component) {
        List<String> restoredComponents = new ArrayList<>();
        List<Component> children = component.getChildren();
        for (Component child : children) {
            String restoredChild = successor.restore(child);
            restoredComponents.add(restoredChild);
        }
        return restoredComponents;
    }

    /**
     * method sets successor.
     * @param successor successor
     */
    public void setSuccessor(final Restorer successor) {
        this.successor = successor;
    }
}
