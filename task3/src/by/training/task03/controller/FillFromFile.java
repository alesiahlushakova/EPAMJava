package by.training.task03.controller;

import by.training.task03.service.MatrixService;
import by.training.task03.service.MatrixServiceImpl;

/**
 * @author AlesyaHlushakova
 */
public class FillFromFile implements Command {
    /**
     * fills matrix from file.
     * @param request request
     * @return response
     */
    @Override
    public String execute(String request) {

        MatrixServiceImpl matrixService = new MatrixServiceImpl();
        matrixService.fillFromFile("data\\data.txt");
        return "Matrix filled";
    }
}
