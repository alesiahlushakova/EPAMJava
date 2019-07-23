package by.training.gym.command.client;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.service.ProgramService;
import by.training.gym.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.command.CurrentJsp.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.training.gym.view.MessageManager.DISCARD_PROGRAM_FAILED_MESSAGE_KEY;
import static by.training.gym.view.MessageManager.DISCARD_PROGRAM_SUCCESS_MESSAGE_KEY;

/**
 * Command to discard training program.
 * @author AlesyaHlushakova
 */
public class DiscardProgramCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(DiscardProgramCommand.class);

    /**
     * overrides command to refuse training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            String trainingProgramIdValue = request.getParameter(TRAINING_PROGRAM_ID_PARAMETER);
            int trainingProgramId = Integer.parseInt(trainingProgramIdValue);
            ProgramService trainingProgramService = new ProgramService();
            boolean isOperationSuccessful = trainingProgramService.discardProgram(trainingProgramId);
            if (!isOperationSuccessful) {
                return new CurrentJsp(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH,
                        false, DISCARD_PROGRAM_FAILED_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(IS_RECORD_INSERTED, true);
            session.removeAttribute(PROGRAM_ATTRIBUTE);

            return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH,
                    false, DISCARD_PROGRAM_SUCCESS_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
