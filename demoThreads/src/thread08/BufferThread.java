package thread08;

public class BufferThread {
    static int counter = 0;
    static StringBuffer s = new StringBuffer();
    public static void main(String args[ ]) throws InterruptedException {
        new Thread() {
            public void run() {
                synchronized (s) {
                    while (BufferThread.counter++ < 3) {
                        s.append("A");
                        System.out.print("> " + counter + " ");
                        System.out.println(s);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } // конец synchronized-блока55
            }
        }.start();
        Thread.sleep(100);
        while (BufferThread.counter++ < 6) {
            System.out.print("< " + counter + " ");
// в этом месте поток main будет ждать освобождения блокировки объекта s
            s.append("B");
            System.out.println(s);
        }
    }
}