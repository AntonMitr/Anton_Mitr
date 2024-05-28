package task15;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class TwoThreads {

    public static void main(String[] args) {
        Thread firstThread = new Thread();
        Thread secondThread = new Thread();
        Thread mainThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SECONDS.sleep(1);
                    System.out.println(firstThread.getName());
                    SECONDS.sleep(1);
                    System.out.println(secondThread.getName() + "\n");
                } catch (InterruptedException interruptedException) {
                    System.out.println(interruptedException.getMessage());
                }
            }
        });
        mainThread.start();
    }
}
