package test.creation;

import by.training.task1.creation.CreateDoll;
import by.training.task1.entity.Doll;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.DollType;
import by.training.task1.uconst.Size;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author AlesyaHlushakova
 * class tester.
 */
public class CreateDollTest {
    /**
     * method tests doll toy creation.
      * @throws InvalidDataException exception
     */
    @Test
    public void testCreateToy() throws InvalidDataException {
        String doll = "type=DOLL name=alex price=250 "
                + "size=SMALL age=TEENAGER DOLL_TYPE=BRATZ";
        ToyParser toyParser = new ToyParser(doll);
        CreateDoll creator = new CreateDoll(toyParser);
        Doll expected = new Doll("ALEX", 250,
                Size.SMALL, Age.TEENAGER, DollType.BRATZ);
        assertEquals(creator.createToy(), expected);
    }

    /**
     * method tests doll toy creation.
     * @throws InvalidDataException exception
     */
    @Test (expectedExceptions = InvalidDataException.class)
    public void testCreateToyException() throws InvalidDataException {
        String doll = "type=DOLL name=alex "
                + "price=250 age=TEENAGER DOLL_TYPE=BRATZ";
        ToyParser toyParser = new ToyParser(doll);
        CreateDoll creator = new CreateDoll(toyParser);
        Doll actual = creator.createToy();
    }
}
