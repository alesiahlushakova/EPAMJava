package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.view.MessageManager.DAY_ADD_FAILED_MESSAGE_KEY;

/**
 * Command to add day into training program.
 * @author AlesyaHlushakova
 */
public class AddDayToProgramCommand implements Command {

    /**
     * overrides command to add day into training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.
                getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        ProgramService trainingProgramService = new ProgramService();
        boolean isOperationSuccessful = trainingProgramService.addDayInTrainingProgram(daysAndExercises);
        if (!isOperationSuccessful) {
            return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH,
                    false, DAY_ADD_FAILED_MESSAGE_KEY);
        }

        return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false);
    }
}
