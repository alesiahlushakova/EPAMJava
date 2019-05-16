package test.reader;

import by.training.task1.reader.ToyReader;
import test.parser.ToyParserTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * @author AlesyaHlushakova
 */
public class ToyReaderTest {
    /**
     * logger intro.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ToyParserTest.class);
    /**
     * toys.
     */
  private   String toy1, toy2, toy3, toy4, toy5,
            toy6, toy7, source, source1, source2;
    /**
     * toy reader.
     */
   private ToyReader toyReader = new ToyReader();
    /**
     * toy list.
     */
   private LinkedList<String> toys, toys1, toys2;

    /**
     * sets data.
     */
    @BeforeClass
    public void setBefore() {
        toy1 = "type=BALL name=Borya price=230 "
                + "size=SMALL age=BABY BALL_TYPE=TENNIS";
        toy2 = "type=CUBE name=Borya price=30"
                + " size=LARGE age=TEENAGER CUBE_TYPE=CLASSIC";
        toy3 = "type=VEHICLE name=Winston3000 price=299"
                + " size=SMALL age=TEENAGER VEHICLE_TYPE=TRUCK";
        toy4 = "type=VEHICLE name=Monster price=170"
                + " size=LARGE age=CHILD VEHICLE_TYPE=TRUCK";
        toy5 = "type=DOLL name=MND-198 price=210"
                + " size=SMALL age=TEENAGER DOLL_TYPE=PORCELIAN";
        toy6 = "type=DOLL name=Mashka price=15"
                + " size=MEDIUM age=CHILD DOLL_TYPE=BARBIE";
        toy7 = "type=BALL name=alenka price=25"
                + " size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
        source = "data\\toys1.txt";
        source1 = "data\\toys.txt";
        source2 = "data\\empty.txt";
        toys = new LinkedList<>(Arrays.asList(toy1, toy2,
                toy3, toy4, toy5, toy6));
        toys1 = new LinkedList<>(Arrays.asList(toy7));
        toys2 = new LinkedList<>();
    }

    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "provider")
    public Object[][] dataProviderTestReader() {
        return new Object[][]{{toyReader, toys, source},
                {toyReader, toys1, source1}, {toyReader, toys2, source2}};
    }

    /**
     * test method.
     * @param toyReader reader
     * @param expected result
     * @param source .txt
     */
    @Test(dataProvider = "provider")
    public void testRead(final ToyReader toyReader,
                         final LinkedList<String> expected,
                         final String source) {

        LinkedList<String> actual = toyReader.read(source);
        Assert.assertEquals(actual, expected);
    }
}
