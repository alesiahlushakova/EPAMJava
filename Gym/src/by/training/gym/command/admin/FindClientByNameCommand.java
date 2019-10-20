package by.training.gym.command.admin;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.training.gym.command.CurrentJsp.DESCRIBE_CLIENT_PAGE_PATH;
import static by.training.gym.view.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

/**
 * Command to find client by name.
 * @author Alesyahlushakova
 */
public class FindClientByNameCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(FindClientByNameCommand.class);


    /**
     * overrides command to find user by name.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            String name = request.getParameter(NAME_PARAMETER);

            UserService userService = new UserService();
            List<User> findUsers = userService.findClientByName(name);

            if (findUsers.isEmpty()) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH,
                        false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            request.setAttribute(LIST_ATTRIBUTE, findUsers);


            return new CurrentJsp(DESCRIBE_CLIENT_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
