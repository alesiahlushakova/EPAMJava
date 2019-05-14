package test.action;

import by.training.task1.action.ToySorter;
import by.training.task1.creation.GameRoomMaker;
import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.entity.*;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class ToySorterTest {
    @BeforeClass
            public void setBefore() throws InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorage toyStorage = (new ToyStorageInitializer()).init(toyReader.read(".\\.\\data\\toys1.txt"));
    }

    @Test
    public void testSortByName() throws InvalidDataException, StorageException {
        ToyStorage toyStorage = ToyStorage.getInstance();
        GameRoom gameRoom = new GameRoomMaker().makeGameRoom(400);
        ToySorter.sortByName(gameRoom);
        LinkedList<Toy> actual = new LinkedList<>();
        for (int i = 0; i < gameRoom.calcSize(); i++) {
            actual.add(gameRoom.getByIndex(i));
        }
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS),
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC),
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE)
        ));
        Assert.assertEquals(actual, expected);


    }

    @Test
    public void testSortByPrice() throws InvalidDataException, StorageException {
        ToyStorage toyStorage = ToyStorage.getInstance();
        GameRoom gameRoom = new GameRoomMaker().makeGameRoom(400);
        ToySorter.sortByPrice(gameRoom);
        LinkedList<Toy> actual = new LinkedList<>();
        for (int i = 0; i < gameRoom.calcSize(); i++) {
            actual.add(gameRoom.getByIndex(i));
        }
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE),
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC),
                new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS)
        ));
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testSortByNameThenPrice() throws InvalidDataException, StorageException {
        ToyStorage toyStorage = ToyStorage.getInstance();
        GameRoom gameRoom = new GameRoomMaker().makeGameRoom(400);
        ToySorter.sortByNameThenPrice(gameRoom);
        LinkedList<Toy> actual = new LinkedList<>();
        for (int i = 0; i < gameRoom.calcSize(); i++) {
            actual.add(gameRoom.getByIndex(i));
        }
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC),
                new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS),
                new Doll("MASHKA", 15, Size.MEDIUM, Age.CHILD, DollType.BARBIE)
        ));
        Assert.assertEquals(actual, expected);

    }
}