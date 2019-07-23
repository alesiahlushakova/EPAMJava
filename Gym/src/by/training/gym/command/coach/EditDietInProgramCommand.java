package by.training.gym.command.coach;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.Program;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Command to edit diet in training program.
 * @author AlesyaHlushakova
 */
public class EditDietInProgramCommand implements Command {

    /**
     * overrides command to edit diet in training program.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {
        String diet = request.getParameter(DIET_PARAMETER);

        HttpSession session = request.getSession();
        Program trainingProgram = (Program) session.getAttribute(PROGRAM_ATTRIBUTE);
        trainingProgram.setDiet(diet);

        return new CurrentJsp(CurrentJsp.EDIT_PROGRAM_PAGE_PATH, false);
    }
}
