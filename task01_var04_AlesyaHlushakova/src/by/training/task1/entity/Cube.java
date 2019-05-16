package by.training.task1.entity;

import by.training.task1.uconst.Age;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.Size;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 * class cube toy.
 */
public class Cube extends Toy {
    /**
     * logger intro.
     */
    public static final Logger LOG =
            LogManager.getLogger(Cube.class.getName());
    /**
     * describes type of cube.
     */
    private CubeType cubeType;

    /**
     * constructor for class.
     * @param name name of toy
     * @param price pricing of usage
     * @param size toy's size
     * @param age age restriction
     * @param type type of toy
     */
    public Cube(final String name, final int price,
                final Size size, final Age age, final CubeType type) {
        super(name, price, size, age);
        this.cubeType = type;
        LOG.info("Cube created: " + this.toString());
    }
    /**
     * @return type of cube toy
     */
    public CubeType getCubeType() {
        return cubeType;
    }

    /**
     * @param type cube type
     */
    public void setCubeType(final CubeType type) {
        this.cubeType = type;
    }

    /**
     * adds cube type to toString() of superclass.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "; Cube type: " + cubeType + "\n";
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
        if (!(o instanceof Cube)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Cube cube = (Cube) o;
        return cubeType == cube.cubeType;
    }

    /**
     * method overrides hash code.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cubeType);
    }
}
