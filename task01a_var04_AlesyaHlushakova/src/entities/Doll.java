package entities;

import entities.enums.Age;
import entities.enums.DollType;
import entities.enums.Size;

/**
 * @author AlesyaHlushakova
 */
public class Doll extends Toy {
    private DollType dollType;

    /**
     *
     * @param name
     * @param price
     * @param size
     * @param age
     * @param type
     */
    public Doll(String name, int price, Size size, Age age, DollType type){
        super(name, price, size, age);
        this.dollType = type;
    }

    /**
     *
     * @return
     */
    public DollType getDollType() {
        return dollType;
    }

    /**
     * @param type
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
        return super.toString() + "; Doll type: " + dollType;
    }
}
