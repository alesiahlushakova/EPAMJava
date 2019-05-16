package by.training.task1.entity;

import by.training.task1.uconst.Age;
import by.training.task1.uconst.DollType;
import by.training.task1.uconst.Size;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * class for doll toy types.
 * @author AlesyaHlushakova
 */
public class Doll extends Toy {
    /**
     * logger intro.
     */
    public static final Logger LOG =
            LogManager.getLogger(Doll.class.getName());
    /**
     * defines type of a doll.
     */
    private DollType dollType;

    /**
     *constructor for doll class.
     * @param name name of doll
     * @param price price of doll usage
     * @param size doll size
     * @param age age restriction
     * @param type dool type
     */
    public Doll(final String name, final int price,
                final Size size, final Age age, final DollType type) {
        super(name, price, size, age);
        this.dollType = type;
        LOG.info("Doll created: " + this.toString());
    }

    /**
     * method to get type.
     * @return doll type
     */
    public DollType getDollType() {
        return dollType;
    }

    /**
     * setter to set doll.
     * @param type type of doll
     */
    public void setDollType(final DollType type) {
        this.dollType = type;
    }

    /**
     * adds doll type to toString() of superclass.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "; Doll type: " + dollType + "\n";
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
        if (!(o instanceof Doll)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Doll doll = (Doll) o;
        return dollType == doll.dollType;
    }

    /**
     * method overrides hashcode.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dollType);
    }
}
