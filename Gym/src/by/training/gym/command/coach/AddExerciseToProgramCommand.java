package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ExerciseService;
import by.training.gym.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.view.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to add exercise to training program.
 * @author AlesyaHlushakova
 */
public class AddExerciseToProgramCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(AddExerciseToProgramCommand.class);

    /**
     * overrides command to add exercise to training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        try {
            String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
            String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
            String setsCountValue = request.getParameter(SETS_COUNT_PARAMETER);
            String repeatsCountValue = request.getParameter(REPEATS_COUNT_PARAMETER);
            String weightLossValue = request.getParameter(WEIGHT_LOSS_PARAMETER);
            HttpSession session = request.getSession();
            TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
            ExerciseService exerciseService = new ExerciseService();
            boolean isOperationSuccessful = exerciseService.addExerciseInTrainingProgram(exerciseIdValue, dayNumberValue,
                    weightLossValue, setsCountValue, repeatsCountValue, daysAndExercises);
            if (!isOperationSuccessful) {
                return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}