package by.training.task03.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlesyaHlushakova
 * command provider class.
 */
final class CommandProvider {
    /**
     * map for commands.
     */
    private final Map<CommandName, Command> repository = new HashMap<>();

    /**
     * constructor.
     */
    CommandProvider() {
        repository.put(CommandName.FILL_FROM_FILE, new FillFromFile());
        repository.put(CommandName.FILL_DIAGONAL, new FillDiagonal());
        repository.put(CommandName.WRITE_TO_FILE, new WriteToFile());
    }

    /**
     * getter for command.
     * @param name command name
     * @return command
     */
    Command getCommand(final String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {

        }
        return command;
    }
}
