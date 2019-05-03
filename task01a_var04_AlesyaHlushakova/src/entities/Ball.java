package entities;

import entities.enums.BallType;
import entities.enums.Size;
import  entities.enums.Age;

/**
 * @author AlesyaHlushakova
 */
public class Ball extends Toy {
    private BallType ballType;

    public  Ball(String name, int price, Size size, Age age, BallType type) {
        super(name, price, size, age);
        this.ballType = type;
    }

    /**
     *
     * @return
     */
    public BallType getBallType() {
        return ballType;
    }

    /**
     * @param type
     */
    public void setBallType(BallType type) {
        this.ballType = type;
    }

    /**
     * adds ball type to toString() of superclass.
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "; Ball type: " + ballType;
    }
}
