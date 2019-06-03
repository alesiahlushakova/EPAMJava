package thread04.disable;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToDisable {
    public static void main(String[] args) {
        System.out.println("Главный поток начал работу...");
        ThreadToDisable myThread = new ThreadToDisable();
        Thread myT = new Thread(myThread,"name of ThreadToDisable");
        myT.start();
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
            myThread.disable();

        }
        catch(InterruptedException e){
            System.out.println("Поток прерван");
        }
        System.out.println("Главный поток завершил работу...");



    }
}