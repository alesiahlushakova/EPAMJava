package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ExerciseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.command.CurrentJsp.EDIT_PROGRAM_PAGE_PATH;

/**
 * Command to delete exercise from training program.
 * @author AlesyaHlushakova
 */
public class DeleteExerciseFromProgramCommand implements Command {

    /**
     * overrides command to delete exercise from training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        String exerciseIdValue = request.getParameter(EXERCISE_ID_PARAMETER);
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        ExerciseService exerciseService = new ExerciseService();
        exerciseService.deleteExerciseFromTrainingProgram(exerciseIdValue, dayNumberValue, daysAndExercises);

        return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH, false);
    }
}
