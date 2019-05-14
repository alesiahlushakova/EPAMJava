package test.creation;

import by.training.task1.creation.CreateBall;
import by.training.task1.creation.CreateCube;
import by.training.task1.entity.Ball;
import by.training.task1.entity.Cube;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.BallType;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.Size;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateCubeTest {

    @Test
    public void testCreateToy() throws InvalidDataException {
        String cube = "type=CUBE name=ruby price=250 size=SMALL age=TEENAGER CUBE_TYPE=CLASSIC";
        ToyParser toyParser = new ToyParser(cube);
        CreateCube creator = new CreateCube(toyParser);
        Cube expected = new Cube("RUBY",250, Size.SMALL, Age.TEENAGER, CubeType.CLASSIC);
        assertEquals(creator.createToy(),expected);
    }
    @Test (expectedExceptions = InvalidDataException.class)
    public void testCreateToyException() throws InvalidDataException {
        String cube = "type=CUBE name=ruby price=250 size=SMALL  CUBE_TYPE=CLASSIC";
        ToyParser toyParser = new ToyParser(cube);
        CreateCube creator = new CreateCube(toyParser);
        Cube actual = creator.createToy();
    }
}