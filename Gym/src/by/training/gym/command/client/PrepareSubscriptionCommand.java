package by.training.gym.command.client;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Subscription;
import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.SubscriptionService;
import by.training.gym.service.validator.SubscriptionValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.command.CurrentJsp.PAY_SUBSCRIPTION_PAGE_PATH;
import static by.training.gym.command.CurrentJsp.PREPARE_ORDER_PAGE_PATH;
import static by.training.gym.view.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

public class PrepareSubscriptionCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(PrepareSubscriptionCommand.class);

    /**
     * overrides command to prepare order.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER_ATTRIBUTE);
            int clientId = user.getId();

            String purchaseDateValue = request.getParameter(PURCHASE_DATE_PARAMETER);
            String durationValue = request.getParameter(DURATION_PARAMETER);
            String isPersonalTrainerNeedValue = request.getParameter(IS_PERSONAL_TRAINER_NEED_PARAMETER);
            String ibmValue = request.getParameter(IBM_PARAMETER);
            SubscriptionValidator orderDataValidator = new SubscriptionValidator();
            boolean isDataValid = orderDataValidator.checkSubcriptionData(purchaseDateValue, durationValue, isPersonalTrainerNeedValue);
            if (!isDataValid) {
                LOGGER.info(String.format("Data: %s, %s, %s is not valid", purchaseDateValue, durationValue, isPersonalTrainerNeedValue));
                return new CurrentJsp(PREPARE_ORDER_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            SubscriptionService subscriptionService = new SubscriptionService();
            Subscription subscription = subscriptionService.prepareSubscription(clientId, purchaseDateValue, durationValue, ibmValue, isPersonalTrainerNeedValue);
            session.setAttribute(SUBSCRIPTION_ATTRIBUTE, subscription);

            return new CurrentJsp(PAY_SUBSCRIPTION_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}