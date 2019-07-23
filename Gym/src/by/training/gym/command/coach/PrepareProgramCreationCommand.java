package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static by.training.gym.command.CurrentJsp.CREATE_TRAINING_PROGRAM_PAGE_PATH;
import static by.training.gym.command.CurrentJsp.MAIN_PAGE_PATH;
import static by.training.gym.view.MessageManager.NO_CLIENT_FOR_TRAINING_PROGRAM_CREATION_MESSAGE_KEY;

/**
 * Command to prepare page for creation training program.
 * @author AlesyaHlushakova
 */
public class PrepareProgramCreationCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(PrepareProgramCreationCommand.class);

    /**
     * overrides command to prepare page for creation training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            UserService userService = new UserService();
            Map<Integer, String> clientsIdAndName = userService.findClientsForProgramCreation();
            if (clientsIdAndName.isEmpty()) {
                return new CurrentJsp(MAIN_PAGE_PATH, false, NO_CLIENT_FOR_TRAINING_PROGRAM_CREATION_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(LIST_ATTRIBUTE, clientsIdAndName);

            return new CurrentJsp(CREATE_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
