import by.training.task03.service.FillDiagonalThread;
import by.training.task03.controller.Controller;
import by.training.task03.entity.Matrix;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.executeTask("FILL_FROM_FILE ");
        controller.executeTask("WRITE_TO_FILE ");
        controller.executeTask("FILL_DIAGONAL ");

    }
}
