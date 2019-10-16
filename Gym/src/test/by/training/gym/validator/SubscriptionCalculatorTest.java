package test.by.training.gym.validator;




import by.training.gym.domain.SubscriptionType;
import by.training.gym.service.SubscriptionCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;

public class SubscriptionCalculatorTest {

    private static final SubscriptionCalculator ORDER_CALCULATOR = new SubscriptionCalculator();

    @DataProvider
    public static Object[][] validDataForEndDateCalculateOperation() {
        return new Object[][]{
                {SubscriptionType.MONTH, Date.valueOf("2019-02-01"), Date.valueOf("2019-02-31")},
                {SubscriptionType.WEEK, Date.valueOf("2019-02-01"), Date.valueOf("2019-02-08")},
                {SubscriptionType.YEAR, Date.valueOf("2019-02-01"), Date.valueOf("2020-02-01")}
        };
    }

    @DataProvider
    public static Object[][] notValidDataForEndDateCalculateOperation() {
        return new Object[][]{
                {SubscriptionType.MONTH, Date.valueOf("2019-02-01"), Date.valueOf("2019-02-29")},
                {SubscriptionType.WEEK, Date.valueOf("2019-02-01"), Date.valueOf("2019-09-02")},
                {SubscriptionType.YEAR, Date.valueOf("2019-02-01"), Date.valueOf("2021-02-01")}
        };
    }

    @DataProvider
    public static Object[][] validDataForDiscountCalculateOperation() {
        return new Object[][]{
                {new BigDecimal(100), 10, new BigDecimal(90)},
                {new BigDecimal(100), 20, new BigDecimal(80)},
                {new BigDecimal(100), 50, new BigDecimal(50)}
        };
    }

    @DataProvider
    public static Object[][] notValidDataForDiscountCalculateOperation() {
        return new Object[][]{
                {new BigDecimal(100), 10, new BigDecimal(95)},
                {new BigDecimal(100), 20, new BigDecimal(81)},
                {new BigDecimal(100), 50, new BigDecimal(55)}
        };
    }

    @Test
   (dataProvider = "validDataForEndDateCalculateOperation")
    public void shouldEndDateCalculateOperationBeSuccessful(SubscriptionType duration, Date startDate, Date endDate) {
        Date actualDate = ORDER_CALCULATOR.calculateExpirationDate(duration, startDate);

        Assert.assertEquals(endDate, actualDate);
    }

    @Test
   (dataProvider = "notValidDataForEndDateCalculateOperation")
    public void shouldEndDateCalculateOperationFail(SubscriptionType duration, Date startDate, Date endDate) {
        Date actualDate = ORDER_CALCULATOR.calculateExpirationDate(duration, startDate);

        Assert.assertNotEquals(endDate, actualDate);
    }

    @Test
    (dataProvider = "validDataForDiscountCalculateOperation")
    public void shouldDiscountCalculateOperationBeSuccessful(BigDecimal price, int discount, BigDecimal expectedPrice) {
        BigDecimal actualPrice = ORDER_CALCULATOR.calculatePrice(price, discount);

        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    (dataProvider = "notValidDataForDiscountCalculateOperation")
    public void shouldDiscountCalculateOperationFail(BigDecimal price, int discount, BigDecimal expectedPrice) {
        BigDecimal actualPrice = ORDER_CALCULATOR.calculatePrice(price, discount);

        Assert.assertNotEquals(expectedPrice, actualPrice);
    }

}
