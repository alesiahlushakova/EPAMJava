package by.traning.task1.test.valid;

import by.traning.task1.valid.ToyValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ToyValidatorTest {

    @Test
    public void testIsValidToy() {
        String testStr = "type=BALL name=alena price=25 size=SMALL age=TEENAGER BALL_TYPE=TENNIS";
        Assert.assertTrue(ToyValidator.isValidToy(testStr));
        Assert.assertFalse(ToyValidator.isValidDoll(testStr));
        Assert.assertTrue(ToyValidator.isValidBall(testStr));
        Assert.assertFalse(ToyValidator.isValidCube(testStr));
        Assert.assertFalse(ToyValidator.isValidVehicle(testStr));
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