package task15.States;

import static java.lang.String.format;
import static java.lang.System.out;
import static java.lang.Thread.currentThread;

public class NewAndRunnable {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> showTreadState(currentThread()));
        showTreadState(thread);
        thread.start();
    }

    private static void showTreadState(final Thread thread) {
        out.println(format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }

}
