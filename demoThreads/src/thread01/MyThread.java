package thread01;

public class MyThread extends Thread {
    public void run() {
        System.out.println("Hello Worlds");
    }
    public static void main (String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
