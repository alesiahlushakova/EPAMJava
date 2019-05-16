package test.action;

import by.training.task1.action.ToyFinder;
import by.training.task1.creation.GameRoomCreator;
import by.training.task1.entity.Doll;
import by.training.task1.entity.Toy;
import by.training.task1.entity.Ball;
import by.training.task1.entity.Cube;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.NonValidValueException;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.storage.GameRoom;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author AlesyaHlushakova
 * class test.
 */
public class ToyFinderTest {
    /**
     * logger intro.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ToyFinderTest.class);
    /**
     * game room.
     */
   private GameRoom gameRoom;

    /**
     * data for test.
     * @throws StorageException exception
     */
    @BeforeClass
    void setBefore() throws StorageException {
            ToyReader toyReader = new ToyReader();
            ToyStorage toyStorage = (new ToyStorageInitializer()).
                    init(toyReader.read(".\\.\\data\\toys1.txt"));
            gameRoom = new GameRoomCreator().makeGameRoom(400);

    }

    /**
     * finds toy in certain interval.
     * @throws NonValidValueException exception
     * @throws InvalidDataException
     */
    @Test
    public void testFindByPrice()
            throws NonValidValueException {
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE)
        ));
        LinkedList<Toy> actual = new ToyFinder().findByPrice(gameRoom, 10, 20);
        Assert.assertEquals(actual, expected);
    }

    /**
     * method tests search.
     * @throws StorageException exceptions
     * @throws NonValidValueException exception
     * @throws InvalidDataException exception
     */
    @Test
    public void testFindByPrice1() throws StorageException,
            NonValidValueException, InvalidDataException {
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Cube("BORYA", 30,
                        Size.LARGE, Age.TEENAGER, CubeType.CLASSIC),
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE)
        ));
        LinkedList<Toy> actual = new ToyFinder().findByPrice(gameRoom, 10, 100);
        Assert.assertEquals(actual, expected);
    }

    /**
     * method tests search by od.
     * @throws InvalidDataException exception
     */
    @Test
    public void testFindById() throws InvalidDataException {
        int expected = 2;
        int actual = new ToyFinder().findById(gameRoom, 2).getId();
        Assert.assertEquals(expected, actual);
    }

    /**
     * method tests search.
     * @throws NonValidValueException exception
     */
    @Test
    public void testFindByName() throws
            NonValidValueException {
        String  expected = "BORYA";
        Ball borya = new Ball("BORYA", 230,
                Size.SMALL, Age.BABY, BallType.TENNIS);
        Toy actual = new ToyFinder().findByName(gameRoom,
                expected).getFirst();
        Ball actualBall = (Ball) actual;
        Assert.assertEquals(borya, actualBall);
    }

}
