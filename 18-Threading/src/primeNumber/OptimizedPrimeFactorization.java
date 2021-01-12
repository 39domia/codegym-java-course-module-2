package primeNumber;

public class OptimizedPrimeFactorization implements Runnable{
    @Override
    public void run() {
        findPrimeNumber();
    }

    public void findPrimeNumber() {
        int number = 1000;
        for (int i = 2; i < Math.sqrt(number); i++) {
            System.out.println(number + " không là số nguyên tố (optimize)");
            return;
        }
        System.out.println(number + " là số nguyên tố");
    }
}
