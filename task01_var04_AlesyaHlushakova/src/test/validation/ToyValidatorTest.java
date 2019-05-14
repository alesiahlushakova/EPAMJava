package by.training.task1.test.validation;

import by.training.task1.validation.ToyValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToyValidatorTest {
    String testStr = "type=BALL name=alena price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
    @Test
    public void testIsValidToy() {
        Assert.assertTrue(ToyValidator.isValidToy(testStr));

        Assert.assertTrue(ToyValidator.isValidBall(testStr));
        Assert.assertFalse(ToyValidator.isValidCube(testStr));
        Assert.assertFalse(ToyValidator.isValidVehicle(testStr));
    }
    @Test
    public void testIsValidDoll() {
        Assert.assertFalse(ToyValidator.isValidDoll(testStr));
    }
    @Test
    public void isValidToy1() {
        Assert.assertTrue(ToyValidator.isValidAge("teenager"));
        Assert.assertFalse(ToyValidator.isValidAge("infant"));
        Assert.assertTrue(ToyValidator.isValidToyType("ball"));
        Assert.assertFalse(ToyValidator.isValidToyType("cow"));
        Assert.assertTrue(ToyValidator.isValidDollType("barbie"));
        Assert.assertTrue(ToyValidator.isValidBallType("tennis"));
        Assert.assertTrue(ToyValidator.isValidCubeType("mirror"));
        Assert.assertTrue(ToyValidator.isValidVehicleType("truck"));
    }

}