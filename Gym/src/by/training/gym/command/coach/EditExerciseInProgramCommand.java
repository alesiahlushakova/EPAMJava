package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ExerciseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static by.training.gym.command.CurrentJsp.EDIT_PROGRAM_PAGE_PATH;
import static by.training.gym.view.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to edit exercise in training program.
 * @author AlesyaHlushakova
 */
public class EditExerciseInProgramCommand implements Command {

    /**
     * overrides command to edit exercise in training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        String setsCountValue = request.getParameter(SETS_COUNT_PARAMETER);
        String repeatsCountValue = request.getParameter(REPEATS_COUNT_PARAMETER);
        String weightLossValue = request.getParameter(WEIGHT_LOSS_PARAMETER);

        HttpSession session = request.getSession();
        Map<Integer, List<Exercise>> daysAndExercises = (Map<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);

        ExerciseService exerciseService = new ExerciseService();
        boolean isOperationSuccessful = exerciseService.editExercise(exerciseIdValue, dayNumberValue, weightLossValue, setsCountValue, repeatsCountValue, daysAndExercises);
        if (!isOperationSuccessful) {
            return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
        }

        return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH, false);
    }
}
