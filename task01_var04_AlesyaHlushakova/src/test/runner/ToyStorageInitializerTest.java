package by.training.task1.test.runner;

import by.training.task1.exception.InvalidDataException;
import by.training.task1.creation.ToyStorageInitializer;
import by.training.task1.storage.ToyStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class ToyStorageInitializerTest {

    @Test
    public void testInit() throws InvalidDataException {

        int expected = 1;
        int actual = toyStorage.countOfToys();
        Assert.assertEquals(expected,actual);
        int expectedPrice = 170;
        int actualPrice = toyStorage.countOfPrices();
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}