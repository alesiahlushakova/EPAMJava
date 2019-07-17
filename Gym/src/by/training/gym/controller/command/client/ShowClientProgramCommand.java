package by.training.gym.controller.command.client;

import by.training.gym.controller.command.CommandAction;
import by.training.gym.controller.command.CurrentJsp;
import by.training.gym.model.Exercise;
import by.training.gym.model.Program;
import by.training.gym.service.ProgramService;
import by.training.gym.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.controller.command.CurrentJsp.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.training.gym.view.MessageManager.INFORMATION_NOT_FOUND_MESSAGE_KEY;

public class ShowClientProgramCommand implements CommandAction {
    private static final Logger LOGGER = LogManager.getLogger(ShowClientProgramCommand.class);
    /**
     * overrides commands to show client'sprogram.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            int clientId = Integer.parseInt(clientIdValue);
            ProgramService trainingProgramService = new ProgramService();
            Program trainingProgram = trainingProgramService.findTrainingProgramById(clientId);

            if (trainingProgram == null) {
                return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false, INFORMATION_NOT_FOUND_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(PROGRAM_ATTRIBUTE, trainingProgram);

            int trainingProgramId = trainingProgram.getId();
            String authorName = trainingProgramService.findTrainingProgramAuthor(trainingProgramId);
            session.setAttribute(NAME_ATTRIBUTE, authorName);

            TreeMap<Integer, List<Exercise>> daysAndExercises = trainingProgramService.showExercisesFromProgram(trainingProgramId);
            session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, daysAndExercises);


            return new CurrentJsp(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
