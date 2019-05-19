package by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;

public abstract class AbstractParser {
    private Parser successor;

    protected Component parseEach(String[] parts) {
        Component composite = new Composite();
        for (String part : parts) {
            Component component = successor.parse(part);
            composite.add(component);
        }
        return composite;
    }
public abstract Component parse(String source);
    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
