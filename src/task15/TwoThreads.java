package task15;

import static java.lang.System.out;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TwoThreads {

    public static void main(String[] args) {
        Thread firstThread = new Thread();
        Thread secondThread = new Thread();
        Thread mainThread = new Thread(() -> {
            while (!currentThread().isInterrupted()) {
                try {
                    SECONDS.sleep(1);
                    out.println(firstThread.getName());
                    SECONDS.sleep(1);
                    out.println(secondThread.getName() + "\n");
                } catch (InterruptedException interruptedException) {
                    out.println(interruptedException.getMessage());
                }
            }
        });
        mainThread.start();
    }
}
