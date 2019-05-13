package by.training.task1.entity;

import by.training.task1.util.Age;
import by.training.task1.util.CubeType;
import by.training.task1.util.Size;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 * class cube toy.
 */
public class Cube extends Toy {
    public static final Logger LOG=
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
    public Cube(String name, int price, Size size, Age age, CubeType type) {
        super(name, price, size, age);
        this.cubeType = type;
        LOG.info("Cube created: "+this.toString());
    }
    /**
     * @return type of cube toy
     */
    public CubeType getCubeType() {
        return cubeType;
    }

    /**
     * @param type
     */
    public void setCubeType(CubeType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return cubeType == cube.cubeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubeType);
    }
}