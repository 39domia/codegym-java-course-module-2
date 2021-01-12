package oddEven;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new OddThread();
        Runnable runnable2 = new EvenThread();
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread.start();
        thread.join();
        thread2.start();
    }
}
