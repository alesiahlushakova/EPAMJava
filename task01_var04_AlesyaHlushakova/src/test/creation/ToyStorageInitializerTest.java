package test.creation;

import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.entity.Ball;
import by.training.task1.entity.Cube;
import by.training.task1.entity.Toy;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.BallType;
import by.training.task1.uconst.CubeType;
import by.training.task1.uconst.Size;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class ToyStorageInitializerTest {

    @Test
    public void testInit() throws StorageException {
        ToyReader reader = new ToyReader();
        ToyStorageInitializer initializer = new ToyStorageInitializer();
        ToyStorage storage = initializer.init(reader.read(".\\.\\data\\toysInit.txt"));
        LinkedList<Toy> actual = new LinkedList<>();
        for (int i = 0; i < storage.countOfToys(); i++) {
            actual.add(storage.takeToy(i));
        }
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS),
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC)
        ));
        Assert.assertEquals(actual,expected);

    }
}