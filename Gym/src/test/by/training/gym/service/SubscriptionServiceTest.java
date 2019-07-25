package test.by.training.gym.service;

import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SubscriptionServiceTest {

    SubscriptionService subscriptionService;
    @BeforeMethod
    public void setUp() {
        subscriptionService = new SubscriptionService();
    }

    @Test
    public void testHasClientActualSubscription() throws ServiceException {
        Assert.assertTrue(subscriptionService.hasClientActualSubscription("4"));
    }

    @Test
    public void testAddFeedback() {
    }

    @Test
    public void testPaySubscription() {
    }

    @Test
    public void testPrepareSubscription() {
    }

    @Test
    public void testFindAllClientSubscriptions() {
    }
}