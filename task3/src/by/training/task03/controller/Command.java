package by.training.task03.controller;

/**
 * @author Alesyahulshakova
 * command interface.
 */
public interface Command {
    /**
     * executed task.
     * @param request request
     * @return response
     */
    public String execute(String request);
}
