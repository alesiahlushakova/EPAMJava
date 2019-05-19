package by.training.task02.restorer;

import by.training.task02.composite.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRestorer implements Restorer {
    private Restorer successor;

    protected List<String> restoreEachChild(Component component) {
        List<String> restoredComponents = new ArrayList<>();
        List<Component> children = component.getChildren();
        for (Component child : children) {
            String restoredChild = successor.restore(child);
            restoredComponents.add(restoredChild);
        }
        return restoredComponents;
    }

    public void setSuccessor(Restorer successor) {
        this.successor = successor;
    }
}
