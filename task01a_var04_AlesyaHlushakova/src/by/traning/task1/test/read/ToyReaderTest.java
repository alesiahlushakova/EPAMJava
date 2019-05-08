package by.traning.task1.test.read;

import by.traning.task1.entity.Doll;
import by.traning.task1.entity.Toy;
import by.traning.task1.entity.Vehicle;
import by.traning.task1.read.ToyReader;
import by.traning.task1.util.Age;
import by.traning.task1.util.DollType;
import by.traning.task1.util.Size;
import by.traning.task1.util.VehicleType;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ToyReaderTest {

    @Test
    public void testRead() {
        Toy vehicle = new Vehicle("Monster", 170, Size.LARGE, Age.CHILD, VehicleType.TRUCK);
        Toy doll = new Doll("MND-198", 200, Size.SMALL, Age.TEENAGER, DollType.PORCELIAN);
        ToyReader toyReader = new ToyReader();
        List<Toy> expected = Arrays.asList(vehicle, doll);
        List<String> actual = toyReader.read("data\\toys1.txt");
    }
}