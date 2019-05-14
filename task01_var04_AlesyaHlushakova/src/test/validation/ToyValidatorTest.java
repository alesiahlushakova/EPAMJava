package test.validation;

import by.training.task1.validation.ToyValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToyValidatorTest {
    String testStr = "type=BALL name=alena price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
    @Test
    public void testIsValidToy() {
        Assert.assertTrue(ToyValidator.isValidToy(testStr));
    }
    @Test
    public void testIsValidDoll() {
        Assert.assertFalse(ToyValidator.isValidDoll(testStr));
    }
    @Test
    public void testIsValidBall() {
        Assert.assertTrue(ToyValidator.isValidBall(testStr));
    }
    @Test
    public void testIsValidCube() {
        Assert.assertFalse(ToyValidator.isValidCube(testStr));
    }
    @Test
    public void testIsValidVehicle() {
        Assert.assertFalse(ToyValidator.isValidVehicle(testStr));
    }
    @Test
    public void testIsValidAge() {
        Assert.assertTrue(ToyValidator.isValidAge("teenager"));
    }
    @Test
    public void testIsValidToyType() {
        Assert.assertTrue(ToyValidator.isValidToyType("ball"));
    }
    @Test
    public void testIsValidDollType() {
        Assert.assertTrue(ToyValidator.isValidDollType("barbie"));
    }
    @Test
    public void testIsValidBallType() {
        Assert.assertTrue(ToyValidator.isValidBallType("tennis"));
    }
    @Test
    public void testIsValidCubeType() {
        Assert.assertTrue(ToyValidator.isValidCubeType("mirror"));
    }
    @Test
    public void testIsValidVehicleType() {
        Assert.assertTrue(ToyValidator.isValidVehicleType("truck"));
    }


}