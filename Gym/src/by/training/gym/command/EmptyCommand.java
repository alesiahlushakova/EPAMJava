package by.training.gym.command;

import javax.servlet.http.HttpServletRequest;

/**
 * empty command class.
 * @author AlesyaHlushakova
 */
public class EmptyCommand implements Command {

    /**
     * redirects to main page.
     * @param request HttpServletRequest object.
     * @return page.
     */
    public CurrentJsp execute(HttpServletRequest request) {
        return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH, false);
    }
}
