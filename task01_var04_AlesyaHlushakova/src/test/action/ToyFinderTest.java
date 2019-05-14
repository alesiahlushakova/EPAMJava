package test.action;

import by.training.task1.creation.GameRoomMaker;
import by.training.task1.action.ToyFinder;
import by.training.task1.entity.*;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.NonValidValueException;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;

public class ToyFinderTest {
    private static final Logger LOGGER = LogManager.getLogger(ToyFinderTest.class);

    GameRoom gameRoom;
    @BeforeClass
    void setBefore() throws InvalidDataException, StorageException {
        //try {
            ToyReader toyReader = new ToyReader();
            ToyStorage toyStorage=(new ToyStorageInitializer()).init(toyReader.read(".\\.\\data\\toys1.txt"));
            gameRoom = new GameRoom();
            gameRoom = new GameRoomMaker().makeGameRoom(400);
      //  }
      //catch (InvalidDataException e) {
     //       LOGGER.error("Error while parsing");
     // }
    }
    @Test
    public void testFindByPrice() throws StorageException, NonValidValueException, InvalidDataException {
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC),
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE)
        ));
        LinkedList<Toy> actual = new ToyFinder().findByPrice(gameRoom,10,100);
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testFindById() throws StorageException, NonValidValueException, InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorage toyStorage=(new ToyStorageInitializer()).init(toyReader.read(".\\.\\data\\toys1.txt"));
        int expected = 2;
        GameRoom gameRoom = new GameRoom();
        gameRoom = new GameRoomMaker().makeGameRoom(400);
        int actual = new ToyFinder().findById(gameRoom, 2).getId();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testFindByName() throws StorageException, NonValidValueException, InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorage toyStorage=(new ToyStorageInitializer()).init(toyReader.read(".\\.\\data\\toys1.txt"));
        String  expected = "BORYA";
        Ball borya =new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS);
        GameRoom gameRoom = new GameRoom();
        gameRoom = new GameRoomMaker().makeGameRoom(400);
        Toy actual =  new ToyFinder().findByName(gameRoom, expected).getFirst();
        Ball actualBall = (Ball) actual;
        Assert.assertEquals(borya,actualBall);
    }

}