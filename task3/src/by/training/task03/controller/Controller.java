package by.training.task03.controller;

/**
 * @author AlesuaHlushakova
 * class controller.
 */
public class Controller {
    /**
     * provider.
     */
    private final CommandProvider provider = new CommandProvider();
    /**
     * space.
     */
    private final char paramDelimeter = ' ';

    /**
     * execution method.
     * @param request request
     * @return response
     */
    public String executeTask(String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
