package task15.states;

public class NewAndRunnable {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";

    public static void main(String[] args) {
        final Thread thread = new Thread(() -> showTreadState(Thread.currentThread()));
        showTreadState(thread);
        thread.start();
    }

    private static void showTreadState(final Thread thread) {
        System.out.println(String.format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }

}
