package by.training.task03.action;

import by.training.task03.entity.Matrix;
import by.training.task03.exception.MatrixException;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadToFillDiagonal implements Runnable {

    ReentrantLock locker;
    int number;
    ThreadToFillDiagonal(ReentrantLock lock, int number) {
        locker = lock;
        this.number = number;

    }

    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < Matrix.getInstance().getHorizontalSize();i++)  {
                for(int j = 0; j < Matrix.getInstance().getVerticalSize(); j++) {
                    if( i == j) {
                        Matrix.getInstance().setElement(i, j, number );
                    }
                }
            }
        }
        catch (MatrixException e) {

        }
    }
}
