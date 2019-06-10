package by.training.task03.controller;

/**
 * @author Alesyahulshakova
 * command interface.
 */
interface Command {
    /**
     * executed task.
     * @param request request
     * @return response
     */
    String execute(String request);
}
