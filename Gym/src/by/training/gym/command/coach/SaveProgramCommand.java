package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.domain.Program;
import by.training.gym.service.ExerciseService;
import by.training.gym.service.ProgramService;
import by.training.gym.service.ServiceException;
import by.training.gym.service.validator.ProgramValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.TreeMap;

import static by.training.gym.command.CurrentJsp.DESCRIBE_TRAINING_PROGRAM_PAGE_PATH;
import static by.training.gym.command.CurrentJsp.EDIT_PROGRAM_PAGE_PATH;
import static by.training.gym.view.MessageManager.*;

/**
 * Command to finish training program editing.
 * @author AlesyaHlushakova
 */
public class SaveProgramCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(SaveProgramCommand.class);

    /**
     * overrides command to finish training program creation.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            TreeMap<Integer, List<Exercise>> daysAndExercises = (TreeMap<Integer, List<Exercise>>) session.
                    getAttribute(DAYS_AND_EXERCISES_ATTRIBUTE);
            ProgramValidator trainingProgramDataValidator = new ProgramValidator();
            boolean isDaysAndExercisesCountValid = trainingProgramDataValidator.checkDaysAndExercisesCount(daysAndExercises);
            if (!isDaysAndExercisesCountValid) {
                return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH, false, PROGRAM_DAYS_AND_EXERCISES_NOT_VALID_MESSAGE_KEY);
            }

            Program trainingProgram = (Program) session.getAttribute(PROGRAM_ATTRIBUTE);
            int trainingProgramId = trainingProgram.getId();
            ProgramService trainingProgramService = new ProgramService();
            boolean isUpdateSuccessful = trainingProgramService.updateProgram(trainingProgram);

            ExerciseService exerciseService = new ExerciseService();
            boolean isResultSuccessful = exerciseService.addExercisesToTrainingProgram(trainingProgramId,
                    daysAndExercises, true);
            if (!isResultSuccessful || !isUpdateSuccessful) {
                return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH,
                        false, TRAINING_PROGRAM_NOT_SAVED_MESSAGE_KEY);
            }

            session.removeAttribute(EXERCISES_ATTRIBUTE);
            session.setAttribute(IS_RECORD_INSERTED, true);

            return new CurrentJsp(DESCRIBE_TRAINING_PROGRAM_PAGE_PATH, false, TRAINING_PROGRAM_SAVED_SUCCESSFUL_MESSAGE_KEY);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}

