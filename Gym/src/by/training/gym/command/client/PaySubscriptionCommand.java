package by.training.gym.command.client;

import by.training.gym.command.CommandAction;
import by.training.gym.command.CurrentJsp;
import by.training.gym.model.Subscription;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.view.MessageManager.SUBSCRIPTION_WAS_PAYED_MESSAGE_KEY;
import static by.training.gym.view.MessageManager.SUBSCRIPTION_WAS_NOT_PAYED_MESSAGE_KEY;

/**
        * Command to pay up the subscription.
        * @author AlesyaHlushakova
        */
public class PaySubscriptionCommand implements CommandAction {

    private static final Logger LOGGER = LogManager.getLogger(PaySubscriptionCommand.class);

    /**
     * overrides command to pay up the sub.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            Subscription subscription = (Subscription) session.getAttribute(SUBSCRIPTION_ATTRIBUTE);
            SubscriptionService subscriptionService = new SubscriptionService();
            boolean isOperationSuccessful = subscriptionService.paySubscription(subscription);
            if (!isOperationSuccessful) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, SUBSCRIPTION_WAS_NOT_PAYED_MESSAGE_KEY);
            }

            session.removeAttribute(SUBSCRIPTION_ATTRIBUTE);
            session.setAttribute(IS_RECORD_INSERTED, true);

            return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, SUBSCRIPTION_WAS_PAYED_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
