package by.training.task02.parser;

import by.training.task02.composite.Component;
import by.training.task02.composite.Composite;

/**
 * @author AlesyaHlushakova
 * abstract parser class.
 */
public abstract class AbstractParser implements  Parser{
    /**
     * successor.
     */
    private Parser successor;

    /**
     * parses each.
     * @param parts components.
     * @return component
     */
    protected Component parseEach(String[] parts) {
        Component composite = new Composite();
        for (String part : parts) {
            Component component = successor.parse(part);
            composite.add(component);
        }
        return composite;
    }

    /**
     * sets successor.
     * @param successor successor
     */
    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }
}
