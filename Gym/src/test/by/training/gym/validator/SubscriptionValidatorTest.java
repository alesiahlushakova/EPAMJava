package test.by.training.gym.validator;



import by.training.gym.service.validator.SubscriptionValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.time.LocalDate;


public class SubscriptionValidatorTest {

    private static final SubscriptionValidator ORDER_DATA_VALIDATOR = new SubscriptionValidator();
    private static String currentDateValue;

    @BeforeClass
    public static void setCurrentDateValue() {
        Date currentDate = Date.valueOf(LocalDate.now());
        currentDateValue = String.valueOf(currentDate);
    }

    @DataProvider
    public static Object[][] validData() {


        return new Object[][]{
                {currentDateValue, "MONTH", "1","18"},
                {currentDateValue, "MONTH", "0","22"},
                {currentDateValue, "WEEK", "1","21"},
                {currentDateValue, "YEAR", "1","30"}
        };
    }

    @DataProvider
    public static Object[][] notValidData() {
        return new Object[][]{
                {"", "MONTH", "1","0"},
                {null, "MONTH", "0","11"},
                {currentDateValue, "", "1","14"},
                {currentDateValue, null, "1", "55"},
                {currentDateValue, "ALL_LIFE", "1","10"},
                {currentDateValue, "MONTH", "2","15"},
                {currentDateValue, "WEEK", "","18"},
                {currentDateValue, "YEAR", null,"12"}
        };
    }

    @DataProvider
    public static Object[][] validFeedBacks() {
        return new Object[][]{
                {"Feedback"},
                {"all is good"},
                {"all is good, but at the 15-00 trainer was bad."}
        };
    }

    @DataProvider
    public static Object[][] notValidFeedBacks() {
        return new Object[][]{
                {""},
                {null},
                {"all is good,<alert(user.password)> but at he 15-00 trainer was bad."}
        };
    }

    @Test
    (dataProvider = "validFeedBacks")
    public void shouldFeedbackBeValid(String feedback) {
        boolean actualResult = ORDER_DATA_VALIDATOR.checkFeedback(feedback);

        Assert.assertTrue(actualResult);
    }

    @Test
    (dataProvider = "notValidFeedBacks")
    public void shouldFeedbackBeNotValid(String feedback) {
        boolean actualResult = ORDER_DATA_VALIDATOR.checkFeedback(feedback);

        Assert.assertFalse(actualResult);
    }

    @Test
    (dataProvider = "validData")
    public void shouldOrderDataValidationBeSuccessful(String purchaseDateValue, String durationValue, String isPersonalTrainerNeedValue, String ibmValue) {
        boolean actualResult = ORDER_DATA_VALIDATOR.checkSubcriptionData(purchaseDateValue, durationValue, isPersonalTrainerNeedValue, ibmValue);

        Assert.assertTrue(actualResult);
    }

    @Test
    (dataProvider = "notValidData")
    public void shouldOrderDataValidationFail(String purchaseDateValue, String durationValue, String isPersonalTrainerNeedValue, String ibmValue) {
        boolean actualResult = ORDER_DATA_VALIDATOR.checkSubcriptionData(purchaseDateValue, durationValue, isPersonalTrainerNeedValue, ibmValue);

        Assert.assertFalse(actualResult);
    }
}
