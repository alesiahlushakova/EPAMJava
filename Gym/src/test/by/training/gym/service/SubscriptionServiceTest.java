package test.by.training.gym.service;

import by.training.gym.domain.Subscription;
import by.training.gym.domain.SubscriptionType;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;




public class SubscriptionServiceTest {

    SubscriptionService subscriptionService;
    Subscription subscription1;
    Subscription subscription2;
    Subscription subscription3;
    Subscription subscription4;
    Subscription subscription5;
    Subscription subscription6;
    List<List<Subscription>> subList = new ArrayList<>();
    List<Subscription> emptyList = new ArrayList<>();
    @BeforeMethod
    public void setUp() {
        subscriptionService = new SubscriptionService();
        subscription1 = new Subscription();
        subscription1.setClientId(7);
        subscription1.setPurchaseDate(Date.valueOf("2019-08-05"));
        subscription1.setEndDate(Date.valueOf("2019-08-12"));
        subscription1.setSubscriptionType(SubscriptionType.WEEK);
        subscription1.setIbm(17);
        subscription1.setPrice(BigDecimal.valueOf(80));
        subscription1.setCoachNeeded(0);

        subscription2 = new Subscription();
        subscription2.setClientId(8);
        subscription2.setPurchaseDate(Date.valueOf("2019-06-05"));
        subscription2.setEndDate(Date.valueOf("2019-06-12"));
        subscription2.setSubscriptionType(SubscriptionType.WEEK);
        subscription2.setIbm(22);
        subscription2.setPrice(BigDecimal.valueOf(120));
        subscription2.setCoachNeeded(1);

        subscription3 = new Subscription();
        subscription3.setClientId(5);
        subscription3.setPurchaseDate(Date.valueOf("2019-08-05"));
        subscription3.setEndDate(Date.valueOf("2020-08-04"));
        subscription3.setSubscriptionType(SubscriptionType.YEAR);
        subscription3.setIbm(19);
        subscription3.setPrice(BigDecimal.valueOf(300));
        subscription3.setCoachNeeded(0);

        subscription4 = new Subscription();
        subscription4.setClientId(6);
        subscription4.setPurchaseDate(Date.valueOf("2019-08-05"));
        subscription4.setEndDate(Date.valueOf("2019-09-04"));
        subscription4.setSubscriptionType(SubscriptionType.MONTH);
        subscription4.setIbm(17);
        subscription4.setPrice(BigDecimal.valueOf(220));
        subscription4.setCoachNeeded(1);

        subscription5 = new Subscription();
        subscription5.setClientId(3);
        subscription5.setPurchaseDate(Date.valueOf("2019-07-15"));
        subscription5.setEndDate(Date.valueOf("2019-07-22"));
        subscription5.setSubscriptionType(SubscriptionType.WEEK);
        subscription5.setIbm(20);
        subscription5.setPrice(BigDecimal.valueOf(80));
        subscription5.setCoachNeeded(1);
        subscription5.setIsPayed(1);
        subscription5.setFeedback("I am glad to find that amazing place");

        subscription6 = new Subscription();
        subscription6.setClientId(4);
        subscription6.setPurchaseDate(Date.valueOf("2019-07-27"));
        subscription6.setEndDate(Date.valueOf("2019-08-26"));
        subscription6.setSubscriptionType(SubscriptionType.MONTH);
        subscription6.setIbm(22);
        subscription6.setIsPayed(1);
        subscription6.setPrice(BigDecimal.valueOf(220));
        subscription6.setCoachNeeded(1);

        subList.add(Arrays.asList(subscription5));
        subList.add(Arrays.asList(subscription6));
        subList.add(emptyList);


    }

    @DataProvider(name = "prepareSubscriptionProvider")
    public Object[][] dataProviderTestPrepareSubscription() {
        return new Object[][]{{7, "2019-08-05",
        "WEEK", "17", "0", subscription1},
                {8, "2019-06-05",
                        "WEEK", "22", "1", subscription2},
                {5, "2019-08-05",
                        "YEAR", "19", "0", subscription3},
                {6, "2019-08-05",
                        "MONTH", "17", "1", subscription4},

        };
    }

    @Test
    public void testHasClientActualSubscriptionTrue() throws ServiceException {
        Assert.assertFalse(subscriptionService.hasClientActualSubscription("4"));
    }

    @Test
    public void testHasClientActualSubscriptionFalse() throws ServiceException {
        Assert.assertFalse(subscriptionService.hasClientActualSubscription("3"));
    }


    @Test(dataProvider = "prepareSubscriptionProvider")
    public void testPrepareSubscription(final int clientId, final String purchaseDate,
                                        final String durationValue, final String ibmValue,
                                        final String coachNeeded, final Subscription actual)
            throws ServiceException{
        Subscription expected = subscriptionService.prepareSubscription(clientId,
                purchaseDate, durationValue,
                ibmValue, coachNeeded);
        Assert.assertEquals(actual, expected);
    }



    @Test
    public void testFindAllClientSubscriptions()
            throws ServiceException {
        List<List<Subscription>> expected = new ArrayList<>();
        expected.add(subscriptionService.findAllClientSubscriptions(3));
        expected.add(subscriptionService.findAllClientSubscriptions(4));
        expected.add(subscriptionService.findAllClientSubscriptions(1));
        Assert.assertEquals(subList, expected);
    }
}