package by.training.gym.command;

import by.training.gym.view.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.training.gym.command.Command.COMMAND_PARAMETER;
import static by.training.gym.command.Command.MESSAGE_ATTRIBUTE;
import static by.training.gym.view.MessageManager.COMMAND_ERROR_MESSAGE_KEY;

/**
 * class for creation of the commands.
 * @author AlesyaHlushakova
 */
public class CommandFactory {

    private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

    /**
     * This method defines commands and return it's instance.
     *
     * @param request the HttpServletRequest request.
     * @return the defined commands.
     */
    public Command defineCommand(HttpServletRequest request) {
        Command currentCommand = new EmptyCommand();

        String action = request.getParameter(COMMAND_PARAMETER);
        if (action == null || action.isEmpty()) {
            LOGGER.info(String.format("Command - %s, is empty.", action));
            return currentCommand;
        }
        try {
            String commandTypeValue = action.toUpperCase();
            CommandType currentType = CommandType.valueOf(commandTypeValue);
            currentCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException exception) {
            LOGGER.warn(String.format("Command - %s, caused the exception.", action) + exception);

            String message = String.format("%s %s", action, MessageManager.getProperty(COMMAND_ERROR_MESSAGE_KEY));
            request.setAttribute(MESSAGE_ATTRIBUTE, message);
        }
        return currentCommand;
    }

}
