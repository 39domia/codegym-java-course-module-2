public class NumberGenerator implements Runnable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName() + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        NumberGenerator ng = new NumberGenerator();
        NumberGenerator ng2 = new NumberGenerator();
        ng.setName("thread 1: ");
        ng2.setName("thread 2: ");
        Thread thread = new Thread(ng);
        Thread thread2 = new Thread(ng2);
        thread.setPriority(10);
        thread2.setPriority(5);
        thread.start();
        thread2.start();
    }
}
