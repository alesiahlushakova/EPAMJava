package thread04.disable;

/**
 * TODO
 * make through interrupt.
 */
public class ThreadToDisable implements Runnable {
    private boolean isActive;

    void disable() {
        isActive = false;
    }

    ThreadToDisable() {
        isActive = true;
    }

    public void run() {
        System.out.printf("Поток %s начал работу...\n",
                Thread.currentThread().getName());
        int counter = 1;
        while (isActive) {
            System.out.println("Цикл" + counter++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Поток прерван");
            }
        }
        System.out.printf("Поток %s заверщил работу...\n",
                Thread.currentThread().getName());
    }
}
