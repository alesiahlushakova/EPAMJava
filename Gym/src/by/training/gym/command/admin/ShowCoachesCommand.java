package by.training.gym.command.admin;

import by.training.gym.command.Command;
import by.training.gym.command.CurrentJsp;
import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static by.training.gym.command.CurrentJsp.SHOW_ALL_COACHES_PAGE_PATH;


/**
 * command that shows all coaches to admin.
 * @author AlesyaHlushakova
 */
public class ShowCoachesCommand  implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShowCoachesCommand.class);

    private static final int MAX_RECORDS_PER_PAGE_COUNT = 2;
    private static final int FIRST_PAGE_INDEX = 1;

    /**
     * overrides command to show all clients.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            int pageIndex = FIRST_PAGE_INDEX;

            String pageParameterValue = request.getParameter(PAGE_PARAMETER);

            if (pageParameterValue != null) {
                pageIndex = Integer.parseInt(pageParameterValue);
            }
            int currentOffSet = (pageIndex - 1) * MAX_RECORDS_PER_PAGE_COUNT;

            UserService userService = new UserService();
            Map<List<User>, Integer> coaches = userService.findAllCoachesByPages(currentOffSet, MAX_RECORDS_PER_PAGE_COUNT);
            Set<Map.Entry<List<User>, Integer>> entries = coaches.entrySet();

            List<User> foundCoaches = null;
            Integer numberOfRecords = null;

            for (Map.Entry<List<User>, Integer> entry : entries) {
                foundCoaches = entry.getKey();
                numberOfRecords = entry.getValue();
            }

            int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / MAX_RECORDS_PER_PAGE_COUNT);

            request.setAttribute(NUMBER_OF_PAGE_ATTRIBUTE, numberOfPages);
            request.setAttribute(CURRENT_PAGE_INDEX_ATTRIBUTE, pageIndex);
            request.setAttribute(LIST_ATTRIBUTE, foundCoaches);

            return new CurrentJsp(SHOW_ALL_COACHES_PAGE_PATH, false);
        } catch (ServiceException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
