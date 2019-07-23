package by.training.gym.command.client;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.training.gym.view.MessageManager.CLIENT_HAS_ALREADY_ORDER_MESSAGE_KEY;

public class CheckActualSubscriptionCommand implements Command {

    private static final Logger LOGGER = LogManager.
            getLogger(CheckActualSubscriptionCommand.class);

    /**
     * overrides command to check client for having actual sub before making new one.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        try {
            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            SubscriptionService orderService = new SubscriptionService();
            boolean hasClientActualOrder = orderService.hasClientActualSubscription(clientIdValue);

            if (hasClientActualOrder) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH,
                        false, CLIENT_HAS_ALREADY_ORDER_MESSAGE_KEY);
            }

            return new CurrentJsp(CurrentJsp.PREPARE_ORDER_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
