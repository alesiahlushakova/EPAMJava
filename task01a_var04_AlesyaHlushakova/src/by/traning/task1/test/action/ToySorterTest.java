package by.traning.task1.test.action;

import by.traning.task1.entity.Toy;
import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.read.ToyReader;
import by.traning.task1.runner.ToyStorageInitializer;
import by.traning.task1.store.ToyStorage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class ToySorterTest {
    @BeforeClass
    static void initTest() throws InvalidDataException {
        ToyReader toyReader = new ToyReader();
        ToyStorageInitializer toyStorageInitializer = new ToyStorageInitializer();
        toyStorageInitializer.init(toyReader.read("data\\toys1.txt"));
    }
    @Test
    public void testSortByName() {
        ToyStorage toyStorage = ToyStorage.getInstance();
        LinkedList<Toy> expected = new LinkedList<>();
    }

    @Test
    public void testSortByPrice() {
    }

    @Test
    public void testSortByNameThenPrice() {
    }
}