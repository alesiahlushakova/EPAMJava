package by.traning.task1.entities;

import by.traning.task1.entities.enums.BallType;
import by.traning.task1.entities.enums.Size;
import  by.traning.task1.entities.enums.Age;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 */
public class Ball extends Toy {
    public static final Logger LOG=
            LogManager.getLogger(Ball.class.getName());
    private BallType ballType;

    public  Ball(String name, int price, Size size, Age age, BallType type) {
        super(name, price, size, age);
        this.ballType = type;
        LOG.info("Ball created"+this.toString());
    }

    /**
     * @return type of ball toy.
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
     * @return balltype
     */
    @Override
    public String toString() {
        return super.toString() + "; Ball type: " + ballType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return ballType == ball.ballType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballType);
    }
}
