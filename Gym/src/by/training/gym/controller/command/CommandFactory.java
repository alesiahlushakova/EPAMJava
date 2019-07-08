package by.training.gym.controller.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.training.gym.controller.command.CommandAction.COMMAND_PARAMETER;
import static by.training.gym.controller.command.CommandAction.MESSAGE_ATTRIBUTE;

/**
 * class for creation of the commands.
 * @author AlesyaHlushakova
 */
public class CommandFactory {

    private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

    /**
     * This method define commands and return it's instance.
     *
     * @param request the HttpServletRequest request.
     * @return the defined commands.
     */
    public CommandAction defineCommand(HttpServletRequest request) {
        CommandAction currentCommand = new EmptyCommand();

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
            /**
             * todo write message class.
             */
           // String message = String.format("%s %s", action, MessageManager.getProperty(COMMAND_ERROR_MESSAGE_KEY));
            //request.setAttribute(MESSAGE_ATTRIBUTE, message);
        }
        return currentCommand;
    }

}
