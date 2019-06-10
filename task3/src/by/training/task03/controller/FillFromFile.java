package by.training.task03.controller;

import by.training.task03.service.MatrixServiceImpl;

/**
 * @author AlesyaHlushakova
 */
public class FillFromFile implements by.training.task03.controller.Command {
    /**
     * fills matrix from file.
     * @param request request
     * @return response
     */
    @Override
    public String execute(final String request) {

        MatrixServiceImpl matrixService = new MatrixServiceImpl();
        matrixService.fillFromFile("data\\data.txt");
        return "Matrix filled";
    }
}
