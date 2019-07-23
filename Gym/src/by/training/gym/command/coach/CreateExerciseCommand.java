package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ExerciseService;
import by.training.gym.service.ServiceException;
import by.training.gym.service.validator.ExerciseValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.training.gym.command.CurrentJsp.CREATE_EXERCISE_PAGE_PATH;
import static by.training.gym.command.CurrentJsp.SHOW_EXERCISE;
import static by.training.gym.view.MessageManager.EXERCISE_CREATION_FAILED_MESSAGE_KEY;
import static by.training.gym.view.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to create exercise in database.
 * @author AlesyaHlushakova
 */
public class CreateExerciseCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CreateExerciseCommand.class);

    /**
     * overrides command to create exercise in database.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            String name = request.getParameter(NAME_PARAMETER);
            String restrictions = request.getParameter(RESTRICTIONS_PARAMETER);
            int caloriesLost = Integer.parseInt(request.getParameter(CALORIES_LOST_PARAMETER));
            String levelValue = request.getParameter(LEVEL_PARAMETER);
            String description = request.getParameter(DESCRIPTION_PARAMETER);
            ExerciseValidator exerciseDataValidator = new ExerciseValidator();
            boolean isDataValid = exerciseDataValidator.checkData(name,restrictions, caloriesLost, levelValue, description);

            if (!isDataValid) {
                return new CurrentJsp(CREATE_EXERCISE_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            ExerciseService exerciseService = new ExerciseService();
            Exercise exercise = exerciseService.createExercise(name, restrictions, caloriesLost, levelValue, description);
            boolean isOperationSuccessful = exerciseService.saveExercise(exercise);
            if (!isOperationSuccessful) {
                return new CurrentJsp(CREATE_EXERCISE_PAGE_PATH, false, EXERCISE_CREATION_FAILED_MESSAGE_KEY);
            }

            HttpSession session = request.getSession();
            session.setAttribute(IS_RECORD_INSERTED, true);
            request.setAttribute(EXERCISE_ATTRIBUTE, exercise);

            return new CurrentJsp(SHOW_EXERCISE, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}

