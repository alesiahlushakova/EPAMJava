package entities;

import entities.enums.Age;
import entities.enums.Size;
import entities.enums.CubeType;

public class Cube extends Toy {
    private CubeType cubeType;

    /**
     *
     * @param name
     * @param price
     * @param size
     * @param age
     * @param type
     */
    public Cube(String name, int price, Size size, Age age, CubeType type) {
        super(name, price, size, age);
        this.cubeType=type;
    }
    /**
     *
     * @return
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
        return super.toString() + "; Cube type: " + cubeType;
    }
}
