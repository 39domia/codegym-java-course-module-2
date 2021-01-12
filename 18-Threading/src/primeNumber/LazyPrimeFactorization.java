package primeNumber;

public class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        findPrimeNumber();
    }

    public void findPrimeNumber() {
        int number = 1000;
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                System.out.println(number + " không là số nguyên tố (lazy)");
            return;
        }
        System.out.println(number + " là số nguyên tố");
    }
}
