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

import static by.training.gym.command.CurrentJsp.SHOW_CLIENT_ORDERS_PAGE_PATH;
import static by.training.gym.view.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
 * Command to show subs.
 * @author AlesyaHlushakova
 */
public class ShowClientSubscriptionCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ShowClientSubscriptionCommand.class);

    /**
     * overrides commands to find subs of client.
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            int clientId = (int) session.getAttribute(CLIENT_ID_PARAMETER);
            SubscriptionService orderService = new SubscriptionService();
            List<Subscription> orderList = orderService.findAllClientSubscriptions(clientId);

            if (orderList.isEmpty()) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            request.setAttribute(LIST_ATTRIBUTE, orderList);

            return new CurrentJsp(SHOW_CLIENT_ORDERS_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}