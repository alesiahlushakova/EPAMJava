package thread01;

public class RunnablePerson extends Person implements Runnable {
    public RunnablePerson (String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i<10; i++) {
            System.out.println(getName() + ": Hello World");

        }
    }
    public static void main(String[] args) {
        RunnablePerson p1 = new RunnablePerson("Alice");
        Thread t1 = new Thread(p1);
        t1.start();
        RunnablePerson p2 = new RunnablePerson("Bob");
        Thread t2 = new Thread(p2);
        t2.start();
    }
}
