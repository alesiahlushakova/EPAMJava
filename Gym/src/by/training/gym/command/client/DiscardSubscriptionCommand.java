package by.training.gym.command.client;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Subscription;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static by.training.gym.command.CurrentJsp.MAIN_PAGE_PATH;
import static by.training.gym.view.MessageManager.*;

/**
 * Command to discard training program.
 * @author AlesyaHlushakova
 */
public class DiscardSubscriptionCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DiscardSubscriptionCommand.class);

    /**
     * overrides command to refuse training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            int subId = (int) session.getAttribute(SUBSCRIPTION_ID_ATTRIBUTE);
            SubscriptionService subscriptionService = new SubscriptionService();
            subscriptionService.findAllClientSubscriptions(subId);
            boolean isOperationSuccessful = subscriptionService.discardSubscription(subId);
            if (!isOperationSuccessful) {
                return new CurrentJsp(MAIN_PAGE_PATH,
                        false, DISCARD_SUB_FAILED_MESSAGE_KEY);
            }

            session.setAttribute(IS_RECORD_INSERTED, true);
            session.removeAttribute(PROGRAM_ATTRIBUTE);

            return new CurrentJsp(MAIN_PAGE_PATH,
                    false, DISCARD_SUB_SUCCESS_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}