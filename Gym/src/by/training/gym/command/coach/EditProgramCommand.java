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

/**
 * Command to edit training program.
 * @author AlesyaHlushakova
 */
public class EditProgramCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(EditProgramCommand.class);

    /**
     * overrides commands to edit training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            ExerciseService exerciseService = new ExerciseService();
            List<Exercise> exercises = exerciseService.findAllExercisesIdAndName();

            HttpSession session = request.getSession();
            session.setAttribute(EXERCISES_ATTRIBUTE, exercises);

            return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            ;
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
