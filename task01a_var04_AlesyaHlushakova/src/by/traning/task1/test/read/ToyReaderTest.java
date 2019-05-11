package by.traning.task1.test.read;

import by.traning.task1.entity.Doll;
import by.traning.task1.entity.Toy;
import by.traning.task1.entity.Vehicle;
import by.traning.task1.read.ToyReader;
import by.traning.task1.util.Age;
import by.traning.task1.util.DollType;
import by.traning.task1.util.Size;
import by.traning.task1.util.VehicleType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ToyReaderTest {

    @Test
    public void testRead() {
        String vehicle = "type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK";
        String doll = "type=DOLL name=MND-198 price=200 size=SMALL age=TEENAGER DOLL_TYPE=PORCELIAN";
        ToyReader toyReader = new ToyReader();
        List<String> expected = Arrays.asList(vehicle, doll);
        List<String> actual = toyReader.read("data\\toys1.txt");
        Assert.assertEquals(actual, expected);
    }
}