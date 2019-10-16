package test.by.training.gym.service;

import by.training.gym.service.DiscountService;
import by.training.gym.service.ServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DiscountServiceTest {

    @DataProvider (name = "shouldReturnValidDiscount")
        public Object[][] dataProviderShouldReturnValidDiscount() {
            return new Object[][] {{1},{2},{3},{4},{5}};
        }

    @Test (dataProvider = "shouldReturnValidDiscount")
    public void testGetDiscount(final int clientId) throws ServiceException {
        DiscountService discountService = new DiscountService();
        int actual = discountService.getDiscount(clientId);
        Assert.assertEquals(actual, 0);
    }
}