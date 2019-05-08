package by.traning.task1.test.action;

import by.traning.task1.action.GameRoomMaker;
import by.traning.task1.action.ToyFinder;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.exception.NonValidValueException;
import by.traning.task1.exception.StorageException;
import by.traning.task1.read.ToyReader;
import by.traning.task1.runner.ToyStorageInitializer;
import by.traning.task1.store.ToyStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ToyFinderTest {
    @BeforeClass
    static void initTest() throws InvalidDataException {

    }
    @Test
    public void testFindByPrice() throws StorageException, NonValidValueException, InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorageInitializer toyStorageInitializer = new ToyStorageInitializer();
        toyStorageInitializer.init(toyReader.read("data\\toys1.txt"));
        ToyStorage toyStorage = ToyStorage.getInstance();
        int expected = 170;
        int actual = new ToyFinder().findByPrice(new GameRoomMaker().makeGameRoom(400),100,200).getFirst().getPrice();
        Assert.assertEquals(expected, actual);
    }
}