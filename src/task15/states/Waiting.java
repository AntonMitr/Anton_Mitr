package task15.states;

public class Waiting {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";
    private static final int MILLISECONDS_TO_SLEEP_IN_MAIN = 1000;

    public static void main(String[] args) throws InterruptedException {
        final Thread mainThread = Thread.currentThread();
        final Thread thread = new Thread(() -> {
            try {
                mainThread.join();
            } catch (final InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        });
        thread.start();
        Thread.sleep(MILLISECONDS_TO_SLEEP_IN_MAIN);
        showTreadState(thread);
    }

    private static void showTreadState(final Thread thread) {
        System.out.println(String.format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }

}
