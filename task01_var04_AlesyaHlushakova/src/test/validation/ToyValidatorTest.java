package test.validation;

import by.training.task1.validation.ToyValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author AlesyaHlushakova
 * test class.
 */
public class ToyValidatorTest {
    /**
     * test string.
     */
    private String testStr = "type=BALL name=alena"
            + " price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";

    /**
     * tests if toy is valid.
     */
    @Test
    public void testIsValidToy() {
        Assert.assertTrue(ToyValidator.isValidToy(testStr));
    }
    /**
     * tests if doll is valid.
     */
    @Test
    public void testIsValidDoll() {
        Assert.assertFalse(ToyValidator.isValidDoll(testStr));
    }
    /**
     * tests if ball is valid.
     */
    @Test
    public void testIsValidBall() {
        Assert.assertTrue(ToyValidator.isValidBall(testStr));
    }

    /**
     * tests if cube is valid.
     */
    @Test
    public void testIsValidCube() {
        Assert.assertFalse(ToyValidator.isValidCube(testStr));
    }
    /**
     * tests if vehicle is valid.
     */
    @Test
    public void testIsValidVehicle() {
        Assert.assertFalse(ToyValidator.isValidVehicle(testStr));
    }
    /**
     * tests if age is valid.
     */
    @Test
    public void testIsValidAge() {
        Assert.assertTrue(ToyValidator.isValidAge("teenager"));
    }
    /**
     * tests if toy type is valid.
     */
    @Test
    public void testIsValidToyType() {
        Assert.assertTrue(ToyValidator.isValidToyType("ball"));
    }
    /**
     * tests if doll type is valid.
     */
    @Test
    public void testIsValidDollType() {
        Assert.assertTrue(ToyValidator.isValidDollType("barbie"));
    }
    /**
     * tests if ball type is valid.
     */
    @Test
    public void testIsValidBallType() {
        Assert.assertTrue(ToyValidator.isValidBallType("tennis"));
    }
    /**
     * tests if cube type is valid.
     */
    @Test
    public void testIsValidCubeType() {
        Assert.assertTrue(ToyValidator.isValidCubeType("mirror"));
    }
    /**
     * tests if vehicle type is valid.
     */
    @Test
    public void testIsValidVehicleType() {
        Assert.assertTrue(ToyValidator.isValidVehicleType("truck"));
    }


}
