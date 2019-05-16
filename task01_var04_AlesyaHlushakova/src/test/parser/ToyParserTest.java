package test.parser;

import by.training.task1.exception.InvalidDataException;
import by.training.task1.parser.ToyParser;
import by.training.task1.uconst.Age;
import by.training.task1.uconst.Size;
import by.training.task1.uconst.TypeToy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author AlesyaHlushakova
 */
public class ToyParserTest {
    /**
     * logger intro.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ToyParserTest.class);
    /**
     * toys.
     */
    private String toy1, toy2, toy3, toy4;
    /**
     * parsers.
     */
    private ToyParser toyParserToy1, toyParserToy2,
            toyParserToy3, ToyParserToy4;

    /**
     * method sets data.
     */
    @BeforeClass
    public void setBefore() {
        String toy1 = "type=BALL name=Bolick price=20"
                + " size=SMALL age=BABY BALL_TYPE=TENNIS";
        String toy2 = "type=DOLL name=Mashka price=15"
                + " size=MEDIUM age=CHILD DOLL_TYPE=BARBIE";
        String toy3 = "type=CUBE name=Borya price=230"
                + " size=LARGE age=TEENAGER CUBE_TYPE=CLASSIC";
        String toy4 = "type=VEHICLE name=Winston3000 price=299"
                + " size=SMALL age=TEENAGER VEHICLE_TYPE=TRUCK";
        toyParserToy1 = new ToyParser(toy1);
        toyParserToy2 = new ToyParser(toy2);
        toyParserToy3 = new ToyParser(toy3);
        ToyParserToy4 = new ToyParser(toy4);
    }

    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "provider")
            public Object[][] dataProvider() {
        return new Object[][] {{toyParserToy1, TypeToy.BALL}, {toyParserToy2,
                TypeToy.DOLL}, {toyParserToy3, TypeToy.CUBE},
                {ToyParserToy4, TypeToy.VEHICLE} };
    }
    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "providerToyName")
            public Object[][] dataProviderToyName() {
        return  new Object[][] {{toyParserToy1, "Bolick"},
                {toyParserToy2, "Mashka"},
                {toyParserToy3, "Borya"}, {ToyParserToy4, "Winston3000"}};
    }
    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "providerToyPrice")
    public Object[][] dataProviderToyPrice() {
        return  new Object[][] {{toyParserToy1, 20}, {toyParserToy2, 15},
                {toyParserToy3, 230}, {ToyParserToy4, 299}};
    }
    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "providerToyAge")
    public Object[][] dataProviderToyAge() {
        return  new Object[][] {{toyParserToy1, Age.BABY},
                {toyParserToy2, Age.CHILD}, {toyParserToy3, Age.TEENAGER},
                {ToyParserToy4, Age.TEENAGER}};
    }
    /**
     * data provider.
     * @return object
     */
    @DataProvider(name = "providerToySize")
    public Object[][] dataProviderToySize() {
        return  new Object[][] {{toyParserToy1, Size.SMALL},
                {toyParserToy2, Size.MEDIUM}, {toyParserToy3, Size.LARGE},
                {ToyParserToy4, Size.SMALL}};
    }

    /**
     * toy parser.
     */
   private ToyParser toyParser = new ToyParser("type=VEHICLE name=Monster"
            + " price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK");

    /**
     * test method.
     * @param toyParser1 parser
     * @param toy toy
     */
    @Test(dataProvider = "provider")
    public void testTakeToyType(final ToyParser toyParser1, final TypeToy toy) {
        try {
            Assert.assertTrue(toyParser.takeToyType().
                    toString().equals("VEHICLE"));
        } catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * test method.
     * @param toyParser parser
     * @param a toy
     */
    @Test(dataProvider = "providerToyName")
    public void testTakeToyName(final ToyParser toyParser, final String a) {
        try {
            Assert.assertEquals(a.toUpperCase(), toyParser.takeToyName());
        } catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * test method.
     * @param toyParser parser
     * @param price toy
     */
    @Test(dataProvider = "providerToyPrice")
    public void testTakeToyPrice(final ToyParser toyParser, final int price) {
        try {
            Assert.assertEquals(toyParser.takeToyPrice(), price);
        } catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * test method.
     * @param toyParser parser
     * @param age toy
     */
    @Test(dataProvider = "providerToyAge")
    public void testTakeToyAge(final ToyParser toyParser, final Age age) {
        try {
            Assert.assertEquals(age, toyParser.takeToyAge());
        }  catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }
    /**
     * test method.
     * @param toyParser parser
     * @param size toy
     */
    @Test(dataProvider = "providerToySize")
    public void testTakeToySize(final ToyParser toyParser, final Size size) {
        try {
            Assert.assertEquals(size, toyParser.takeToySize());
        } catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * test method.
     * @throws InvalidDataException exception
     */
    @Test
    public void testTakeVehicleType() throws InvalidDataException {
        Assert.assertTrue(toyParser.takeVehicleType().
                toString().equals("TRUCK"));
    }
}
