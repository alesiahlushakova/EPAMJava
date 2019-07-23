package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static by.training.gym.command.CurrentJsp.PERSONAL_CLIENTS_PAGE_PATH;
import static by.training.gym.view.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
        * Command to show all personal clients.
        * @author AlesyaHlushakova
        */
public class ShowPersonalClientsCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ShowPersonalClientsCommand.class);

    /**
     * overrides command to show all personal clients.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User coach = (User) session.getAttribute(USER_ATTRIBUTE);
            int coachId = coach.getId();

            UserService userService = new UserService();
            List<User> clients = userService.findPersonalClients(coachId);
            if (clients.isEmpty()) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            request.setAttribute(LIST_ATTRIBUTE, clients);

            return new CurrentJsp(PERSONAL_CLIENTS_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
