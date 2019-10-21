package by.training.gym.command;

import by.training.gym.domain.User;
import by.training.gym.service.ServiceException;
import by.training.gym.service.UserService;
import by.training.gym.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

import static by.training.gym.view.MessageManager.*;


public class EditProfileCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(EditProfileCommand.class);

    /**
     * command that edits user.
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public CurrentJsp execute(HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            String login = (String) session.getAttribute(LOGIN_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
            String lastName = request.getParameter(LAST_NAME_PARAMETER);
            String telephone = request.getParameter(TELEPHONE_PARAMETER);

            InputStream inputStream = null; // input stream of the upload file

            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("photo");
            if (filePart != null) {

                LOGGER.info(filePart.getName() +filePart.getSize()
                + filePart.getContentType());


                inputStream = filePart.getInputStream();
            }

            HttpSession currentSession = request.getSession();
            User user = (User)currentSession.getAttribute(USER_ATTRIBUTE);
            int clientId = user.getId();
            UserService userService = new UserService();


            UserValidator userDataValidator = new UserValidator();
            boolean isUserDataValid = userDataValidator.checkData(login, password,
                    firstName, lastName, telephone);
            if (!isUserDataValid) {
                return new CurrentJsp(CurrentJsp.EDIT_PAGE_PATH,
                        false, INVALID_INPUT_DATA_MESSAGE_KEY);
            }


            boolean isOperationSuccessful = userService.update(clientId, login, password,
                    firstName, lastName, telephone, inputStream);
            if (!isOperationSuccessful) {
                return new CurrentJsp(CurrentJsp.EDIT_PAGE_PATH,
                        false, EDITING_FAILED_MESSAGE_KEY);
            }

            return new CurrentJsp(CurrentJsp.LOGIN_PAGE_PATH, false,
                    EDIT_SUCCESSFUL_MESSAGE_KEY);

        } catch (ServiceException | IOException | ServletException exception) {
            LOGGER.error(exception.getMessage(), exception);
            return new CurrentJsp(CurrentJsp.ERROR_PAGE_PATH, true);
        }
    }
}
