package by.training.gym.command.admin;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.command.Command.CLIENT_ID_PARAMETER;
import static by.training.gym.command.CurrentJsp.MAIN_PAGE_PATH;
import static by.training.gym.view.MessageManager.DISCARD_CLIENT_FAILED_MESSAGE_KEY;
import static by.training.gym.view.MessageManager.DISCARD_CLIENT_SUCCESS_MESSAGE_KEY;

/**
 * command that deletes client from db.
 * @author AlesyaHlushakova
 */
public class DeleteClientCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(DeleteClientCommand.class);

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

            UserService userService = new UserService();

            boolean isOperationSuccessful = userService.deleteUser(clientId);
            if (!isOperationSuccessful) {
                return new CurrentJsp(MAIN_PAGE_PATH,
                        false, DISCARD_CLIENT_FAILED_MESSAGE_KEY);
            }


            session.setAttribute(IS_RECORD_INSERTED, true);
            session.removeAttribute(PROGRAM_ATTRIBUTE);

            return new CurrentJsp(MAIN_PAGE_PATH,
                    false, DISCARD_CLIENT_SUCCESS_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(MAIN_PAGE_PATH,
                    false, DISCARD_CLIENT_SUCCESS_MESSAGE_KEY);
        }
    }
}
