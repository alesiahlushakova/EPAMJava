package by.training.task03.service.thread;

import by.training.task03.entity.Matrix;
import by.training.task03.exception.MatrixException;
import  org.apache.logging.log4j.LogManager;
import  org.apache.logging.log4j.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class fills matrix diagonal with threads.
 */
public class FillDiagonalThread implements Runnable {
    /**
     * logger intro.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(FillDiagonalThread.class);
    /**
     * reentrant lock.
     */
    private ReentrantLock locker;
    /**
     * number that contains thread.
     */
    private int number;

    /**
     * constructor.
     * @param lock lock
     * @param number number in thread
     */
   public FillDiagonalThread(final ReentrantLock lock, final int number) {
        locker = lock;
        this.number = number;

    }

    /**
     * overrides method run.
     */
    @Override
    public void run() {


            for (int i = 0; i < Matrix.getInstance().getHorizontalSize(); i++) {
                for (int j = 0; j < Matrix.getInstance().
                        getVerticalSize(); j++) {
                    if (i == j) {
                        locker.lock();
                        try {
                            if (Matrix.getInstance().getElement(i, j) == 0) {
                                Matrix.getInstance().setElement(i, j, number);
                                TimeUnit.MILLISECONDS.sleep(100);
                                System.out.println(Thread.currentThread().
                                        getName() + Matrix.getInstance().
                                        toString());
                            }
                        } catch (MatrixException | InterruptedException e) {
                            LOGGER.error("Error setting matrix element. ");
                        } finally {
                            locker.unlock();
                        }
                    }
                }
            }

    }
}
