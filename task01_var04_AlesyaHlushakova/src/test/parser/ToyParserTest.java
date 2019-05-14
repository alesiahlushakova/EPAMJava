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


public class ToyParserTest {
    private static final Logger LOGGER = LogManager.getLogger(ToyParserTest.class);
    String toy1, toy2, toy3, toy4;
    ToyParser toyParserToy1, toyParserToy2, toyParserToy3, ToyParserToy4;
    @BeforeClass
    public void setBefore() {
        String toy1 = "type=BALL name=Bolick price=20 size=SMALL age=BABY BALL_TYPE=TENNIS";
        String toy2 = "type=DOLL name=Mashka price=15 size=MEDIUM age=CHILD DOLL_TYPE=BARBIE";
        String toy3 = "type=CUBE name=Borya price=230 size=LARGE age=TEENAGER CUBE_TYPE=CLASSIC";
        String toy4 = "type=VEHICLE name=Winston3000 price=299 size=SMALL age=TEENAGER VEHICLE_TYPE=TRUCK";
        toyParserToy1 = new ToyParser(toy1);
        toyParserToy2 = new ToyParser(toy2);
        toyParserToy3 = new ToyParser(toy3);
        ToyParserToy4 = new ToyParser(toy4);
    }

    @DataProvider(name = "provider")
            public Object[][] dataProvider() {
        return new Object[][] {{toyParserToy1, TypeToy.BALL},{toyParserToy2,
                TypeToy.DOLL}, {toyParserToy3, TypeToy.CUBE},
                {ToyParserToy4, TypeToy.VEHICLE} };
    }
    @DataProvider(name = "providerToyName")
            public Object[][] dataProviderToyName() {
        return  new Object[][] {{toyParserToy1, "Bolick"}, {toyParserToy2, "Mashka"}, {toyParserToy3, "Borya"}, {ToyParserToy4, "Winston3000"}};
    }
    @DataProvider(name = "providerToyPrice")
    public Object[][] dataProviderToyPrice() {
        return  new Object[][] {{toyParserToy1, 20}, {toyParserToy2, 15}, {toyParserToy3, 230}, {ToyParserToy4, 299}};
    }
    @DataProvider(name = "providerToyAge")
    public Object[][] dataProviderToyAge() {
        return  new Object[][] {{toyParserToy1, Age.BABY}, {toyParserToy2, Age.CHILD}, {toyParserToy3, Age.TEENAGER}, {ToyParserToy4, Age.TEENAGER}};
    }
    @DataProvider(name = "providerToySize")
    public Object[][] dataProviderToySize() {
        return  new Object[][] {{toyParserToy1, Size.SMALL}, {toyParserToy2, Size.MEDIUM}, {toyParserToy3, Size.LARGE}, {ToyParserToy4, Size.SMALL}};
    }
    ToyParser toyParser = new ToyParser("type=VEHICLE name=Monster price=170 size=LARGE age=CHILD VEHICLE_TYPE=TRUCK");

    @Test(dataProvider = "provider")
    public void testTakeToyType(ToyParser toyParser1, TypeToy toy) {
        try {
            Assert.assertTrue(toyParser.takeToyType().toString().equals("VEHICLE"));
        }
        catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Test(dataProvider = "providerToyName")
    public void testTakeToyName(ToyParser toyParser, String a) {
        try {
            Assert.assertEquals(a.toUpperCase(), toyParser.takeToyName());
        }
        catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }


    @Test(dataProvider = "providerToyPrice")
    public void testTakeToyPrice(ToyParser toyParser, int price) {
        try {
            Assert.assertEquals(toyParser.takeToyPrice(), price);
        }
        catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Test(dataProvider = "providerToyAge")
    public void testTakeToyAge(ToyParser toyParser, Age age) {
        try {
            Assert.assertEquals(age,toyParser.takeToyAge());
        }
        catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Test(dataProvider = "providerToySize")
    public void testTakeToySize(ToyParser toyParser, Size size) {
        try {
            Assert.assertEquals(size,toyParser.takeToySize());
        }
        catch (InvalidDataException e) {
            LOGGER.error(e.getMessage());
        }
    }


    @Test
    public void testTakeVehicleType() throws InvalidDataException{
        Assert.assertTrue(toyParser.takeVehicleType().toString().equals("TRUCK"));
    }
}