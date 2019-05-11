package by.training.task1.test.parse;

import by.training.task1.exception.InvalidDataException;
import by.training.task1.parse.ToyParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class ToyParserTest {

    ToyParser toyParser = new ToyParser("type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK");
    @Test
    public void testTakeToyType() throws InvalidDataException {
        Assert.assertTrue(toyParser.takeToyType().toString().equals("VEHICLE"));
    }

    @Test
    public void testTakeToyName() throws InvalidDataException {
        Assert.assertTrue(toyParser.takeToyName().equals("MONSTER"));
        Assert.assertFalse(toyParser.takeToyName().equals("MONSTE"));
    }

    @Test
    public void testTakeToyPrice() throws InvalidDataException {
        Assert.assertEquals(toyParser.takeToyPrice(),170);
    }

    @Test
    public void testTakeToyAge() throws InvalidDataException {
        Assert.assertTrue(toyParser.takeToyAge().toString().equals("CHILD"));
        Assert.assertFalse(toyParser.takeToyAge().toString().equals("TEENAGER"));
    }

    @Test
    public void testTakeToySize() throws InvalidDataException {
        Assert.assertTrue(toyParser.takeToySize().toString().equals("LARGE"));
        Assert.assertFalse(toyParser.takeToySize().toString().equals("SMALL"));
    }


    @Test
    public void testTakeVehicleType() throws InvalidDataException{
        Assert.assertTrue(toyParser.takeVehicleType().toString().equals("TRUCK"));
    }
}