package by.training.task1.test.action;

import by.training.task1.creation.GameRoomMaker;
import by.training.task1.action.ToyFinder;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.NonValidValueException;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.storage.ToyStorage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyFinderTest {
    private static final Logger LOGGER = LogManager.getLogger(ToyFinderTest.class);
    @Test
    public void testFindByPrice() throws StorageException, NonValidValueException, InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorage toyStorage=(new ToyStorageInitializer()).init(toyReader.read(".\\.\\data\\toys1.txt"));
        int expected = 170;
        int actual = new ToyFinder().findByPrice(new GameRoomMaker().makeGameRoom(400),
                100,200).getFirst().getPrice();
        Assert.assertEquals(expected, actual);
    }


}