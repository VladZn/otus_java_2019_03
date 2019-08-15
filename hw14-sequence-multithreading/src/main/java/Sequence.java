/**
 * @author V. Zinchenko
 */
public class Sequence {
    private static final Object monitor = new Object();
    private static final int SEQ_MAX = 10;
    private static final int SEQ_MIN = 1;
    private static final int ITERATIONS_LIMIT = 6;
    private String currentThreadId = "1";

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        new Thread(() -> sequence.go("1")).start();
        new Thread(() -> sequence.go("2")).start();
    }

    private void go(String id) {
        int i = 1;
        int delta = 1;
        int iteration = 1;
        while (iteration <= ITERATIONS_LIMIT) {
            synchronized (monitor) {
                try {
                    while (currentThreadId.equals(id)) {
                        monitor.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    currentThreadId = id;
                    i = i + delta;
                    if (i == SEQ_MAX || i == SEQ_MIN) {
                        delta = -delta;
                        iteration++;
                    }
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + i);
    }

}
