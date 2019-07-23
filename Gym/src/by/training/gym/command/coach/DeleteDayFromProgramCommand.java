package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.service.ProgramService;
import by.training.gym.service.validator.ProgramValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.view.MessageManager.DAY_CAN_NOT_BE_DELETED_MESSAGE_KEY;

/**
 * Command to delete day from training program.
 * @author AlesyaHlushakova
 */
public class DeleteDayFromProgramCommand implements Command {

    /**
     * overrides command to delete day from training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        String dayNumberValue = request.getParameter(DAY_NUMBER_PARAMETER);
        HttpSession session = request.getSession();
        TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.
                getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
        ProgramValidator trainingProgramDataValidator = new ProgramValidator();
        boolean isDataValid = trainingProgramDataValidator.checkDaysCountForDeleteOperation(daysAndExercises);
        if (!isDataValid) {
            return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false, DAY_CAN_NOT_BE_DELETED_MESSAGE_KEY);
        }

        ProgramService trainingProgramService = new ProgramService();
        TreeMap<Integer, List<Exercise>> changedDaysAndExercises = trainingProgramService.
                deleteDayFromTrainingProgram(dayNumberValue, daysAndExercises);

        session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, changedDaysAndExercises);

        return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false);
    }
}
