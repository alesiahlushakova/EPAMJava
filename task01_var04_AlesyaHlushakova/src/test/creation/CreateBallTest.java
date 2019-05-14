package by.training.task1.creation;

import by.training.task1.entity.Ball;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.BallType;
import by.training.task1.uconst.Size;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateBallTest {

    @Test
    public void testCreateToy() throws InvalidDataException {
        String ball = "type=BALL name=alenka price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
        ToyParser toyParser = new ToyParser(ball);
        CreateBall creator = new CreateBall(toyParser);
        Ball expected = new Ball("ALENKA",25, Size.SMALL, Age.TEENAGER, BallType.TENNIS);
        assertEquals(creator.createToy(),expected);
    }
    @Test (expectedExceptions = InvalidDataException.class)
    public void testCreateToyException() throws InvalidDataException {
        String ball = "type=BALL name=alenka price=25 size=SMALL age=TEENAGER ";
        ToyParser toyParser = new ToyParser(ball);
        CreateBall creator = new CreateBall(toyParser);
        Ball actual = creator.createToy();
    }
}