package by.training.task1.test.reader;

import by.training.task1.reader.ToyReader;
import by.training.task1.test.parser.ToyParserTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ToyReaderTest {
    private static final Logger LOGGER = LogManager.getLogger(ToyParserTest.class);
    String toy1, toy2, toy3, toy4, toy5, toy6, toy7;
    ToyReader toyReader1, toyReader2, toyReader3;
    @BeforeClass
    public void setBefore() {
        String toy1 = "type=BALL name=Bolick price=20 size=SMALL age=BABY BALL_TYPE=TENNIS";
        String toy2 = "type=DOLL name=Mashka price=15 size=MEDIUM age=CHILD DOLL_TYPE=BARBIE";
        String toy3 = "type=CUBE name=Borya price=230 size=LARGE age=TEENAGER CUBE_TYPE=CLASSIC";
        String toy4 = "type=VEHICLE name=Winston3000 price=299 size=SMALL age=TEENAGER VEHICLE_TYPE=TRUCK";
        String toy5 = "type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK";
        String toy6 = "type=DOLL name=MND-198 price=200 size=SMALL age=TEENAGER DOLL_TYPE=PORCELIAN";
        String toy7 ="type=BALL name=alenka price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
        toyReader1 = new ToyReader();
        toyReader2 = new ToyReader();
    }
    @DataProvider(name = "provider")
    public Object[][] dataProviderTestReader() {
        return new Object[][]{{toyReader1, Arrays.asList(toy1, toy2,toy3,toy4, toy5, toy6)}, {toyReader2, Arrays.asList(toy7)}};
    }
    @Test(dataProvider = "provider")
    public void testRead(ToyReader toyReader, LinkedList<String> expected) {

        List<String> actual = toyReader.read("data\\toys1.txt");
        Assert.assertEquals(actual, expected);
    }
}
