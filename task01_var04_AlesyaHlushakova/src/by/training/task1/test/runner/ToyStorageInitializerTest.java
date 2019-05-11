package by.training.task1.test.runner;

import by.training.task1.exception.InvalidDataException;
import by.training.task1.runner.ToyStorageInitializer;
import by.training.task1.store.ToyStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class ToyStorageInitializerTest {

    @Test
    public void testInit() throws InvalidDataException {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK");
        ToyStorageInitializer tsi = new ToyStorageInitializer();
        ToyStorage toyStorage = tsi.init(strings);
        int expected = 1;
        int actual = toyStorage.countOfToys();
        Assert.assertEquals(expected,actual);
        int expectedPrice = 170;
        int actualPrice = toyStorage.countOfPrices();
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}