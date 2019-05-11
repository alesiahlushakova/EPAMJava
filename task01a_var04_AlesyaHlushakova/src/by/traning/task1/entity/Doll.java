package by.traning.task1.entity;

import by.traning.task1.util.Age;
import by.traning.task1.util.DollType;
import by.traning.task1.util.Size;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * class for doll toy types.
 * @author AlesyaHlushakova
 */
public class Doll extends Toy {
    public static final Logger LOG=
            LogManager.getLogger(Doll.class.getName());
    /**
     * defines type of a doll.
     */
    private DollType dollType;

    /**
     *constructor for doll class
     * @param name name of doll
     * @param price price of doll usage
     * @param size doll size
     * @param age age restriction
     * @param type dool type
     */
    public Doll(String name, int price, Size size, Age age, DollType type){
        super(name, price, size, age);
        this.dollType = type;
        LOG.info("Doll created: "+this.toString());
    }

    /**
     * method to get type.
     * @return doll type
     */
    public DollType getDollType() {
        return dollType;
    }

    /**
     * setter to set doll
     * @param type type of doll
     */
    public void setDollType(DollType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doll doll = (Doll) o;
        return dollType == doll.dollType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollType);
    }
}
