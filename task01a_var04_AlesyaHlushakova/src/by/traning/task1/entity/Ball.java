package by.traning.task1.entity;

import by.traning.task1.util.BallType;
import by.traning.task1.util.Size;
import by.traning.task1.util.Age;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.Objects;

/**
 * @author AlesyaHlushakova
 * @version 1.0
 */
public class Ball extends Toy {

    public static final Logger LOG=
            LogManager.getLogger(Ball.class.getName());
    /**
     * describes type of ball toy.
     */
    private BallType ballType;

    /**
     * constructor for ball toy
     * @param name name of ball
     * @param price price of ball
     * @param size ball size
     * @param age age restriction
     * @param type type of ball
     */
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
     * @param type ball type
     */
    public void setBallType(BallType type) {
        this.ballType = type;
    }

    /**
     * adds ball type to toString() of superclass.
     * @return ball type
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
