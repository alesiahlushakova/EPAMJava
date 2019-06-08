package by.training.task03.controller;

import by.training.task03.exception.MatrixException;
import by.training.task03.service.MatrixServiceImpl;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

/**
 * @author AlesyaHlushakova
 */
public class WriteToFile implements Command {
    /**
     * writes to file.
     * @param request request
     * @return response
     */
    @Override
    public String execute(String request) {
        try {
            MatrixServiceImpl matrixService = new MatrixServiceImpl();
            matrixService.writeToFile("data\\writtenMatrix.txt");
            return "Matrix written to file";
        } catch (MatrixException | IOException e) {
        return null;
        }
    }
}
