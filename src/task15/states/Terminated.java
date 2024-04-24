package task15.states;

public class Terminated {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> showTreadState(Thread.currentThread()));
        thread.start();
        thread.join();
        showTreadState(thread);
    }

    private static void showTreadState(final Thread thread) {
        System.out.println(String.format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }
}
