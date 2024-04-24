package task15.states;

public class Blocked {

    private static final String THREAD_NAME_AND_STATE = "%s : %s";

    public static void main(String[] args) {
        final Thread first = new Thread(() -> getSomething(Thread.currentThread()));
        final Thread second = new Thread(() -> getSomething(Thread.currentThread()));
        first.start();
        second.start();
        showTreadState(first);
        showTreadState(second);
    }

    private static synchronized void getSomething(final Thread thread) {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException.getMessage());
            }
        }
    }

    private static void showTreadState(final Thread thread) {
        System.out.println(String.format(THREAD_NAME_AND_STATE, thread.getName(), thread.getState()));
    }
}
