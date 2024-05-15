package task15;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Time {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Thread thread = new Thread(() -> {
            n = sc.nextInt();
            while (!Thread.currentThread().isInterrupted()) {
                Date time = new Date();
                String thisTime = "%d:%d:%d".formatted(time.getHours(), time.getMinutes(), time.getSeconds());
                System.out.println(thisTime);
                try {
                    TimeUnit.SECONDS.sleep(n);
                } catch (InterruptedException interruptedException) {
                    System.out.println(interruptedException.getMessage());
                }
            }
        });
        thread.start();
    }
}
