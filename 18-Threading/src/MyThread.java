public class MyThread  {
    //    public void run() {
//        long a = 0;
//        for (int i = 0; i < 10000; i++) {
//            a++;
//            System.out.println("a" + a);
//        }
//    }
    synchronized void printTable(int n) {// synchronized method
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

     public static void print(int a, int b){
        a = a+5;
        b += 4;
         System.out.println(a);
         System.out.println(b);
     }

    static public  void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(){
            public void run() {
                myThread.printTable(5);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                myThread.printTable(100);
            }
        };

//        t1.start();
//        t2.start();
        int a = 1;
        int b = 2;
        print(a, b);
//        System.out.println(a);
//        System.out.println(b);
    }
}

class MyThread2 implements Runnable {
    public void run() {
        long a = 0;
        for (int i = 0; i < 10000; i++) {
            a++;
            System.out.println("b" + a);
        }
    }
}
