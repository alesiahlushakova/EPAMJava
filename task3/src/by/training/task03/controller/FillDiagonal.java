package by.training.task03.controller;

import by.training.task03.exception.MatrixException;
import by.training.task03.service.FillDiagonalThread;
import by.training.task03.service.ThreadReader;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Alesyahlushakova
 */
public class FillDiagonal implements Command {
    /**
     * fills diagonal.
     * @param request request
     * @return response
     */
    @Override
    public String execute(String request) {
        try {
            ThreadReader threadReader = new ThreadReader();
            String source = threadReader.read("data\\numbers.txt");
            Scanner scanner = new Scanner(source);
            ReentrantLock locker = new ReentrantLock();
            for(int i = 0; i < 6; i ++) {
                Thread thread = new Thread(new FillDiagonalThread(locker,scanner.nextInt()));
                thread.setName("Thread" + i);
                thread.start();
            }
        } catch (MatrixException e) {
         return null;
        }

        return "Matrix diagonal filled";
    }
}
