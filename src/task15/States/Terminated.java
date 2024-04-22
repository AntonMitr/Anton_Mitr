package task15.States;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.lang.Thread.currentThread;

public class Terminated {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> showTreadState(currentThread()));
        thread.start();
        thread.join();
        showTreadState(thread);
    }

    private static void showTreadState(final Thread thread) {
        out.println(format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }
}
