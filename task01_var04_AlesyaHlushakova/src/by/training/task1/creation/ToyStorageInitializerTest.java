package by.training.task1.creation;

import by.training.task1.entity.Ball;
import by.training.task1.entity.Cube;
import by.training.task1.entity.Doll;
import by.training.task1.entity.Toy;
import by.training.task1.exception.InvalidDataException;
import by.training.task1.exception.StorageException;
import by.training.task1.reader.ToyReader;
import by.training.task1.storage.ToyStorage;
import by.training.task1.uconst.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class ToyStorageInitializerTest {

    @Test
    public void testInit() throws StorageException {
        ToyReader reader = new ToyReader();
        ToyStorageInitializer initializer = new ToyStorageInitializer();
        ToyStorage storage = initializer.init(reader.read(".\\.\\data\\toysInit.txt"));
        LinkedList<Toy> actual = new LinkedList<>();
        for (int i = 0; i < storage.countOfToys(); i++) {
            actual.add(storage.getToy(i));
        }
        LinkedList<Toy> expected = new LinkedList<>(Arrays.asList(
                new Ball("BORYA", 230, Size.SMALL, Age.BABY, BallType.TENNIS),
                new Cube("BORYA", 30, Size.LARGE, Age.TEENAGER, CubeType.CLASSIC)
        ));
        Assert.assertEquals(actual,expected);

    }
}