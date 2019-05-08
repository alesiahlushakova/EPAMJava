package by.traning.task1.test.parse;

import by.traning.task1.exception.InvalidDataException;
import by.traning.task1.parse.ToyParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class ToyParserTest {
    @Test
    public void parseTest() throws InvalidDataException {
        ToyParser toyParser = new ToyParser("type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK");
        Assert.assertTrue(toyParser.takeToyType().toString().equals("VEHICLE"));

        Assert.assertEquals(toyParser.takeToyPrice(),170);

        Assert.assertTrue(toyParser.takeToyName().equals("MONSTER"));
        Assert.assertFalse(toyParser.takeToyName().equals("MONSTE"));
        Assert.assertTrue(toyParser.takeToyAge().toString().equals("CHILD"));
        Assert.assertFalse(toyParser.takeToyAge().toString().equals("TEENAGER"));
        Assert.assertTrue(toyParser.takeToySize().toString().equals("LARGE"));
        Assert.assertFalse(toyParser.takeToySize().toString().equals("SMALL"));
        Assert.assertTrue(toyParser.takeVehicleType().toString().equals("TRUCK"));
    }

}