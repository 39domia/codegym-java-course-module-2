package oddEven;

public class OddThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0)
                    System.out.println(i);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
