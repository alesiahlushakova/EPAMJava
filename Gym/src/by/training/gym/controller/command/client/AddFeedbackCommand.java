package by.training.gym.controller.command.client;

import by.training.gym.controller.command.CommandAction;
import by.training.gym.controller.command.CurrentJsp;
import by.training.gym.model.Subscription;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.controller.command.CurrentJsp.ADD_FEEDBACK_PAGE_PATH;
import static by.training.gym.view.MessageManager.FEEDBACK_WAS_ADDED_MESSAGE_KEY;
import static by.training.gym.view.MessageManager.FEEDBACK_WAS_NOT_ADDED_MESSAGE_KEY;

/**
 * @author AlesyaHlushakova
 * command that add feedback.
 */
public class AddFeedbackCommand implements CommandAction {

    private static final Logger LOGGER = LogManager.getLogger(AddFeedbackCommand.class);

    /**
     * overrides command to add feedback about order.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            int orderId = (int) session.getAttribute(SUBSCRIPTION_ID_ATTRIBUTE);
            String feedback = request.getParameter(FEEDBACK_PARAMETER);

            SubscriptionService subscriptionService = new SubscriptionService();
            boolean isOperationSuccessful = subscriptionService.addFeedback(feedback, orderId);

            if (!isOperationSuccessful) {
                return new CurrentJsp(ADD_FEEDBACK_PAGE_PATH, false, FEEDBACK_WAS_NOT_ADDED_MESSAGE_KEY);
            }

            session.setAttribute(IS_RECORD_INSERTED, true);

            return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, FEEDBACK_WAS_ADDED_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
