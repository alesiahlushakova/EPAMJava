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
     */
    public void executeTask(final String request) {
        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);

        String response;
        executionCommand.execute(request);


    }


}
