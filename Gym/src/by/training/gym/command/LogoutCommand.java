package by.training.gym.command;

import by.training.gym.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    /**
     * current jsp.
     * @param request HttpServletRequest object
     * @return page
     */
    public CurrentJsp execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        String login = user.getLogin();

        session.invalidate();

        return new CurrentJsp(CurrentJsp.MAIN_PAGE_PATH,
                true);
    }
}
