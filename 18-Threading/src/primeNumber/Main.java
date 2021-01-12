package primeNumber;


public class Main {
    public static void main(String[] args) {
        Runnable runnable = new LazyPrimeFactorization();
        Runnable runnable2 = new OptimizedPrimeFactorization();
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable2);
        thread.start();
        thread2.start();
    }
}
