package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Exercise;
import by.training.gym.domain.Program;
import by.training.gym.domain.User;
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

import static by.training.gym.command.CurrentJsp.CREATE_TRAINING_PROGRAM_PAGE_PATH;
import static by.training.gym.command.CurrentJsp.EDIT_PROGRAM_PAGE_PATH;
import static by.training.gym.view.MessageManager.INVALID_INPUT_DATA_MESSAGE_KEY;

/**
 * Command to create training program.
 * @author AlesyaHlushakova
 */
public class CreateProgramCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CreateProgramCommand.class);

    /**
     * overrides command to create training program in database.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(USER_ATTRIBUTE);
            int authorId = user.getId();

            String clientIdValue = request.getParameter(CLIENT_ID_PARAMETER);
            String startDateValue = request.getParameter(START_DATE_PARAMETER);
            String endDateValue = request.getParameter(END_DATE_PARAMETER);
            String diet = request.getParameter(DIET_PARAMETER);
            String daysCountValue = request.getParameter(DAYS_COUNT_PARAMETER);
            ProgramValidator trainingProgramDataValidator = new ProgramValidator();
            boolean isDataValid = trainingProgramDataValidator.checkTrainingProgramData(clientIdValue, startDateValue, endDateValue, diet, daysCountValue);
            if (!isDataValid) {
                return new CurrentJsp(CREATE_TRAINING_PROGRAM_PAGE_PATH, false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }

            ProgramService trainingProgramService = new ProgramService();
            Program trainingProgram = trainingProgramService.createProgram(authorId, clientIdValue, diet, startDateValue, endDateValue);
            session.setAttribute(PROGRAM_ATTRIBUTE, trainingProgram);

            ExerciseService exerciseService = new ExerciseService();
            List<Exercise> exercises = exerciseService.findAllExercisesIdAndName();
            session.setAttribute(EXERCISES_ATTRIBUTE, exercises);


            TreeMap<Integer, List<Exercise>> daysAndExercises = trainingProgramService.getDaysAndExerciseFromTrainingProgram(daysCountValue);
            session.setAttribute(DAYS_AND_EXERCISES_ATTRIBUTE, daysAndExercises);

            return new CurrentJsp(EDIT_PROGRAM_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
